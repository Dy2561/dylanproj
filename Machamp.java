class Machamp extends Pokemon {
   public Machamp() {
       super("Machamp", "Fighting", 140, 130, 80, 55, new Move[]{
           new Move("Dynamic Punch", "Fighting", 100, 50, "Confuses target"),
           new Move("Cross Chop", "Fighting", 100, 80, "High crit ratio"),
           new Move("Knock Off", "Dark", 65, 100, "Removes item"),
           new Move("Bullet Punch", "Steel", 40, 100, "Always goes first")
       });
   }
}
