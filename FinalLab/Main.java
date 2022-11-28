public class Main{   
   public static void main(String[] args){
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test", 5);
      System.out.println("Breadth First Search");
      u.BFS(lock);
      System.out.println("Is the lock unlocked? ");
      System.out.println(lock.isUnlocked());
      lock.resetLock();
      
      System.out.println("");
      System.out.println("Depth Limited Depth First Search");
      u.DLDFS(lock, 10000);
      System.out.println(lock.isUnlocked());
      lock.resetLock();
      
      System.out.println("");
      System.out.println("Iterative Deepening");
      u.IDS(lock);
      System.out.println(lock.isUnlocked());
   }
}