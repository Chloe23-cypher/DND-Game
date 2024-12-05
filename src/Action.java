/******************************************************************
*                        Party Members' Actions                   *
*                                                                 *
* PROGRAMMER:Chloe Barber and Bella Brownlee                      *
* COURSE: CS201                                                   *
* DATE: 12/05/2024                                                *
* REQUIREMENT: Final Project                                      *
*                                                                 *
* DESCRIPTION:                                                    *
* The following program creates the class Action and adds fields  *
* for action1 and action2. It also includes get methods for both  *
* attacks.                                                        *
*                                                                 *
* COPYRIGHT: This code is copyright (C) 2024 Chloe Barber, Bella  *
* Brownlee, and Dean Zeller.                                      *
*                                                                 *
* CREDITS: This code was written in its entirety by Chloe Barber  *
* and Bella Brownlee.                                             *
******************************************************************/
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
