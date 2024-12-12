/*******************************************************************
 *               DND Game Legends of Steel and Spellfire           *
 *                                                                 *
 * PROGRAMMER:Chloe Barber and Bella Brownlee                      *
 * COURSE: CS201                                                   *
 * DATE: 12/05/2024                                                *
 * REQUIREMENT: Final Project                                      *
 *                                                                 *
 * DESCRIPTION:                                                    *
 * The following program has a interface loop and methods that     *
 * runs a DND Campaign. Pixilart and StdDraw graphics are included *
 * for visualization.                                              *
 *                                                                 *
 * COPYRIGHT: This code is copyright (C) 2024 Chloe Barber, Bella  *
 * Brownlee, and Dean Zeller.                                      *
 *                                                                 *
 * CREDITS: This code was written with the help of Zach Cox,       *
 * pixilart, Pixabay music, and AI.                                *
 *                                                                 *
 ******************************************************************/
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//Audio packages
import javax.sound.sampled.*;
import javax.sound.sampled.Clip;

public class DnDParty {
    private ArrayList<Character> party;
    private ArrayList<Character> enemies;
    int accomplishment = 0;
    Scanner scan = new Scanner(System.in);
    public void interfaceLoop() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        while(accomplishment !=2){
            System.out.print("What do you want to do? --> ");
            String input = scan.nextLine();
            if(input.equals("S")){
                this.printStats();
            }
            else if(input.equals("D")){
                this.displayCharacter();

            }
            else if(input.equals("I")){
                this.inventory();

            }
            else if(input.equals("E")){
                if(accomplishment == 0){
                    System.out.println("Best of Luck on your Quest!");
                    this.encounter1();

                }
                else if (accomplishment == 1){
                    System.out.println("It seems like you ready for you next Quest...");
                    System.out.println("Best of Luck you're going to need it");
                    this.encounter2();
                }

                this.levelUp();

            }
            else if(input.equals("?")){
                this.displayMenu();
            }
        }
    }

    /**********************************************************
     * METHOD: displayMenu()                                  *
     * DESCRIPTION: displays the menu commands                *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    private void displayMenu () {
        System.out.println("Menu commands:");
        System.out.println("\tS – Check Party Members' Stats");
        System.out.println("\tD – Detailed information about a character ");
        System.out.println("\tI – Character's Inventory");
        System.out.println("\tE – Start Encounter");
        System.out.println("\t? – Display this menu");
        System.out.print("\n");
    }

    //Background
    /***********************************************************
     * METHOD: background()                                    *
     * DESCRIPTION: draws the background                       *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    public void background() {
        if(accomplishment == 0) {
            StdDraw.picture(0.50, 0.50, "/C:/Users/chloe/OneDrive/Desktop/DND photo/DND background1.jpg", 1.00, 1.0);
        }

        else if(accomplishment == 1){
            StdDraw.picture(0.50, 0.50, "C:/Users/chloe/OneDrive/Desktop/DND photo/DND Mountain Background.jpg", 1.00, 1.0);
        }
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(0.5, 0, 0.5, 0.18);
        text();
        //d4
        drawD4();
        //d6
        drawD6();
        //d8
        drawD8();
        // d10
        drawD10();
        //d12
        drawD12();
        //d20
        drawD20();
        StdDraw.setPenColor(StdDraw.WHITE);
    }

    /***********************************************************
     * METHOD: text()                                          *
     * DESCRIPTION: displays the text of the dice              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    public void text() {
        Font font = new Font("Righteous", Font.BOLD, 16);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(0.1077, 0.15, "d4");
        StdDraw.text(0.27, 0.15, "d6");
        StdDraw.text(0.43, 0.15, "d8");
        StdDraw.text(0.585, 0.15, "d10");
        StdDraw.text(0.73, 0.15, "d12");
        StdDraw.text(0.90, 0.15, "d20");
    }


    /***********************************************************
     * METHOD: rollD20()                                       *
     * DESCRIPTION: roll a d20 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d20 rolled value                      *
     **********************************************************/
    private int rollD20() {
        int d20 = (int) (Math.random() * 20) + 1;
        return d20;
    }

    /***********************************************************
     * METHOD: drawD20()                                       *
     * DESCRIPTION: draw a d20 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD20(){
        StdDraw.setPenColor(StdDraw.DICE_PURPLE);
        double[] d20x = {0.9, 0.8472649731, 0.8472649731, 0.9, 0.9527350269, 0.9527350269};
        double[] d20y = {0.01, 0.041, 0.086, 0.13, 0.086, 0.041};
        StdDraw.filledPolygon(d20x, d20y);
        StdDraw.setPenColor(StdDraw.DEEP_PURPLE);
        double[] shadow1d20x = {0.9, 0.8472649731, 0.8693589911};
        double[] shadow1d20y = {0.01, 0.041, 0.041};
        StdDraw.filledPolygon(shadow1d20x, shadow1d20y);
        double[] shadow2d20x = {0.9, 0.9527350269, 0.9306410089};
        double[] shadow2d20y = {0.01, 0.041, 0.041};
        StdDraw.filledPolygon(shadow2d20x, shadow2d20y);
        StdDraw.setPenColor(StdDraw.MID_PURPLE);
        double[] shadow3d20x = {0.8472649731, 0.8693589911, 0.8472649731};
        double[] shadow3d20y = {0.041, 0.041, 0.086};
        StdDraw.filledPolygon(shadow3d20x, shadow3d20y);
        double[] shadow4d20x = {0.9527350269, 0.9306410089, 0.9527350269};
        double[] shadow4d20y = {0.041, 0.041, 0.086};
        StdDraw.filledPolygon(shadow4d20x, shadow4d20y);
        double[] shadow5d20x = {0.9, 0.8693589911, 0.9306410089};
        double[] shadow5d20y = {0.01, 0.041, 0.041};
        StdDraw.filledPolygon(shadow5d20x, shadow5d20y);
        StdDraw.setPenColor(StdDraw.NEW_PURPLE);
        double[] shadow6d20x = {0.8693589911, 0.8472649731, 0.9};
        double[] shadow6d20y = {0.041, 0.086, 0.086};
        StdDraw.filledPolygon(shadow6d20x, shadow6d20y);
        double[] shadow7d20x = {0.9306410089, 0.9527350269, 0.9};
        double[] shadow7d20y = {0.041, 0.086, 0.086};
        StdDraw.filledPolygon(shadow7d20x, shadow7d20y);
        StdDraw.setPenColor(StdDraw.MID_PURPLE);
        double[] shadow8d20x = {0.8472649731, 0.9, 0.9527350269};
        double[] shadow8d20y = {0.086, 0.13, 0.086};
        StdDraw.filledPolygon(shadow8d20x, shadow8d20y);
    }

    /***********************************************************
     * METHOD: rollD12()                                       *
     * DESCRIPTION: roll a d12 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d12 rolled value                      *
     **********************************************************/
    private int rollD12() {
        int d12 = (int) (Math.random() * 12) + 1;
        return d12;
    }

    /***********************************************************
     * METHOD: drawD12()                                       *
     * DESCRIPTION: draw a d12 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD12(){
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        double[] d12x = {0.7871, 0.7653, 0.73, 0.6947, 0.6729, 0.6729, 0.6947, 0.73, 0.7653, 0.7871};
        double[] d12y = {0.0885, 0.1185, 0.13, 0.1185, 0.0885, 0.0515, 0.0215, 0.01, 0.0215, 0.0515};
        StdDraw.filledPolygon(d12x, d12y);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        double[] pentd12x = {0.73, 0.6967130219, 0.7094275162, 0.7505724838, 0.7632869781};
        double[] pentd12y = {0.105, 0.0808155948, 0.0416844052, 0.0416844052, 0.0808155948};
        StdDraw.filledPolygon(pentd12x, pentd12y);
        StdDraw.setPenColor(StdDraw.BLUE_DARK);
        double[] shadow1d12x = {0.6947, 0.7094275162, 0.7505724838, 0.7653, 0.73,};
        double[] shadow1d12y = {0.0215, 0.0416844052, 0.0416844052, 0.0215, 0.01};
        StdDraw.filledPolygon(shadow1d12x, shadow1d12y);
        StdDraw.setPenColor(StdDraw.BLUE_MID);
        double[] shadow2d12x = {0.6729, 0.6947, 0.73, 0.7653, 0.7871, 0.7632869781, 0.73, 0.6967130219};
        double[] shadow2d12y = {0.0885, 0.1185, 0.13, 0.1185, 0.0885, 0.0808155948, 0.105, 0.0808155948};
        StdDraw.filledPolygon(shadow2d12x, shadow2d12y);
        StdDraw.setPenColor(StdDraw.BLUE_SHADE);
        double[] shadow3d12x = {0.6947, 0.6729, 0.6729, 0.6967130219, 0.7094275162};
        double[] shadow3d12y = {0.0215, 0.0515, 0.0885, 0.0808155948, 0.0416844052};
        StdDraw.filledPolygon(shadow3d12x, shadow3d12y);
        double[] shadow4d12x = {0.7653, 0.7871, 0.7871, 0.7632869781, 0.7505724838};
        double[] shadow4d12y = {0.0215, 0.0515, 0.0885, 0.0808155948, 0.0416844052};
        StdDraw.filledPolygon(shadow4d12x, shadow4d12y);
    }

    /***********************************************************
     * METHOD: rollD10()                                       *
     * DESCRIPTION: roll a d10 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d10 rolled value                      *
     **********************************************************/
    private int rollD10() {
        int d10 = (int) (Math.random() * 10) + 1;
        return d10;
    }

    /***********************************************************
     * METHOD: drawD10()                                       *
     * DESCRIPTION: draw a d10 die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD10(){
        //d10
        StdDraw.setPenColor(StdDraw.DICE_GREEN);
        double[] d10x = {0.585, 0.5355, 0.5292649731, 0.585, 0.6407350269, 0.6345};
        double[] d10y = {0.01, 0.045, 0.07, 0.13, 0.07, 0.045};
        StdDraw.filledPolygon(d10x, d10y);
        StdDraw.setPenColor(StdDraw.GREEN);
        double[] shadow1d10x = {0.585, 0.5355, 0.56025, 0.585, 0.60975, 0.6345};
        double[] shadow1d10y = {0.01, 0.045, 0.045, 0.03, 0.045, 0.045};
        StdDraw.filledPolygon(shadow1d10x, shadow1d10y);
        StdDraw.setPenColor(StdDraw.GREEN_SHADOW);
        double[] shadow2d10x = {0.5355, 0.56025, 0.585, 0.5292649731};
        double[] shadow2d10y = {0.045, 0.045, 0.13, 0.07};
        StdDraw.filledPolygon(shadow2d10x, shadow2d10y);
        double[] shadow3d10x = {0.6345, 0.60975, 0.585, 0.6407350269};
        double[] shadow3d10y = {0.045, 0.045, 0.13, 0.07};
        StdDraw.filledPolygon(shadow3d10x, shadow3d10y);
    }

    /***********************************************************
     * METHOD: rollD8()                                        *
     * DESCRIPTION: roll a d8 die                              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d8 rolled value                       *
     **********************************************************/
    private int rollD8() {
        int d8 = (int) (Math.random() * 8) + 1;
        return d8;
    }

    /***********************************************************
     * METHOD: drawD8()                                        *
     * DESCRIPTION: draw a d8  die                             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD8(){
        StdDraw.setPenColor(StdDraw.ORANGE);
        double[] d8x = {0.43, 0.3722649731, 0.3742649731, 0.43, 0.4857350269, 0.4877350269};
        double[] d8y = {0.01, 0.035, 0.0945, 0.13, 0.0945, 0.035};
        StdDraw.filledPolygon(d8x, d8y);
        StdDraw.setPenColor(StdDraw.DEEP_ORANGE);
        double[] shadow1d8x = {0.43, 0.3722649731, 0.4877350269};
        double[] shadow1d8y = {0.01, 0.035, 0.035};
        StdDraw.filledPolygon(shadow1d8x, shadow1d8y);
        StdDraw.setPenColor(StdDraw.ORANGE_SHADOW);
        double[] shadow2d8x = {0.3722649731, 0.3742649731, 0.43};
        double[] shadow2d8y = {0.035, 0.0945, 0.13};
        StdDraw.filledPolygon(shadow2d8x, shadow2d8y);
        double[] shadow3d8x = {0.43, 0.4857350269, 0.4877350269};
        double[] shadow3d8y = {0.13, 0.0945, 0.035};
        StdDraw.filledPolygon(shadow3d8x, shadow3d8y);
    }

    /***********************************************************
     * METHOD: rollD6()                                        *
     * DESCRIPTION: roll a d6 die                              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d6 rolled value                       *
     **********************************************************/
    private int rollD6() {
        int d6 = (int) (Math.random() * 6) + 1;
        return d6;
    }

    /***********************************************************
     * METHOD: drawD6()                                        *
     * DESCRIPTION: draw a d6 die                              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD6(){
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.filledSquare(0.27, 0.065, 0.05);
    }

    /***********************************************************
     * METHOD: rollD4()                                        *
     * DESCRIPTION: roll a d4 die                              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the d4 rolled value                       *
     **********************************************************/
    private int rollD4() {
        int d4 = (int) (Math.random() * 4) + 1;
        return d4;
    }

    /***********************************************************
     * METHOD: drawD4()                                        *
     * DESCRIPTION: draw a d4 die                              *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    private void drawD4(){
        StdDraw.setPenColor(StdDraw.RED);
        double[] d4x = {0.04419147039, 0.1077, 0.1712085296};
        double[] d4y = {0.015, 0.125, 0.015};
        StdDraw.filledPolygon(d4x, d4y);
    }
    ///////////////////////////////////////////////////////////////////   constructor ////////////////////////////////////////////////////////////////////////////////////
    public DnDParty() {
        this.party = new ArrayList<Character>();
        this.enemies = new ArrayList<Character>();
        System.out.println("Menu commands:");
        System.out.println("\tS – Check Party Members' Stats");
        System.out.println("\tD – Detailed Information about a character ");
        System.out.println("\tI – Characters' Inventory");
        System.out.println("\tE – Start Encounter");
        System.out.println("\t? – Display this menu");
        System.out.print("\n");

        Stats barbarian = new Stats(17, 13, 14, 8, 12, 11);
        Stats cleric = new Stats(12, 10, 14, 10, 15, 13);
        Stats rogue = new Stats(10, 15, 12, 15, 8, 14);
        Stats wizard = new Stats(8, 14, 10, 15, 14, 13);
        Stats imp = new Stats(6, 17, 13, 11, 12, 14);
        Stats troll = new Stats(18, 13, 20, 7, 9, 7);

        //Actions
        Attack greataxe = new Attack("Greataxe Melee Attack", "N", 5, 0, "1d12");
        Attack breath = new Attack("Breath Weapon", "Y", 0, 12, "2d6");
        Attack guide = new Attack("Guiding Bolt", "N", 4, 0, "4d6");
        Attack mace = new Attack("Mace", "N", 3, 0, "1d6");
        Attack rapier = new Attack("Rapier", "N", 4, 0, "1d8");
        Attack sneak = new Attack("Sneak Attack", "N", 8, 0, "1d8 + 1d6");
        Attack witch = new Attack("Witch Bolt", "N", 4, 0, "1d12");
        Attack ice = new Attack("Ice Knife", "Y", 4, 12, "1d10");
        Attack sting = new Attack("Sting", "Y", 5, 11, "1d4");
        Attack biteTr = new Attack("Bite", "N", 7, 0, "1d6");
        Attack claw = new Attack("Claw", "N", 7, 0, "2d6 + 4");

        //Bonus actions
        Attack potion = new Attack("Potion of Healing", "N", 0, 0, "2d4 + 2");
        Attack heal = new Attack("Healing Word", "Y", 0, 0, "1d4 + 2");

        Action barbarianA = new Action(greataxe, breath);
        Action clericA = new Action(guide, mace);
        Action rogueA = new Action(rapier, sneak);
        Action wizardA = new Action(witch, ice);
        Action healParty = new Action(heal, heal);
        Action drinkPotion = new Action(potion, potion);
        Action impA = new Action(sting, sting);
        Action trollA = new Action(biteTr, claw);


        Character c1 = new Character("Barbarian", "Dragon Born", 1, 14, 14, 15, barbarian, barbarianA, drinkPotion, 0,
                "Flintstrike Rasbor", "Hunting, Combat Training, and Playing Poker", "General of the army for the kingdom Witchitieer", "Loyal to his unit and not afraid to get some blood on his hands.");
        Character c2 = new Character("Cleric", "Halfling", 1, 10, 10, 12, cleric, clericA, healParty, 0,
                "Anzira Heartbrige", "Pulling pranks, praying in the meadows, and playing the harp.", "A healer at the Medbay", "Joyful and Humorous. Enjoying making her party members laugh with a joke. Fierce in combat." );
        Character c3 = new Character("Rogue", "Gnome", 1, 9, 9, 13, rogue, rogueA, drinkPotion, 0,
                "Brixton Shadowcloak", "Reading, sharpening his rapier, and exploring the terrain.", "An assassin", "Reserved, Quiet, and Stealthy. If prompted tells spooky stories around the fire.");
        Character c4 = new Character("Wizard", "Elf", 1, 6, 6, 11, wizard, wizardA, drinkPotion, 0,
                "Venira Duskhold", "Star reading, practicing her magic, and knife throwing" , "A princess of the kingdom Lothlórien", "Gorgeous, Kind Hearted, and Intelligent. Helpful around camp gathering supplies.");
        Character e1 = new Character("Imp", "Imp", 0, 10, 10, 13, imp, impA, drinkPotion, 0,  "", "", "", "");
        Character e2 = new Character("Troll", "Troll", 0, 70, 70, 15, troll, trollA , drinkPotion, 0,  "", "", "", "");
        this.party.add(c1);
        this.party.add(c2);
        this.party.add(c3);
        this.party.add(c4);
        this.enemies.add(e1);
        this.enemies.add(e2);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**********************************************************
     * METHOD: meet_party()                                   *
     * DESCRIPTION: displays the party members and personal   *
     * information about them                                 *
     * party member                                           *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void meet_party() throws InterruptedException {
        int mem = 0; // Current member index
        double set_xl = 0.55; // Label X-coordinate
        double set_xv = 0.70; // Value X-coordinate
        //Background music
        playEncounterMusic("C:/Users/chloe/OneDrive/Desktop/DND photo/forest_audio-139004.wav");
        //Background photo
        StdDraw.picture(0.50 , 0.50,"C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0 , 1.0 );
        System.out.println("Let's introduce you to your party members!" + "\n");
        StdDraw.pause(1750);
        StdDraw.enableDoubleBuffering();
        while (mem < this.party.size()) {
            // Clear and set the background for each member
            StdDraw.picture(0.50, 0.50, "C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0, 1.0);
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.filledSquare(0.80, 0.50, 0.28);

            double y = 0.70; // Reset y-coordinate for details
            Font font3 = new Font("Aptos", Font.BOLD, 13);
            StdDraw.setFont(font3);
            // Create details for the current member
            String[][] member = {
                    {"Name: ", this.party.get(mem).getName()},
                    {"Class: ", this.party.get(mem).getType()},
                    {"Race: ", this.party.get(mem).getRace()},
                    {"Hobbies:", splitString(party.get(mem).getHobbies())},
                    {"Profession:", splitString(party.get(mem).getProfession())},
                    {"Personality:", splitString(party.get(mem).getPersonality())}
            };
            StdDraw.setPenColor(StdDraw.BLACK);
            System.out.println("Displaying member " + (mem + 1));
            System.out.println(this.party.get(mem).getName());
            System.out.println(this.party.get(mem).getType());
            System.out.println(this.party.get(mem).getRace());
            System.out.println(this.party.get(mem).getProfession());
            if(!(mem ==3)) {
                System.out.println("Press SpaceBar to see the next member...");
            }
            System.out.print("\n");

            // Draw each detail
            for (String[] strings : member) {
                String label = strings[0];
                String[] value = strings[1].split("\n");
                StdDraw.textLeft(set_xl, y, label);
                for (String line : value) {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.textLeft(set_xv, y, line);
                    y -= 0.05;
                }
            }

            // Draw character portrait or additional details
            meetDrawing(this.party.get(mem));

            // Update canvas
            StdDraw.show();

            if (mem < this.party.size() - 1) {
                while (!StdDraw.isKeyPressed(32)) {
                    Thread.sleep(10); // Small delay to avoid CPU overuse
                }

                // Wait for the spacebar to be released to prevent multiple advances
                while (StdDraw.isKeyPressed(32)) {
                    Thread.sleep(10);
                }
            }

            mem++; // Proceed to the next member
        }
        // Stop background music
        StdDraw.pause(3500);
        stopEncounterMusic();
    }
    /**********************************************************
     * METHOD: splitString()                                  *
     * DESCRIPTION: splits the String of the hobbies,         *
     * profession, and personality of the members             *
     * party member                                           *
     * PARAMETERS: String str                                 *
     * RETURN VALUE: result.toString().trim()                 *
     *********************************************************/
    private String splitString(String str) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int periodIndex = 0;
        int end = 0;
        while (start < str.length()) {
            end = Math.min(start + 30, str.length());
            periodIndex = str.lastIndexOf(" ", end);

            if (periodIndex > start && end < str.length()) {
                end = periodIndex + 1;
            }
            result.append(str, start, end).append("\n");
            start = end;
        }
        return result.toString().trim();

    }
    /*************************************************************
     * METHOD: group_photo()                                     *
     * DESCRIPTION: draws all the party members in the forest    *
     * PARAMETERS: none                                          *
     * RETURN VALUE: none                                        *
     ************************************************************/
     public void group_photo(){
         StdDraw.picture(0.50 , 0.50,"C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0 , 1.0 );
         //Characters
         StdDraw.picture(0.25, 0.80, "C:/Users/chloe/OneDrive/Desktop/DND photo/Barbarian_Greataxe.png", 0.6, 0.6);
         StdDraw.picture(0.23, 0.31 ,"C:/Users/chloe/OneDrive/Desktop/DND photo/Cleric_Mace.png", 0.5, 0.5);
         StdDraw.picture(0.75, 0.77 , "C:/Users/chloe/OneDrive/Desktop/DND photo/Rogue_Sneak_Attack.png", 0.52, 0.52);
         StdDraw.picture(0.77, 0.33,"C:/Users/chloe/OneDrive/Desktop/DND photo/Wizard_IceKnife.png", 0.55, 0.55);
         StdDraw.show();

     }
    /*************************************************************
     * METHOD: group_level_photo()                               *
     * DESCRIPTION: draws all the party members in the forest    *
     * leveling up                                               *
     * party member                                              *
     * PARAMETERS: none                                          *
     * RETURN VALUE: none                                        *
     ************************************************************/
    public void group_level_photo(){
        StdDraw.picture(0.50 , 0.50,"C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0 , 1.0 );
        //Characters
        StdDraw.picture(0.25, 0.79, "C:/Users/chloe/OneDrive/Desktop/DND photo/Barbarian_Greataxe.png", 0.43, 0.43);
        StdDraw.picture(0.23, 0.40 ,"C:/Users/chloe/OneDrive/Desktop/DND photo/Cleric_Guiding_Bolt.png", 0.35, 0.35);
        StdDraw.picture(0.75, 0.77 , "C:/Users/chloe/OneDrive/Desktop/DND photo/Rogue_Sneak_Attack.png", 0.37, 0.37);
        StdDraw.picture(0.77, 0.43,"C:/Users/chloe/OneDrive/Desktop/DND photo/Wizard_IceKnife.png", 0.40, 0.40);
        // Rolling
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(0.5, 0, 0.5, 0.18);
        text();
        //d4
        drawD4();
        //d6
        drawD6();
        //d8
        drawD8();
        // d10
        drawD10();
        //d12
        drawD12();
        //d20
        drawD20();
        StdDraw.show();

    }

    /*************************************************************
     * METHOD: meetDrawing()                                     *
     * DESCRIPTION: draws the character on the left of the screen*
     * when meeting them for the first time                      *
     * PARAMETERS: current                                       *
     * RETURN VALUE: none                                        *
     ************************************************************/
    private void meetDrawing(Character chosen){
        if (chosen.getType().equals("Barbarian")){
            StdDraw.picture(0.23,0.53, "C:/Users/chloe/OneDrive/Desktop/DND photo/Barbarian_Greataxe.png", 0.6, 0.6);
        } else if (chosen.getType().equals("Cleric") && chosen.getImage() == 0){
            StdDraw.picture(0.23,0.53, "C:/Users/chloe/OneDrive/Desktop/DND photo/Cleric_Guiding_Bolt.png", 0.5, 0.5);
        } else if (chosen.getType().equals("Rogue")){
            StdDraw.picture(0.25, 0.53, "C:/Users/chloe/OneDrive/Desktop/DND photo/Rogue_Rapier.png", 0.52, 0.52);
        } else if (chosen.getType().equals("Wizard")){
            StdDraw.picture(0.25,0.53, "C:/Users/chloe/OneDrive/Desktop/DND photo/Wizard_Witch_Bolt.png", 0.55, 0.55);
        }
    }
    /*************************************************************
     * METHOD: drawCharLeft()                                    *
     * DESCRIPTION: draws the character on the left of the screen*
     * PARAMETERS: Character left                                *
     * RETURN VALUE: none                                        *
     ************************************************************/
    private void drawCharLeft(Character left) {
        switch (left.getType()) {
            case "Barbarian":
                if (left.getImage() == 0) {
                    StdDraw.picture(0.23, 0.48, "C:/Users/chloe/OneDrive/Desktop/DND photo/Barbarian_Greataxe.png", 0.6, 0.6);
                } else if (left.getImage() == 1) {
                    StdDraw.picture(0.23, 0.48, "C:/Users/chloe/OneDrive/Desktop/DND photo/Barbarian_Breath_Weapon.png", 0.6, 0.6);
                }
                break;
            case "Cleric":
                if (left.getImage() == 0) {
                    StdDraw.picture(0.23, 0.43, "C:/Users/chloe/OneDrive/Desktop/DND photo/Cleric_Guiding_Bolt.png", 0.5, 0.5);
                }
                else if (left.getImage() == 1){
                    StdDraw.picture(0.23, 0.43 ,"C:/Users/chloe/OneDrive/Desktop/DND photo/Cleric_Mace.png", 0.5, 0.5);
                }
                break;
            case "Rogue":
                if(left.getImage() == 0){
                    StdDraw.picture(0.25, 0.44, "C:/Users/chloe/OneDrive/Desktop/DND photo/Rogue_Rapier.png",0.52, 0.52);
                }
                else if(left.getImage() == 1){
                    StdDraw.picture(0.25, 0.44 , "C:/Users/chloe/OneDrive/Desktop/DND photo/Rogue_Sneak_Attack.png", 0.52, 0.52);
                }
                break;
            case "Wizard":
                if(left.getImage() == 0){
                    StdDraw.picture(0.28, 0.46, "C:/Users/chloe/OneDrive/Desktop/DND photo/Wizard_Witch_Bolt.png", 0.55, 0.55);
                }
                else if(left.getImage() == 1){
                    StdDraw.picture(0.28, 0.46,"C:/Users/chloe/OneDrive/Desktop/DND photo/Wizard_IceKnife.png", 0.55, 0.55);

                }
                break;
        }

    }
    /*************************************************************
     * METHOD: drawCharRight()                                   *
     * DESCRIPTION: draws the character on the right of the      *
     * screen                                                    *
     * PARAMETERS: Character right                               *
     * RETURN VALUE: none                                        *
     ************************************************************/
    private void drawCharRight(Character right) {
        switch (right.getType()) {
            case "Imp":
                StdDraw.picture(0.77, 0.5, "C:/Users/chloe/OneDrive/Desktop/DND photo/Imp.png", 0.4, 0.4);
                break;
            case "Troll":
                StdDraw.picture(0.78, 0.43, "C:/Users/chloe/OneDrive/Desktop/DND photo/Troll.png", 0.5, 0.5);
                break;

            case "Barbarian":
                if (right.getImage() == 0) {
                    StdDraw.picture(0.77, 0.48, "C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Barbarian_Greataxe.png", 0.6, 0.6);
                } else if (right.getImage() == 1) {
                    StdDraw.picture(0.77, 0.48, "C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Barbarian_BreathFire.png", 0.6, 0.6);
                }
                break;

            case "Cleric":
                if (right.getImage() == 0) {
                    StdDraw.picture(0.77, 0.43, "C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Cleric_GuidingBolt.png", 0.5, 0.5);
                }
                else if (right.getImage() == 1){
                    StdDraw.picture(0.77, 0.43 ,"C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Cleric_Mace.png", 0.5, 0.5);
                }
                break;
            case "Rogue":
                if(right.getImage() == 0){
                    StdDraw.picture(0.76, 0.44, "C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Rogue_Rapier.png",0.52, 0.52);
                }
                else if(right.getImage() ==1){
                    StdDraw.picture(0.77, 0.44,"C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Rogue_SneakAttack.png", 0.52, 0.52);

                }
                break;
            case "Wizard":
                if(right.getImage() == 0){
                    StdDraw.picture(0.77, 0.46,"C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Wizard_WitchBolt.png",0.55,0.55);
                }
                else if(right.getImage() == 1){
                    StdDraw.picture(0.72, 0.46,"C:/Users/chloe/OneDrive/Desktop/DND photo/Flipped_Wizard_IceKnife.png", 0.55, 0.55);

                }
                break;
        }
    }
    /**********************************************************
     * METHOD: printStats()                                   *
     * DESCRIPTION: displays members stats                    *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void printStats () {
        StdDraw.clear();
        group_photo();
        StdDraw.show();
        System.out.printf("%-12s %-16s %-14s %-14s %-15s", "\t", "Barbarian", "Cleric", "Rogue", "Wizard");
        System.out.print("\n");
        System.out.print("Strength:           ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getSTR());
        }
        System.out.print("\n");
        System.out.print("Dexterity:          ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getDEX());
        }
        System.out.print("\n");
        System.out.print("Constitution:       ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getCON());
        }
        System.out.print("\n");
        System.out.print("Intelligence:       ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getINT());
        }
        System.out.print("\n");
        System.out.print("Wisdom:             ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getWIS());
        }
        System.out.print("\n");
        System.out.print("Charisma:           ");
        for (int i = 0; i< this.party.size(); i++){
            System.out.printf("%-15s", this.party.get(i).getStats().getCHA());
        }
        System.out.print("\n");

    }
    /**********************************************************
     * METHOD: displayCharacter()                             *
     * DESCRIPTION: displays addition information on the      *
     * party member                                           *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void displayCharacter(){
        Scanner scr = new Scanner(System.in);
        double set_xl = 0.55; // Label X-coordinate
        double set_xv = 0.70;
        StdDraw.clear();
        StdDraw.picture(0.50, 0.50, "C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0, 1.0);
        StdDraw.show();
        System.out.println("1) Barbarian 2) Cleric 3) Rogue 4) Wizard");
        System.out.print("What character do you want to see more information about? => ");
        int select = scr.nextInt();
        scr.nextLine();
        int index = select-1;
        if (index >= 0 && index < this.party.size()) {
            System.out.println("You selected the " + this.party.get(index).getType());
            String details = " ";
            details += "\tLevel:         " + this.party.get(index).getLevel() + "\n";
            details += "\tHP:            " + this.party.get(index).getHP() + "\n";
            details += "\tAC:            " + this.party.get(index).getAC() + "\n";
            details += "\tRace:          " + this.party.get(index).getRace() + "\n";
            details += "\tClass:         " + this.party.get(index).getType() + "\n";
            details += "\tActions:       " + this.party.get(index).getAction().getAttack1().getWeapon() + " and " + this.party.get(index).getAction().getAttack2().getWeapon() + "\n";
            details += "\tBonus Action:  " + this.party.get(index).getBonusAction().getAttack1().getWeapon() + "\n";
            System.out.println(details);
            // StdDraw
            //StdDraw.picture(0.50 , 0.50,"C:/Users/chloe/OneDrive/Desktop/DND photo/DND Forest Background.jpg", 1.0 , 1.0 );
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.filledSquare(0.80, 0.53, 0.265);

            StdDraw.setPenColor(StdDraw.BLACK);
            double y = 0.70; // Reset y for each member
            Font font3 = new Font("Aptos", Font.BOLD, 13);
            StdDraw.setFont(font3);

            // Create details for the current member
            String[][] memeber = {
                    {"\tLevel: ", String.valueOf(this.party.get(index).getLevel())},
                    {"HP: ", String.valueOf(this.party.get(index).getHP())},
                    {"Armor Class:", String.valueOf(party.get(index).getAC())},
                    {"Race", party.get(index).getRace()},
                    {"Class:", String.valueOf(party.get(index).getType())},
                    {"Action:",splitString(party.get(index).getAction().getAttack1().getWeapon() + " and " + this.party.get(index).getAction().getAttack2().getWeapon())},
                    {"Bonus Action:", String.valueOf(this.party.get(index).getBonusAction().getAttack1().getWeapon())}
            };

            for (String[] strings : memeber) {
                String label = strings[0];
                String[] value = strings[1].split("\n");
                StdDraw.textLeft(set_xl, y, label);
                for (String line : value) {
                    StdDraw.textLeft(set_xv, y, line);
                    meetDrawing(this.party.get(index));
                    y -= 0.05; // Move to the next line
                }
            }
            StdDraw.show(); // Update canvas to show the drawing
        }
        else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
    int bar_potions = 2;
    int rog_potions = 2;
    int wiz_potions = 2;
    /**********************************************************
     * METHOD: inventory()                                    *
     * DESCRIPTION: displays the Character's inventory        *
     * party member                                           *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void inventory(){
        StdDraw.clear();
        group_photo();
        StdDraw.show();
        int dash = 45;
        for(int d = 0; d < dash; d++){
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-20s %-11s %-12s", "| Characters |", "Item" , "|  Amount  |");
        System.out.println();
        for(int d = 0; d < dash; d++){
            System.out.print("-");
        }
        System.out.println();
        for(int i = 0; i< this.party.size(); i++){
            if(i == 1) {
                System.out.printf("%-1s %-10s %-17s", "|" ,this.party.get(i).getType(), "| Healing Word      | ");
                System.out.print("infinity |");
                System.out.println();
            }
            else {
                System.out.printf("%-1s %-10s %-17s", "|", this.party.get(i).getType(), "| Potion of Healing | ");
                System.out.print("  x" + bar_potions + "     |");
                System.out.println();
            }
        }
        for(int d = 0; d < dash; d++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**********************************************************
     * METHOD: hp_bar()                                       *
     * DESCRIPTION: displays the Character's HP               *
     * party member                                           *
     * PARAMETERS: The Character on the left and the Character*
     * on the right of the encounter                          *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void hp_bar(Character left, Character right){
        StdDraw.enableDoubleBuffering();
        this.background();
        this.drawCharLeft(left);
        this.drawCharRight(right);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        double x_char = 0.255;
        double x_enemy = 0.80;
        double y = 0.80;
        double width  = 0.18;
        double height = 0.02;
        StdDraw.filledRectangle(x_char, y, width, height);
        StdDraw.filledRectangle(x_enemy, y, width, height);
        Font font2 = new Font("Righteous", Font.BOLD, 18);
        StdDraw.setFont(font2);
        if(accomplishment == 1){
            StdDraw.setPenColor(StdDraw.BLACK);

        }
        else{
            StdDraw.setPenColor(StdDraw.WHITE);
        }
        StdDraw.text(x_char, 0.84, left.getType());
        StdDraw.text(x_enemy,0.84, right.getType());

        for(int i = 0; i <= left.getHP(); i++){
            if (left.getHP() == 0){
                StdDraw.enableDoubleBuffering();
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            } else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            double bar_width = (width/left.getMaxHP());
            double bar_x = (x_char-width) + (((i*2)-1) * bar_width);
            StdDraw.filledRectangle(bar_x, y, bar_width, height );
        }
        StdDraw.show();
        for(int i = 0; i <= right.getHP(); i++){
            if (right.getHP() == 0){
                StdDraw.enableDoubleBuffering();
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            } else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            double bar_width1 = (width / right.getMaxHP());
            double bar_x1 = (x_enemy-width) + (((i*2)-1) * bar_width1);
            StdDraw.filledRectangle(bar_x1, y,bar_width1 ,height);
        }
        StdDraw.show();
        StdDraw.pause(1500);

        attack = left;
        defense = right;
    }
    private Character attack;
    private Character defense;
    private double x_postion = 0.0;
    private double y_postion = 0;
    /**********************************************************
     * METHOD: Rolling_Dice()                                 *
     * DESCRIPTION: 'Rolls" the dice for the encounters by    *
     * printing random numbers before displaying the roll     *
     * value                                                  *
     * PARAMETERS: the roll value, the damage roll value, and *
     * what dice is rolling                                   *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void Rolling_Dice(int roll, int damage_roll, int dice){
        int times = (int)(Math.random() *(4-1 +1) + 1 );
        text();
        StdDraw.setPenColor(StdDraw.WHITE);
        for(int i = 0; i<times; i++){
            StdDraw.enableDoubleBuffering();
            this.background();
            hp_bar(attack,defense);
            int d4_random = (int)(Math.random() *(4-1 +1) + 1 );
            int d6_random = (int)(Math.random() *(6-1 +1) + 1 );
            int d8_random = (int)(Math.random() *(8-1 +1) + 1 );
            int d10_random = (int)(Math.random() *(10-1 +1) + 1 );
            int d12_random = (int)(Math.random() *(12-1 +1) + 1 );
            int d20_random = (int)(Math.random() *(20-1 +1) + 1 );
            int rand = 0;
            switch (dice){
                case 4:
                    // add text to the other dice
                    rand = d4_random;
                    // d4
                    drawD4();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.1077, 0.06, String.valueOf(rand));
                    x_postion  = 0.1077;
                    y_postion = 0.06;
                    break;
                case 6:
                    rand = d6_random;
                    //d6
                    drawD6();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.27, 0.064, String.valueOf(rand));
                    x_postion  = 0.27;
                    y_postion = 0.064;
                    break;
                case 8:
                    rand = d8_random;
                    //d8
                    drawD8();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.43, 0.065, String.valueOf(rand));
                    x_postion = 0.43;
                    y_postion = 0.065;
//                    System.out.print("It is in case 8");
                    break;
                case 10:
                    rand = d10_random;
                    StdDraw.setPenColor(Color.WHITE);
                    //d10
                    drawD10();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.585, 0.055, String.valueOf(rand));
                    x_postion = 0.585;
                    y_postion = 0.055;
//                    System.out.print("It is in case 10");
                    break;
                case 12:
                    rand = d12_random;
                    //d12
                    drawD12();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.73, 0.061, String.valueOf(rand));
                    x_postion = 0.73;
                    y_postion = 0.061;
                    //System.out.print("It is in case 12");
                    break;
                case 20:
                    rand = d20_random;
                    //d20
                    StdDraw.setPenColor(StdDraw.PURPLE);
                    drawD20();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.90, 0.060, String.valueOf(rand));
                    break;

            }
            StdDraw.show();
            StdDraw.pause(250);

        }
        StdDraw.clear();
        this.background();
        hp_bar(attack,defense);
        StdDraw.setPenColor(StdDraw.BLACK);
        if(damage_roll != 0 ) {
            StdDraw.text(x_postion, y_postion, String.valueOf(damage_roll));

        }
        else{
            StdDraw.text(0.90, 0.060, String.valueOf(roll));
        }
        StdDraw.show();
        StdDraw.pause(2000);

    }
    /**********************************************************
     * METHOD: Rolling_DiceLevelUP()                          *
     * DESCRIPTION: rolls the dice to level up the characters *
     * party member                                           *
     * PARAMETERS: the value of the roll and the dice being   *
     * rolled                                                 *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void Rolling_DiceLevelUP(int level_roll, int dice){
        int times = 3;
        text();
        StdDraw.setPenColor(StdDraw.WHITE);
        for(int i = 0; i<times; i++){
            StdDraw.enableDoubleBuffering();
            group_level_photo();
            int d4_random = (int)(Math.random() *(4-1 +1) + 1 );
            int d6_random = (int)(Math.random() *(6-1 +1) + 1 );
            int d8_random = (int)(Math.random() *(8-1 +1) + 1 );
            int d10_random = (int)(Math.random() *(10-1 +1) + 1 );
            int d12_random = (int)(Math.random() *(12-1 +1) + 1 );
            int rand = 0;
            switch (dice){
                case 4:
                    // add text to the other dice
                    rand = d4_random;
                    // d4
                    drawD4();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.1077, 0.06, String.valueOf(rand));
                    x_postion  = 0.1077;
                    y_postion = 0.06;
                    break;
                case 6:
                    rand = d6_random;
                    //d6
                    drawD6();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.27, 0.064, String.valueOf(rand));
                    x_postion  = 0.27;
                    y_postion = 0.064;
                    break;
                case 8:
                    rand = d8_random;
                    //d8
                    drawD8();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.43, 0.065, String.valueOf(rand));
                    x_postion = 0.43;
                    y_postion = 0.065;
                    break;
                case 10:
                    rand = d10_random;
                    StdDraw.setPenColor(Color.WHITE);
                    //d10
                    drawD10();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.585, 0.055, String.valueOf(rand));
                    x_postion = 0.585;
                    y_postion = 0.055;
                    break;
                case 12:
                    rand = d12_random;
                    //d12
                    drawD12();
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(0.73, 0.061, String.valueOf(rand));
                    x_postion = 0.73;
                    y_postion = 0.061;
                    break;
            }
            StdDraw.show();
            StdDraw.pause(450);

        }
        StdDraw.clear();
        this.group_level_photo();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x_postion, y_postion, String.valueOf(level_roll));
        StdDraw.show();
        StdDraw.pause(2000);

    }


    /**********************************************************
     * METHOD: combat()                                       *
     * DESCRIPTION: runs through one round of combat for an   *
     * action or bonus action                                 *
     * PARAMETERS: the target of the attack                   *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public int combat(Character attacker, Character target){
        int damage = 0;
        int dice = 0;
        if(attacker.getAction().getAttack1().getDamage().equals("1d12") || attacker.getAction().getAttack2().getDamage().equals("1d12")){
            damage = this.rollD12();
            dice = 12;
            if(attacker.getType().equals("Barbarian")){
                damage += 2;
            }
        } else if(attacker.getAction().getAttack1().getDamage().equals("1d10") || attacker.getAction().getAttack2().getDamage().equals("1d10")){
            damage = this.rollD10();
            dice = 10;

        } else if(attacker.getAction().getAttack1().getDamage().equals("1d8") || attacker.getAction().getAttack2().getDamage().equals("1d8")){
            damage = this.rollD8();
            dice = 8;
        } else if(attacker.getAction().getAttack1().getDamage().equals("1d6") || attacker.getAction().getAttack2().getDamage().equals("1d6")){
            damage = this.rollD6();
            dice = 6;
        } else if (attacker.getAction().getAttack1().getDamage().equals("1d4") || attacker.getAction().getAttack2().getDamage().equals("1d4")){
            damage = this.rollD4();
            dice = 4 ;
        } else if(attacker.getAction().getAttack1().getDamage().equals("2d6") || attacker.getAction().getAttack2().getDamage().equals("2d6")){
            damage = this.rollD6() + this.rollD6();
            dice = 6;
        } else if (attacker.getAction().getAttack1().getDamage().equals("4d6") || attacker.getAction().getAttack2().getDamage().equals("4d6")){
            damage = this.rollD6() + this.rollD6() + this.rollD6() + this.rollD6();
            dice = 6;
        } else if(attacker.getAction().getAttack1().getDamage().equals("2d12") || attacker.getAction().getAttack2().getDamage().equals("2d12")){
            damage = this.rollD12() + this.rollD12();
            dice = 12;
        } else if(attacker.getAction().getAttack1().getDamage().equals("1d8 + 1d6") || attacker.getAction().getAttack2().getDamage().equals("1d8 + 1d6")){
            damage = this.rollD6() + this.rollD8();
            dice = 8;
        }
        System.out.println("It's the " + attacker.getType() + "'s turn.");
        System.out.println("What Action would you like to take?");
        System.out.print("(choose 1 or 2) " + attacker.getAction().getAttack1().getWeapon() + "\t" + attacker.getAction().getAttack2().getWeapon() + " => ");
        int choice = scan.nextInt();
        System.out.println();
        if (choice == 1){
            attacker.setImage(0);
            System.out.println("The " + attacker.getType() + " will attack using " + attacker.getAction().getAttack1().getWeapon());
            System.out.println("Roll to hit.");
            int attackRoll = this.rollD20();
            Rolling_Dice(attackRoll, 0,20);
            int attackBonus = attacker.getAction().getAttack1().getAttackBonus();
            int attackTotal = attackRoll + attackBonus;
            System.out.println("The " + attacker.getType() + " rolled a " + attackRoll + " with an attack bonus of " + attackBonus + " to total " + attackTotal + ".");
            if (attackTotal >= target.getAC()){
                System.out.println("The attack hits! Now roll for damage.");
                Rolling_Dice(attackRoll,damage,dice);
                System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
            } else if(attackTotal < target.getAC()){
                damage = 0;
                System.out.println("The " + attacker.getType() + " missed their attack.");
            }
        } else if (choice == 2){
            attacker.setImage(1);
            System.out.println("The " + attacker.getType() + " will attack using " + attacker.getAction().getAttack2().getWeapon());
            if (attacker.getAction().getAttack2().getUseDC().equals("Y")){
                if (attacker == this.party.get(0)){
                    System.out.println("This attack doesn't require a roll to hit, but the " + target.getType() + " has to roll a saving throw.");
                    System.out.println("The DC for this attack is " + attacker.getAction().getAttack2().getDC());
                    int savingThrow = this.rollD20() + target.getStats().getDEXmod();
                    if (savingThrow < attacker.getAction().getAttack2().getDC()){
                        System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", which does not beat the DC.");
                        System.out.println("Now roll for damage.");
                        Rolling_Dice(savingThrow,damage, dice);
                        System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
                    } else if (savingThrow >= attacker.getAction().getAttack2().getDC()){
                        System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", so it succeeds the saving throw.");
                        System.out.println("Now roll for damage.");
                        Rolling_Dice(savingThrow, damage, dice);
                        damage = damage / 2;
                        System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
                    }
                } else {
                    System.out.println("Roll to hit.");
                    int attackRoll = this.rollD20();
                    Rolling_Dice(attackRoll, 0, 20);
                    int attackBonus = attacker.getAction().getAttack2().getAttackBonus();
                    int attackTotal = attackRoll + attackBonus;
                    System.out.println("The " + attacker.getType() + " rolled a " + attackRoll + " with an attack bonus of " + attackBonus + " to total " + attackTotal + ".");
                    if (attackTotal >= target.getAC()){
                        System.out.println("The attack hits! Now roll for damage.");
                        Rolling_Dice(attackRoll, damage, dice);
                        System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
                        System.out.println("The " + attacker.getAction().getAttack2().getWeapon() + " exploded! Now the " + target.getType() + " must make a saving throw.");
                        System.out.println("The DC for this attack is " + attacker.getAction().getAttack2().getDC());
                        int savingThrow = this.rollD20() + target.getStats().getDEXmod();
                        if(savingThrow < attacker.getAction().getAttack2().getDC()){
                            System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", which does not beat the DC. Roll for additional damage.");
                            int moreDamage = this.rollD6() + this.rollD6();
                            Rolling_Dice(savingThrow, moreDamage, 6);
                            damage += moreDamage;
                            System.out.println("The " + attacker.getType() + " dealt " + moreDamage + " damage, totalling " + damage + " damage.");
                        } else if(savingThrow >= attacker.getAction().getAttack2().getDC()){
                            System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", so it succeeds the saving throw and takes no additional damage.");
                        }
                    } else if(attackTotal < target.getAC()){
                        damage = 0;
                        System.out.println("The " + attacker.getType() + " missed their attack.");
                        System.out.println("But look! The " + attacker.getAction().getAttack2().getWeapon() + " exploded! Now the " + target.getType() + " must make a saving throw.");
                        System.out.println("The DC for this attack is " + attacker.getAction().getAttack2().getDC());
                        int savingThrow = this.rollD20() + target.getStats().getDEXmod();
                        Rolling_Dice(savingThrow, 0, 20);
                        if(savingThrow < attacker.getAction().getAttack2().getDC()){
                            System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", which does not beat the DC. Roll damage.");
                            int moreDamage = this.rollD6() + this.rollD6();
                            Rolling_Dice(savingThrow,moreDamage, 6);
                            damage += moreDamage;
                            System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
                        } else if(savingThrow >= attacker.getAction().getAttack2().getDC()){
                            System.out.println("The " + target.getType() + " rolled a " + savingThrow + ", so it succeeds the saving throw and takes no additional damage.");
                        }
                    }
                }
            } else if (attacker.getAction().getAttack2().getUseDC().equals("N")){
                System.out.println("Roll to hit.");
                int attackRoll = this.rollD20();
                Rolling_Dice(attackRoll,0,20);
                int attackBonus = attacker.getAction().getAttack2().getAttackBonus();
                int attackTotal = attackRoll + attackBonus;
                System.out.println("The " + attacker.getType() + " rolled a " + attackRoll + " with an attack bonus of " + attackBonus + " to total " + attackTotal + ".");
                if (attackTotal >= target.getAC()){
                    System.out.println("The attack hits! Now roll for damage.");
                    Rolling_Dice(attackRoll,damage, dice);
                    System.out.println("The " + attacker.getType() + " dealt " + damage + " damage.");
                } else if(attackTotal < target.getAC()){
                    damage = 0;
                    System.out.println("The " + attacker.getType() + " missed their attack.");
                }
            }
        }
        else{
            System.out.println("Invalid choose!");
            System.out.println("What Action would you like to take?");
            System.out.print("(choose 1 or 2) " + attacker.getAction().getAttack1().getWeapon() + "\t" + attacker.getAction().getAttack2().getWeapon() + " => ");
            choice = scan.nextInt();

        }
        return damage;
    }

    private void healBA(Character giver, Character receiver){
        int HP = 0;
        hp_bar(giver, receiver);
        if(giver.getBonusAction().getAttack1().getDamage().equals("2d4 + 2") || giver.getBonusAction().getAttack2().getDamage().equals("2d4 + 2")){
            HP = this.rollD4() + this.rollD4() + 2;
        } else if(giver.getBonusAction().getAttack1().getDamage().equals("1d4 + 2") || giver.getBonusAction().getAttack2().getDamage().equals("1d4 + 2")){
            HP = this.rollD4() + 2;
        }
        if(giver == receiver && giver != this.party.get(1)){
            System.out.println("The " + giver.getType() + " will drink a Potion of Healing. Roll for how much HP is restored.");
            Rolling_Dice(rollD20(), HP,4);
            System.out.println("The " + giver.getType() + " regained " + HP + " hit points");
            switch (giver.getType()) {
                case "Barbarian" -> {
                    bar_potions--;
                    System.out.println("You have " + bar_potions + " potion(s) left");

                }
                case "Rogue" -> {
                    rog_potions--;
                    System.out.println("You have " + rog_potions + " potion(s) left");
                }
                case "Wizard" -> {
                    wiz_potions--;
                    System.out.println("You have " + wiz_potions + " potion(s) left");
                }
            }

        } else if(giver == receiver && giver == this.party.get(1)){
            System.out.println("The Cleric will healed itself and regained " + HP + " hit points");
        } else if(giver != receiver){
            System.out.println("The " + giver.getType() + " healed the " + receiver.getType() + " to regain " + HP + " hit points");
        }
        receiver.healSetHP(HP);
        this.hp_bar(giver, receiver);
        if(receiver.getHP() == receiver.getMaxHP()){
            System.out.println("The " + receiver.getType() + "'s HP has been fully restored.");
        } else {
            System.out.println("The " + receiver.getType() + "'s HP has been restored to " + receiver.getHP());
        }

    }
    private Clip clip;
    /***********************************************************
     * METHOD: playEncounterMusic()                            *
     * DESCRIPTION: plays background music                     *
     * PARAMETERS: String filePath                             *
     * RETURN VALUE: none                                      *
     **********************************************************/
    public void playEncounterMusic(String filePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);// Loop indefinitely
            clip.start();

        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }
    /***********************************************************
     * METHOD: stopEncounterMusic()                            *
     * DESCRIPTION: plays background music                     *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    public void stopEncounterMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    private int death_count = 0;
    /***********************************************************
     * METHOD: enemyAttack()                                   *
     * DESCRIPTION: randomly select a single party member that *
     * gets attacked by an enemy                               *
     * PARAMETERS: none                                        *
     * RETURN VALUE: a number of the party index to be attacked*
     **********************************************************/
    private void enemyAttack(int opponent) {
        String enemy = "";
        if(opponent == 0){
            enemy  = "imp";
        }
        else if(opponent == 1){
            enemy = "troll";
        }
        System.out.println("Now it's the " + enemy+"'s turn.");
        int select = 5;
        while(select == 5) {
            int index = (int) (Math.random() * this.party.size());
            if(this.party.get(index).getHP() > 0) {
                select = index;
            }
        }
        System.out.println("The " + enemy+ " attempts to attack the " + this.party.get(select).getType() + ".");
        this.hp_bar(this.party.get(select), this.enemies.get(opponent));
        int attackRoll_enemy = this.rollD20();
        Rolling_Dice(attackRoll_enemy, 0, 20);
        if ((attackRoll_enemy) >= this.party.get(select).getAC()) {
            System.out.println("The " + enemy+ " rolled a " + attackRoll_enemy + " and now it rolls for damage it deals! ");
            int damageRoll = this.rollD12();
            Rolling_Dice(attackRoll_enemy ,damageRoll,12);
            System.out.println("The " + enemy + " dealt " + damageRoll + " damage!");
            this.party.get(select).damageSetHP(damageRoll);
            this.hp_bar(this.party.get(select), this.enemies.get(opponent));
            System.out.println("The " + this.party.get(select).getType() + " now has " + this.party.get(select).getHP() + " hit points left.");
            if (this.party.get(select).getHP() == 0) {
                System.out.println("The " + this.party.get(select).getType() + " died! Oh no!");
                death_count += 1;
                StdDraw.pause(200);
            }
        }
        else{
            System.out.print("The "+ enemy+ " missed its attack");
            System.out.print("\n");
            StdDraw.pause(200);
        }
    }
    /***********************************************************
     * METHOD: checkTurn()                                     *
     * DESCRIPTION: checks which party member's turn it is     *
     * PARAMETERS: int charIndex                               *
     * RETURN VALUE: nextTurn                                  *
     **********************************************************/
    private int checkTurn(int charIndex){
        int alive = 0;
        int nextTurn = 0;
        while (alive == 0){
            if (this.party.get(charIndex).getType().equals("Wizard")){
                nextTurn = 0;
            } else {
                nextTurn = charIndex + 1;
            }
            if (this.party.get(nextTurn).getHP() != 0){
                alive = 1;
            }
        }
        return nextTurn;
    }

    int imp = 0;
    /***********************************************************
     * METHOD: encounter1()                                    *
     * DESCRIPTION: the party fighting imps                    *
     * PARAMETERS: none                                        *
     * RETURN VALUE: none                                      *
     **********************************************************/
    public void encounter1() {
        int proficiency = 2;
        // modifier will be different have to add a parameter (modifier and HP change with level)
        // for loop within a for loop (number of imps fought)
        StdDraw.clear();
        System.out.println("The party is walking through the forest when they come across an abandon castle.");
        System.out.println("Curious they enter and come in combat with an Imp!\n");
        StdDraw.picture(0.50, 0.5, "/C:/Users/chloe/OneDrive/Desktop/DND photo/DND background1.jpg", 1.00, 1.0);
        StdDraw.show();
        playEncounterMusic("C:/Users/chloe/OneDrive/Desktop/DND photo/imp_encounter-149571.wav");
        StdDraw.pause(1800);
        int killedImps = 0;
        int totalImps = 3;
        int nextTurn = 0;
        while (killedImps < totalImps) {
            if (this.enemies.get(imp).getHP() <= 0) {
                this.enemies.get(imp).healSetHP(10);
            }
            while (this.enemies.get(imp).getHP() != 0) {
                for (int j = 0; j < this.party.size(); j++) {
                        j = nextTurn;
                    if (this.party.get(j).getHP() > 0) {
                        this.hp_bar(this.party.get(j), this.enemies.get(imp));
                        int damageRoll = this.combat(this.party.get(j), this.enemies.get(imp));
                        this.enemies.get(imp).damageSetHP(damageRoll);
                        this.hp_bar(this.party.get(j), this.enemies.get(imp));
                        System.out.println("The imp has " + this.enemies.get(imp).getHP() + " hit points left." + "\n");
                        if (this.enemies.get(imp).getHP() == 0) {
                            System.out.println("You killed the imp! Good job!");
                            killedImps++;
                            System.out.println("There were " + death_count + " death(s)");
                            System.out.print("Would you like to make a bonus action? (Y/N) => ");
                            String bonus = scan.next();
                            if (bonus.equalsIgnoreCase("Y")) {
                                if(this.party.get(j).getType().equals("Cleric")){
                                    System.out.println("Which party member do you want to heal?");
                                    System.out.print("Barbarian 1., Cleric 2., Rogue 3., Wizard 4. ) => ");
                                    int heal = scan.nextInt();
                                    this.healBA(this.party.get(j), this.party.get(heal - 1));
                                } else {
                                    if (bar_potions != 0 && this.party.get(j).getType().equals("Barbarian")) {
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    } else if (rog_potions != 0 && this.party.get(j).getType().equals("Rogue")) {
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    } else if (wiz_potions != 0 && this.party.get(j).getType().equals("Wizard")) {
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    } else {
                                        System.out.println("Sorry the " + this.party.get(j).getType() + " does not have any potions left");
                                    }
                                }

                            }
                            nextTurn = this.checkTurn(j);
                            if (killedImps == 1 ) {
                                System.out.print("\n");
                                System.out.println("But, wait you though there was only one?!?!");
                                System.out.println("Two more imps appear!" + "\n");
                            }
                            break;
                        }

                        else{
                            nextTurn = this.checkTurn(j);
                            System.out.print("Would you like to make a bonus action? (Y/N) => ");
                            String bonus = scan.next();
                            if (bonus.equalsIgnoreCase("Y")) {
                                if(this.party.get(j).getType().equals("Cleric")){
                                    System.out.println("Which party member do you want to heal?");
                                    System.out.print("Barbarian 1., Cleric 2., Rogue 3., Wizard 4. ) => ");
                                    int heal = scan.nextInt();
                                    this.healBA(this.party.get(j), this.party.get(heal - 1));
                                } else {
                                    if(bar_potions!= 0 && this.party.get(j).getType().equals("Barbarian")){
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    }
                                    else if(rog_potions != 0 && this.party.get(j).getType().equals("Rogue")){
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    }
                                    else if(wiz_potions !=0 && this.party.get(j).getType().equals("Wizard")){
                                        this.healBA(this.party.get(j), this.party.get(j));
                                    }
                                    else{
                                        System.out.println("Sorry the " + this.party.get(j).getType() + " does not have any potions left");
                                    }
                                }
                            }
                            System.out.println("The " + this.party.get(j).getType() + "'s turn is over.\n");
                            this.enemyAttack(imp);
                            System.out.println();
                        }

                    }
                }
            }
        }
        // Stop background music
        StdDraw.pause(1800);
        stopEncounterMusic();
        System.out.println("The party defeated all the imps! Well done!");
        bar_potions = 2;
        rog_potions = 2;
        wiz_potions = 2;
        System.out.println("Members' inventory has been restocked ");
        accomplishment++;

    }
    /**********************************************************
     * METHOD: levelUp()                                      *
     * DESCRIPTION: increases the levels of all party members *
     * and rolls to increase their maximum hit points         *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void levelUp(){
        int hitDice;
        StdDraw.clear();
        // Make a function that has all the members drawn in the forest
        StdDraw.enableDoubleBuffering();
        group_level_photo();
        playEncounterMusic("C:/Users/chloe/OneDrive/Desktop/DND photo/forest_audio-139004.wav");
        StdDraw.show();
        System.out.println("\nThe party is ready to level up!");
        for (int i = 0; i < this.party.size(); i++) {
            this.party.get(i).setLevel(this.party.get(i).getLevel() + 1);
            hitDice = this.party.get(i).getStats().getCONmod();
            if(this.party.get(i).getType().equals("Barbarian")){
                hitDice += this.rollD12();
                Rolling_DiceLevelUP(hitDice,12);
            } else if (this.party.get(i).getType().equals("Cleric") || this.party.get(i).getType().equals("Rogue")){
                hitDice += this.rollD8();
                Rolling_DiceLevelUP(hitDice,8);
                StdDraw.pause(400);
            } else if (this.party.get(i).getType().equals("Wizard")){
                hitDice += this.rollD6();
                Rolling_DiceLevelUP(hitDice,6);
            }
            if (this.party.get(i).getHP() <= 0){
                System.out.println("The " + this.party.get(i).getType() + " has been revived!");
            }
            this.party.get(i).setMaxHP(hitDice); // the Max HP is not setting the new value
            this.party.get(i).healSetHP(this.party.get(i).getMaxHP());
            System.out.println("The " + this.party.get(i).getType() + " has increased to level " + this.party.get(i).getLevel() + "\n"+" and has a new hit point maximum of " + this.party.get(i).getMaxHP());
        }
        StdDraw.clear();
        // Make a function that has all the members drawn in the forest
        group_level_photo();
        StdDraw.show();
        StdDraw.pause(2000);
        stopEncounterMusic();
    }

    int troll = 1;
    /**********************************************************
     * METHOD: encounter2()                                   *
     * DESCRIPTION: runs through the party's encounter with a *
     * troll.                                                 *
     * PARAMETERS: none                                       *
     * RETURN VALUE: none                                     *
     *********************************************************/
    public void encounter2(){
        // for loop within a for loop (number of imps fought)
        StdDraw.clear();
        System.out.println("The party finds their way out of the castle and into the wilderness behind it.");
        System.out.println("While on their walk, they come across large mountains");
        System.out.println("They search for treasure, but instead encounter a Troll!\n");
        StdDraw.picture(0.50, 0.50, "C:/Users/chloe/OneDrive/Desktop/DND photo/DND Mountain Background.jpg", 1.00, 1.0);
        StdDraw.show();
        StdDraw.pause(2000);
        playEncounterMusic("C:/Users/chloe/OneDrive/Desktop/DND photo/troll_music-127812.wav");
        while (this.enemies.get(troll).getHP() != 0) {
            for (int j = 0; j < this.party.size(); j++) {
                if (this.party.get(j).getHP() > 0) {
                    this.hp_bar(this.party.get(j), this.enemies.get(troll));
                    int damageRoll = this.combat(this.party.get(j), this.enemies.get(troll));
                    this.enemies.get(troll).damageSetHP(damageRoll);
                    this.hp_bar(this.party.get(j), this.enemies.get(troll));
                    System.out.println("The Troll has " + this.enemies.get(troll).getHP() + " hit points left." + "\n");
                    if (this.enemies.get(troll).getHP() == 0) {
                        break;
                    } else {
                        System.out.print("Would you like to make a bonus action? (Y/N) => ");
                        String bonus = scan.next();
                        if (bonus.equalsIgnoreCase("Y")) {
                            if(this.party.get(j).getType().equals("Cleric")){
                                System.out.println("Which party member do you want to heal?");
                                System.out.print("1) Barbarian, 2) Cleric, 3) Rogue, 4) Wizard => ");
                                int heal = scan.nextInt();
                                this.healBA(this.party.get(j), this.party.get(heal - 1));
                            } else {
                                if(bar_potions!= 0 && this.party.get(j).getType().equals("Barbarian")){
                                    this.healBA(this.party.get(j), this.party.get(j));
                                }
                                else if(rog_potions != 0 && this.party.get(j).getType().equals("Rogue")){
                                    this.healBA(this.party.get(j), this.party.get(j));
                                }
                                else if(wiz_potions !=0 && this.party.get(j).getType().equals("Wizard")){
                                    this.healBA(this.party.get(j), this.party.get(j));
                                }
                                else {
                                    System.out.println("Sorry the " + this.party.get(j).getType() + " does not have any potions left");
                                }
                            }
                        }
                        System.out.println("The " + this.party.get(j).getType() + "'s turn is over.\n");
                    }
                }
            }
            if(this.enemies.get(troll).getHP() != 0){
                this.enemyAttack(troll);
            }
        }
        StdDraw.pause(2000);
        System.out.println("The party defeated the Troll! Good job!");
        stopEncounterMusic();
        System.out.println("There were " + death_count + " death(s)");
        bar_potions = 2;
        rog_potions = 2;
        wiz_potions = 2;

        System.out.println("Thanks for coming on this adventure with us!");
        System.exit(0);
    }
}

