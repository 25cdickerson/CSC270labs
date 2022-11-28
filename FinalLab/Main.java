public class Main{   
   public static void main(String[] args){
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test", 0);
      System.out.println("Breadth First Search");
      u.BFS(lock);
      lock.resetLock();
      System.out.println("");
      System.out.println("Depth Limited Depth First Search");
      u.DLDFS(lock, 2);
      System.out.println(lock.isUnlocked());
   }
}