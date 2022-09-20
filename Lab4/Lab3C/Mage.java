public class Mage extends Job{
   // Constructor Sets JobName
   public Mage(){
      jobName = "MAGE";
   }
   
   // attack method for Archer DEX + INT * val
   public int attack(int STR, int DEX, int INT, int val){
      return DEX + INT * val;
   }
}