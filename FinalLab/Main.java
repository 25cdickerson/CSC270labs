public class Main{
   public static void main(String[] args){
      Unlock u = new Unlock();
      TheLock lock = new TheLock("Test", 1);
      u.DLDFS(lock, 5);
      System.out.println(lock.isUnlocked());
   }
}