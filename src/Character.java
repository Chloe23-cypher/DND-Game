//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
    private int abilityScore;
    private String sign;
    private String name;
    private String hobbies;
    private String profession;
    private String personality;
    private static int turn = 0;

    public Character(String type, String race, int level, int hp, int maxHP, int ac, Stats stats, Action action, Action bonusAction, String name, String hobbies, String profession, String personality) {
        this.type = type;
        this.race = race;
        this.level = level;
        this.hp = hp;
        this.maxHP = maxHP;
        this.ac = ac;
        this.stats = stats;
        this.action = action;
        this.bonusAction = bonusAction;
        this.name = name;
        this.hobbies = hobbies;
        this.profession = profession;
        this.personality = personality;
        turn = turn;
    }

    public String getType() {
        return this.type;
    }

    public String getRace() {
        return this.race;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHP() {
        return this.hp;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getAC() {
        return this.ac;
    }

    public Stats getStats() {
        return this.stats;
    }

    public Action getAction() {
        return this.action;
    }

    public Action getBonusAction() {
        return this.bonusAction;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxHP(int hp) {
        this.hp = hp;
    }

    public void damageSetHP(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }

    }

    public void healSetHP(int health) {
        this.hp += health;
        if (this.hp > this.maxHP) {
            this.hp = this.maxHP;
        }

    }
}
