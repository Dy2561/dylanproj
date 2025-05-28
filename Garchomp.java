class Garchomp extends Pokemon {
   public Garchomp() {
       super("Garchomp", "Dragon/Ground", 130, 130, 95, 102, new Move[]{
           new Move("Dragon Rush", "Dragon", 100, 75, "May flinch"),
           new Move("Earthquake", "Ground", 100, 100, "None"),
           new Move("Stone Edge", "Rock", 100, 80, "High crit ratio"),
           new Move("Fire Fang", "Fire", 65, 95, "May flinch or burn")
       });
   }
}
