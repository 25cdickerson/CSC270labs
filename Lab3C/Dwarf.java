public class Dwarf extends Hero{
   // Constructor
   public Dwarf(Job job){
      super(job);
      race = "DWARF";
   }
   
   // Dwarves have a higher STR so overload
   public int getSTR(){
      return super.getSTR() + 5;
   }
   
   // Override the attack
   //public int attack
}