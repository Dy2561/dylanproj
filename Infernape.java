class Infernape extends Pokemon {
   public Infernape() {
       super("Infernape", "Fire/Fighting", 120, 104, 71, 108, new Move[]{
           new Move("Flare Blitz", "Fire", 120, 100, "Recoil damage"),
           new Move("Close Combat", "Fighting", 120, 100, "Lowers defense"),
           new Move("Mach Punch", "Fighting", 40, 100, "Always goes first"),
           new Move("U-turn", "Bug", 70, 100, "Switches out")
       });
   }
}
