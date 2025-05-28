public class Charizard extends Pokemon {
   public Charizard() {
       super("Charizard", "Fire/Flying", 120, 84, 78, 100, new Move[]{
           new Move("Flamethrower", "Fire", 90, 100, "May burn"),
           new Move("Air Slash", "Flying", 75, 95, "May flinch"),
           new Move("Dragon Claw", "Dragon", 80, 100, "None"),
           new Move("Slash", "Normal", 70, 100, "High crit ratio")
       });
   }
}
