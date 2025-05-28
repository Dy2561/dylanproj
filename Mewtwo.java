class Mewtwo extends Pokemon {
   public Mewtwo() {
       super("Mewtwo", "Psychic", 140, 110, 90, 130, new Move[]{
           new Move("Psychic", "Psychic", 90, 100, "None"),
           new Move("Shadow Ball", "Ghost", 80, 100, "None"),
           new Move("Aura Sphere", "Fighting", 80, 100, "Never misses"),
           new Move("Recover", "Psychic", 0, 100, "Heals half HP")
       });
   }
}
