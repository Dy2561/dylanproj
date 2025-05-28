class Snorlax extends Pokemon {
   public Snorlax() {
       super("Snorlax", "Normal", 160, 110, 65, 30, new Move[]{
           new Move("Body Slam", "Normal", 85, 100, "May paralyze"),
           new Move("Crunch", "Dark", 80, 100, "May lower defense"),
           new Move("Heavy Slam", "Steel", 100, 100, "None"),
           new Move("Rest", "Psychic", 0, 100, "Fully heals and sleeps")
       });
   }
}
