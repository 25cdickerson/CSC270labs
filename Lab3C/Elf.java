public class Elf extends Hero{
   // Constructor
   public Elf(Job job){
      super(job);
      race = "ELF";
   }
   
   // Elfs have a higher DEX so overload
   public int getDEX(){
      return super.getDEX() + 5;
   }
   
   // Override the attack
   //public int attack
}