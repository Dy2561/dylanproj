public class Move {
   String name;
   String type;
   int power;
   int accuracy;
   String effect;


   public Move(String name, String type, int power, int accuracy, String effect) {
       this.name = name;
       this.type = type;
       this.power = power;
       this.accuracy = accuracy;
       this.effect = effect;
   }


   public String toString() {
       return name + " (" + type + ", Power: " + power + ", Acc: " + accuracy + ") - " + effect;
   }
}
