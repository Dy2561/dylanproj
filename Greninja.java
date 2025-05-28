public class Greninja extends Pokemon {
    public Greninja() {
        super("Greninja", "Water/Dark", 110, 95, 67, 122, new Move[]{
            new Move("Water Shuriken", "Water", 15, 100, "Hits 2-5 times"),
            new Move("Dark Pulse", "Dark", 80, 100, "May flinch"),
            new Move("Ice Beam", "Ice", 90, 100, "May freeze"),
            new Move("Extrasensory", "Psychic", 80, 100, "May flinch")
        });
    }
}
