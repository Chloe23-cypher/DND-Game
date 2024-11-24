public class DnDGame {
    public static void main(String[] args) {
        System.out.println("Welcome to your DnD Campaign!");
        DnDParty party = new DnDParty();
        party.meet_party();
        System.out.print("Having meet your members, ");
        party.interfaceLoop();

    }
}

