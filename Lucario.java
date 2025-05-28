class Lucario extends Pokemon {
   public Lucario() {
       super("Lucario", "Fighting/Steel", 115, 110, 70, 90, new Move[]{
           new Move("Aura Sphere", "Fighting", 80, 100, "Never misses"),
           new Move("Meteor Mash", "Steel", 90, 90, "May raise attack"),
           new Move("Close Combat", "Fighting", 120, 100, "Lowers defense"),
           new Move("Extreme Speed", "Normal", 80, 100, "Always goes first")
       });
   }
}
