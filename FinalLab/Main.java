public class Main{
   public static void main(String[] args){
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test", 5);
      //lock.twistIt();
      //lock.twistIt();
      u.BFS(lock);
      System.out.println(lock.isUnlocked());
   }
}