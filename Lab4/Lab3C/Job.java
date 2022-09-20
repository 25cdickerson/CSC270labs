public class Job{
   // Allow children to access attributes
   protected String jobName;
   
   // Constructor - Children Will Change
   // Job will return null until child constructor is called
   public Job(){}
   
   // Methods
   
   // Attacks specific to jobs
   public int attack(int STR, int DEX, int INT, int val){
      return 0;
   } // Every child needs one!!
   
   
   // The get job function returns the name of the job
   public String getJob(){
      return jobName;
   }
}