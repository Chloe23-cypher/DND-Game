//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
