public class Hero implements HeroInterface{
   // Store the job name
   protected Job job;
   protected String race = null;
   
   // Constructor will construct hero with job, 
   // race will come from the children
   public Hero(Job job){
      this.job = job;
   }
   
   // Set generic stats
   public int getSTR(){
      return 20;
   }
   
   public int getINT(){
      return 20;
   }
   
   public int getDEX(){
      return 20;
   }
   
   // attack method calls the attack method of the job
   public int attack(int val){
      return job.attack(getSTR(), getDEX(), getINT(), val);
   }
   
   // Return job 
   public String getJobName(){
      return job.getJob();
   }
   
   // Return null because there is not an initialized race name yet
   public String getRaceName(){
      return race;
   }
   
}