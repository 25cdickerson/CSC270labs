public class Warrior extends Job{
   // Constructor Sets JobName
   public Warrior(){
      jobName = "WARRIOR";
   }
   
   // attack method for Warrior (STR * val + DEX)
   public int attack(int STR, int DEX, int INT, int val){
      return STR * val + DEX;
   }
}