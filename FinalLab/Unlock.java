import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Unlock{
   // Variables to store operations
   public static final int UNLOCK = 0;
   public static final int SHAKE = 1;
   public static final int PULL = 2;
   public static final int POKE = 3;
   public static final int TWIST = 4;
   
   
   public Unlock(){};
   
   public Node BFS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      // Create the root node
      Node leaf = new Node(null, 0, UNLOCK);
      
      // Create a new queue
      LinkedList<Node> queue = new LinkedList<Node>();
      
      // Enqueue root
      queue.add(leaf);
      
      while (queue.size() != 0)
      {
         System.out.println("Greater than 0");
         // Dequeue a vertex from queue and print it
         leaf = queue.poll();

         if(!lock.isUnlocked()){
            count++;
            queue.add(new Node(leaf, count, SHAKE));
            queue.add(new Node(leaf, count, PULL));
            queue.add(new Node(leaf, count, POKE));
            queue.add(new Node(leaf, count, TWIST));
         }
         
         // Do operation
         if(leaf.operation == SHAKE){
            lock.shakeIt();
         }
         else if(leaf.operation == PULL){
            lock.pullIt();
         }
         else if(leaf.operation == POKE){
            lock.pokeIt();
         }
         else if(leaf.operation == TWIST){
            lock.twistIt();
         }
         
      }
      
      // End Timer
      long end = System.nanoTime();
      // Calculate Time
      long diff = end - start;
      System.out.println("Time to find solution (nanoseconds): ");
      System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
      
      // Return Path
      return leaf;
   }
   
   /*public Node DLDFS(Node curr, int depthLimit){
   
   }
   
   public Node IDS(Node curr){
   
   }*/
   
   // Node Nested Class
   private class Node{
      private Node parent;
      private int depth;
      private int operation;
      
      public Node(Node parent, int depth, int operation){
         this.parent = parent;
         this.depth = depth;
         this.operation = operation;
      }
   }
}