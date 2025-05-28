class Gardevoir extends Pokemon {
   public Gardevoir() {
       super("Gardevoir", "Psychic/Fairy", 120, 65, 65, 80, new Move[]{
           new Move("Moonblast", "Fairy", 95, 100, "None"),
           new Move("Psychic", "Psychic", 90, 100, "None"),
           new Move("Shadow Ball", "Ghost", 80, 100, "None"),
           new Move("Calm Mind", "Psychic", 0, 100, "Raises atk/def")
       });
   }
}
