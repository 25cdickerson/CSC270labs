public class Archer extends Job{
   // Constructor Sets JobName
   public Archer(){
      jobName = "ARCHER";
   }
   
   // attack method for Archer (DEX * 1.5 * val)
   public int attack(int STR, int DEX, int INT, int val){
      return (int)(DEX * 1.5 * val);
   }
}