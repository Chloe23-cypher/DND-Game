public class Character {
    private String type;
    private String race;
    private int level;
    private int hp;
    private int maxHP;
    private int ac;
    private Stats stats;
    private Action action;
    private Action bonusAction;
    private int turn;
    private int image;
    private String name;
    private String hobbies;
    private String profession;
    private String personality;

    public Character(String type, String race, int level, int hp, int maxHP, int ac, Stats stats, Action action, Action bonusAction, int turn, int image, String name, String hobbies, String profession, String personality) {
        this.type = type;
        this.race = race;
        this.level = level;
        this.hp = hp;
        this.maxHP = maxHP;
        this.ac = ac;
        this.stats = stats;
        this.action = action;
        this.bonusAction = bonusAction;
        this.turn = turn;
        this.image = image;
        this.name = name;
        this.hobbies = hobbies;
        this.profession = profession;
        this.personality = personality;
    }

     /**********************************************************
     * METHOD: getType()                                       *
     * DESCRIPTION: get the character's class type             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's class type                *
     **********************************************************/
    public String getType(){
        return type;
    }

     /**********************************************************
     * METHOD: getRace()                                       *
     * DESCRIPTION: get the character's race                   *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's race                      *
     **********************************************************/
    public String getRace(){
        return race;
    }

     /**********************************************************
     * METHOD: getLevel()                                      *
     * DESCRIPTION: get the character's strength level         *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's level                     *
     **********************************************************/
    public int getLevel(){
        return level;
    }

     /**********************************************************
     * METHOD: getHP()                                         *
     * DESCRIPTION: get the character's hit points             *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's hit points                *
     **********************************************************/
     public int getHP(){
         return hp;
     }

     /**********************************************************
     * METHOD: getMaxHP()                                      *
     * DESCRIPTION: get the character's maximum hit points     *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's maximum hit points        *
     **********************************************************/
     public int getMaxHP(){
         return maxHP;
     }

     /**********************************************************
     * METHOD: getAC()                                         *
     * DESCRIPTION: get the character's armor class            *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's armor class               *
     **********************************************************/
    public int getAC(){
        return ac;
    }

     /**********************************************************
     * METHOD: getStats()                                      *
     * DESCRIPTION: get the character's stats                  *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's stats                     *
     **********************************************************/
     public Stats getStats(){
         return stats;
     }

     /**********************************************************
     * METHOD: getAction()                                     *
     * DESCRIPTION: get the character's action/attack          *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's action/attack             *
     **********************************************************/
    public Action getAction(){
        return action;
    }

     /**********************************************************
     * METHOD: getBonusAction()                                *
     * DESCRIPTION: get the character's bonus action           *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's bonus action              *
     **********************************************************/
    public Action getBonusAction(){
        return bonusAction;
    }

     /**********************************************************
     * METHOD: getTurn()                                       *
     * DESCRIPTION: get the character's bonus action           *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's bonus action              *
     **********************************************************/
    public int getTurn(){
        return this.turn;
    }

    public int getImage(){
        return this.image;
    }

    public String getName() {
        return this.name;
    }
    public String getHobbies() {
        return this.hobbies;
    }
    public String getProfession() {
        return this.profession;
    }
    public String getPersonality() {
        return this.personality;
    }


     /***********************************************************
     * METHOD: setLevel()                                       *
     * DESCRIPTION: set the party member's level                *
     * PARAMETERS: none                                         *
     * RETURN VALUE: the character's hit points                 *
     ***********************************************************/
    public void setLevel(int level){
        this.level = level;
    }

     /***********************************************************
     * METHOD: setMaxHP()                                       *
     * DESCRIPTION: reset maximum hit points                    *
     * PARAMETERS: none                                         *
     * RETURN VALUE: the character's hit points                 *
     ***********************************************************/
    public void setMaxHP(int hp){
        this.maxHP += hp;
    }

     /***********************************************************
     * METHOD: setTurn()                                        *
     * DESCRIPTION: increase the players' turn                  *
     * PARAMETERS: none                                         *
     * RETURN VALUE: none                                       *
     ***********************************************************/
    public void setTurn(int change){
        this.turn += change;
    }

     /***********************************************************
     * METHOD: setImage()                                       *
     * DESCRIPTION: sets the image that is shown in the combat  *
     * sequence.                                                *
     * PARAMETERS: none                                         *
     * RETURN VALUE: none                                       *
     ***********************************************************/
    public void setImage(int image){
        this.image = image;
    }

     /**********************************************************
     * METHOD: damageSetHP()                                   *
     * DESCRIPTION: set the character's hit points after taking*
     * damage.                                                 *
     * PARAMETERS: none                                        *
     * RETURN VALUE: the character's hit points                *
     **********************************************************/
    public void damageSetHP(int damage){
        this.hp = hp - damage;
        if (this.hp < 0){
            this.hp = 0;
        }
    }

     /***********************************************************
     * METHOD: healSetHP()                                      *
     * DESCRIPTION: set the character's hit points after healing*
     * PARAMETERS: none                                         *
     * RETURN VALUE: the character's hit points                 *
     ***********************************************************/
    public void healSetHP(int health){
        this.hp = hp + health;
        if (this.hp > maxHP){
            this.hp = maxHP;
        }
    }



}
