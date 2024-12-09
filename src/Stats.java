/*******************************************************************
 *                         Party Members' Stats                    *
 *                                                                 *
 * PROGRAMMER:Chloe Barber and Bella Brownlee                      *
 * COURSE: CS201                                                   *
 * DATE: 12/05/2024                                                *
 * REQUIREMENT: Final Project                                      *
 *                                                                 *
 * DESCRIPTION:                                                    *
 * The following program creates the class Stats and adds fields   *
 * strength, dexterity, constitution, intelligence, wisdom, and    *
 * charisma. It also includes get methods for each ability score   *
 * and respective ability modifiers.                               *
 *                                                                 *
 * COPYRIGHT: This code is copyright (C) 2024 Chloe Barber, Bella  *
 * Brownlee, and Dean Zeller.                                      *
 *                                                                 *
 * CREDITS: This code was written in its entirety by Chloe Barber  *
 * and Bella Brownlee.                                             *
 ******************************************************************/
public class Stats {
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    public Stats(int STR, int DEX, int CON, int INT, int WIS, int CHA) {
        this.STR = STR;
        this.DEX = DEX;
        this.CON = CON;
        this.INT = INT;
        this.WIS = WIS;
        this.CHA = CHA;
    }

    /***********************************************************
     * METHOD: getSTR()                                        *
     * DESCRIPTION: get the character's strength ability score *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's strength ability score    *
     **********************************************************/
    public int getSTR() {
        return STR;
    }

    /************************************************************
     * METHOD: getDEX()                                         *
     * DESCRIPTION: get the character's dexterity ability score *
     * PARAMETERS: none                                         *
     * RETURN VALUE: the character's dexterity ability score    *
     ***********************************************************/
    public int getDEX() {
        return DEX;
    }

    /***********************************************************
     * METHOD: getCON()                                        *
     * DESCRIPTION: get the character's constitution ability   *
     * score                                                   *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's constitution ability      *
     * score                                                   *
     **********************************************************/
    public int getCON() {
        return CON;
    }

    /***************************************************************
     * METHOD: getINT()                                            *
     * DESCRIPTION: get the character's intelligence ability score *
     * PARAMETERS: none                                            *
     * RETURN VALUE: the character's intelligence ability score    *
     **************************************************************/
    public int getINT() {
        return INT;
    }

    /***********************************************************
     * METHOD: getWIS()                                        *
     * DESCRIPTION: get the character's wisdom ability score   *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's wisdom ability score      *
     **********************************************************/
    public int getWIS() {
        return WIS;
    }

    /***********************************************************
     * METHOD: getCHA()                                        *
     * DESCRIPTION: get the character's charisma ability score *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's charisma ability score    *
     **********************************************************/
    public int getCHA() {
        return CHA;
    }

    /***********************************************************
     * METHOD: getDEXmod()                                     *
     * DESCRIPTION: get the character's dexterity modifier     *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's dexterity modifier        *
     **********************************************************/
    public int getDEXmod() {
        int mod = (this.DEX - 10) / 2;
        return mod;
    }

    /***************************************************************
     * METHOD: getCONmod()                                         *
     * DESCRIPTION: get the character's constitution ability score *
     * PARAMETERS: none                                            *
     * RETURN VALUE: the character's charisma ability score        *
     **************************************************************/
    public int getCONmod() {
        int mod = (this.CON - 10) / 2;
        return mod;
    }



}