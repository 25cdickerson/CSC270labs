public class Robot extends Hero{
   // Constructor
   public Robot(Job job){
      super(job);
      race = "ROBOT";
   }
   
   // Robots have a higher INT so overload
   public int getINT(){
      return super.getINT() + 5;
   }
   
   // Override the attack
   //public int attack
}