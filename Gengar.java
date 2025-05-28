public class Gengar extends Pokemon {
   public Gengar() {
       super("Gengar", "Ghost/Poison", 110, 65, 60, 110, new Move[]{
           new Move("Shadow Ball", "Ghost", 80, 100, "May lower defense"),
           new Move("Dark Pulse", "Dark", 80, 100, "May flinch"),
           new Move("Sludge Wave", "Poison", 95, 100, "May poison"),
           new Move("Hypnosis", "Psychic", 0, 60, "Puts to sleep")
       });
   }
}
