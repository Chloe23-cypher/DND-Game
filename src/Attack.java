public class Attack {
    private String weapon;
    String useDC;
    private int attackBonus;
    private int DC;
    private String damage;


    public Attack(String weapon, String useDC, int attackBonus, int DC, String damage){
        this.weapon = weapon;
        this.useDC = useDC;
        this.attackBonus = attackBonus;
        this.DC = DC;
        this.damage = damage;
    }

     /**********************************************************
     * METHOD: getWeapon()                                     *
     * DESCRIPTION: get the name of the attack/spell           *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the name of the attack/spell              *
     **********************************************************/
    public String getWeapon(){
        return weapon;
    }

     /**********************************************************
     * METHOD: getUseDC()                                      *
     * DESCRIPTION: get if the attack is a spell or weapon     *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's class type                *
     **********************************************************/
    public String getUseDC(){
        return useDC;
    }

     /**********************************************************
     * METHOD: getAttackBonus()                                *
     * DESCRIPTION: get bonus added to attack rolls (to hit)   *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's class type                *
     **********************************************************/
     public int getAttackBonus(){
         return attackBonus;
     }

     /**********************************************************
     * METHOD: getDC()                                         *
     * DESCRIPTION: get the character's spell DC               *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's class type                *
     **********************************************************/
    public int getDC(){
        return DC;
    }

     /**********************************************************
     * METHOD: getDamage()                                     *
     * DESCRIPTION: get the damage done by the attack          *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the damage done by the attack             *
     **********************************************************/
    public String getDamage(){
        return damage;
    }

}
