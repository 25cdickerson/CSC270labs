public class HeroFactory
{
   public static HeroInterface createHero(String raceName, String jobName)   
   {
      Hero finalHero = null;
      Job finalJob = null;
      // Check for job name and null job.
      if(jobName.equals("WARRIOR")){
         finalJob = new Warrior();
      }
      else if(jobName.equals("ARCHER")){
         finalJob = new Archer();
      }
      else if(jobName.equals("MAGE")){
         finalJob = new Mage();
      }
      else{
         return null;
      }
      
      // Check for race and null job
      if(raceName.equals("ELF")){
         finalHero = new Elf(finalJob);
      }
      else if(raceName.equals("DWARF")){
         finalHero = new Dwarf(finalJob);
      }
      else if(raceName.equals("ROBOT")){
         finalHero = new Robot(finalJob);
      }
      else{
         return null;
      }
      
      return finalHero;
   }
}