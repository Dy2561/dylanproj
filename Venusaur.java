public class Venusaur extends Pokemon {
   public Venusaur() {
       super("Venusaur", "Grass/Poison", 130, 82, 83, 80, new Move[]{
           new Move("Solar Beam", "Grass", 120, 100, "Charges 1 turn"),
           new Move("Sludge Bomb", "Poison", 90, 100, "May poison"),
           new Move("Earthquake", "Ground", 100, 100, "None"),
           new Move("Sleep Powder", "Grass", 0, 75, "Puts to sleep")
       });
   }
}