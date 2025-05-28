public class Pikachu extends Pokemon {
    public Pikachu() {
        super("Pikachu", "Electric", 100, 55, 40, 90, new Move[]{
            new Move("Thunderbolt", "Electric", 90, 100, "May paralyze"),
            new Move("Quick Attack", "Normal", 40, 100, "Always goes first"),
            new Move("Iron Tail", "Steel", 100, 75, "May lower defense"),
            new Move("Electro Ball", "Electric", 80, 100, "None")
        });
    }
}
