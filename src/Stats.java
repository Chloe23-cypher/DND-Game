//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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

    public int getSTR() {
        return this.STR;
    }

    public int getDEX() {
        return this.DEX;
    }

    public int getCON() {
        return this.CON;
    }

    public int getINT() {
        return this.INT;
    }

    public int getWIS() {
        return this.WIS;
    }

    public int getCHA() {
        return this.CHA;
    }

    public int getSTRmod() {
        int mod = (this.STR - 10) / 2;
        return mod;
    }

    public int getDEXmod() {
        int mod = (this.DEX - 10) / 2;
        return mod;
    }

    public int getCONmod() {
        int mod = (this.CON - 10) / 2;
        return mod;
    }

    public int getINTmod() {
        int mod = (this.INT - 10) / 2;
        return mod;
    }

    public int getWISmod() {
        int mod = (this.WIS - 10) / 2;
        return mod;
    }

    public int getCHAmod() {
        int mod = (this.CHA - 10) / 2;
        return mod;
    }

    public String calcSign(int abilityScore) {
        return abilityScore < 0 ? "" : "+";
    }
}
