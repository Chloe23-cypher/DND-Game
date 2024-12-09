/*******************************************************************
 *                       Party Members' Attacks                    *
 *                                                                 *
 * PROGRAMMER:Chloe Barber and Bella Brownlee                      *
 * COURSE: CS201                                                   *
 * DATE: 12/05/2024                                                *
 * REQUIREMENT: Final Project                                      *
 *                                                                 *
 * DESCRIPTION:                                                    *
 * The following program creates the class Attack and adds fields  *
 * for the attributes of the attacks. It also includes get methods *
 * for each field.                                                 *
 *                                                                 *
 * COPYRIGHT: This code is copyright (C) 2024 Chloe Barber, Bella  *
 * Brownlee, and Dean Zeller.                                      *
 *                                                                 *
 * CREDITS: This code was written in its entirety by Chloe Barber  *
 * and Bella Brownlee.                                             *
 ******************************************************************/
public class Attack {
    private String weapon;
    String useDC;
    private int attackBonus;
    private int DC;
    private String damage;

    public Attack(String weapon, String useDC, int attackBonus, int DC, String damage) {
        this.weapon = weapon;
        this.useDC = useDC;
        this.attackBonus = attackBonus;
        this.DC = DC;
        this.damage = damage;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public String getUseDC() {
        return this.useDC;
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }

    public int getDC() {
        return this.DC;
    }

    public String getDamage() {
        return this.damage;
    }
}
