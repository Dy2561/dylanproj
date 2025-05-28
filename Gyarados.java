class Gyarados extends Pokemon {
   public Gyarados() {
       super("Gyarados", "Water/Flying", 140, 125, 79, 81, new Move[]{
           new Move("Waterfall", "Water", 80, 100, "May flinch"),
           new Move("Crunch", "Dark", 80, 100, "May lower defense"),
           new Move("Ice Fang", "Ice", 65, 95, "May flinch or freeze"),
           new Move("Dragon Dance", "Dragon", 0, 100, "Raises atk/speed")
       });
   }
}


