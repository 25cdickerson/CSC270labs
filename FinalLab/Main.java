public class Main{
   public static void main(String[] args){
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test", 1);
      System.out.println(u.BFS(lock));
   }
}