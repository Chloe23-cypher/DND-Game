public class Action {
    private Attack action1;
    private Attack action2;

    public Action(Attack action1, Attack action2) {
        this.action1 = action1;
        this.action2 = action2;
    }

     /************************************************************
     * METHOD: getAttack1()                                      *
     * DESCRIPTION: get the character's first Attack/weapon/spell*
     * PARAMETERS: none                                          *
     * RETURN VALUE: the character's first Attack/weapon/spell   *
     ************************************************************/
    public Attack getAttack1(){
        return action1;
    }

     /*************************************************************
     * METHOD: getAttack2()                                       *
     * DESCRIPTION: get the character's second Attack/weapon/spell*
     * PARAMETERS: none                                           *
     * RETURN VALUE: the character's second Attack/weapon/spell   *
     *************************************************************/
    public Attack getAttack2() {
        return action2;
    }

}
