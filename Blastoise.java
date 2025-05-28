public class Blastoise extends Pokemon {
   public Blastoise() {
       super("Blastoise", "Water", 130, 83, 100, 78, new Move[]{
           new Move("Hydro Pump", "Water", 110, 80, "None"),
           new Move("Ice Beam", "Ice", 90, 100, "May freeze"),
           new Move("Bite", "Dark", 60, 100, "May flinch"),
           new Move("Skull Bash", "Normal", 130, 100, "Raises defense")
       });
   }
}
