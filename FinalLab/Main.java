public class Main{   
   public static void main(String[] args){
      // RUNNING TESTS TO UNLOCK LOCK - Used Many different combos, this was just my last test
   
      // Create the Lock and an Unlock Object
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test");
      
      // Start Depth Limited Depth First Search
      System.out.println("");
      System.out.println("Depth Limited Depth First Search");
      u.DLDFS(lock, 4);
      System.out.println("Is the lock unlocked? ");
      System.out.println(lock.isUnlocked());
      System.out.println("////////////////////");
      lock.resetLock();*/
      
      // Start Iterative Deepening
      System.out.println("");
      System.out.println("Iterative Deepening");
      u.IDS(lock);
      System.out.println("Is the lock unlocked? ");
      System.out.println(lock.isUnlocked());
      System.out.println("////////////////////");
      lock.resetLock();
      
      // Start Breadth First Search
      System.out.println("Breadth First Search");
      u.BFS(lock);
      System.out.println("Is the lock unlocked? ");
      System.out.println(lock.isUnlocked());
      System.out.println("////////////////////");
      lock.resetLock();
   }
}