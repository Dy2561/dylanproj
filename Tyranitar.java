class Tyranitar extends Pokemon {
   public Tyranitar() {
       super("Tyranitar", "Rock/Dark", 150, 134, 110, 61, new Move[]{
           new Move("Crunch", "Dark", 80, 100, "May lower defense"),
           new Move("Stone Edge", "Rock", 100, 80, "High crit ratio"),
           new Move("Earthquake", "Ground", 100, 100, "None"),
           new Move("Thunder Fang", "Electric", 65, 95, "May paralyze")
       });
   }
}

