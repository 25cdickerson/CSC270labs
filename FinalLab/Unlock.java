import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Unlock{
   // Variables to store operations
   public static final int UNLOCK = 0;
   public static final int SHAKE = 1;
   public static final int PULL = 2;
   public static final int POKE = 3;
   public static final int TWIST = 4;
   
   
   public Unlock(){};
   
   // Breadth First Search to Unlock
   public Node BFS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      
      // Create the root node
      Node leaf = new Node(null, 0, UNLOCK);
      
      // Check if already unlocked
      if(lock.isUnlocked()){
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - BFS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         return leaf;
      }
      else{
         
         // Create a new queue
         LinkedList<Node> queue = new LinkedList<Node>();
         
         // Enqueue root
         queue.add(leaf);
         
         // Set step var
         int step = 0;
         
         while (queue.size() != 0)
         {
            System.out.println("Greater than 0");
            
            // Do operation
            while(!queue.isEmpty()){
                  leaf = queue.poll();
                  while(leaf.parent != null){
                     System.out.println("getting parents");
                     if(leaf.operation == SHAKE){
                        lock.shakeIt();
                     }
                     else if(leaf.operation == PULL){
                        lock.pullIt();
                     }
                     else if(leaf.operation == TWIST){
                        lock.shakeIt();
                     }
                     else if(leaf.operation == POKE){
                        lock.pokeIt();
                     }
                     
                     if(leaf.operation == UNLOCK){
                        lock.isUnlocked();
                     }
                     leaf = leaf.parent;
                  }
                  
                  lock.resetLock();
                  count++;
                  queue.add(new Node(queue.peek(), count, SHAKE));
                  queue.add(new Node(queue.peek(), count, PULL));
                  queue.add(new Node(queue.peek(), count, POKE));
                  queue.add(new Node(queue.peek(), count, TWIST));
            }
         }
      }
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - BFS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         // Return Path
         return leaf;
   }
   
   public Node DLDFS(TheLock lock, int depthLimit){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      
      // Create the root node
      Node leaf = new Node(null, 0, UNLOCK);
      
      // Check if already unlocked
      if(lock.isUnlocked()){
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - DLDFS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         return leaf;
      }
      else{
         // Create a stack for DFS
         Stack<Node> stack = new Stack<Node>();
         Node node = new Node(null, 0, UNLOCK);
         stack.push(node);
         Node U;
         
         while(!stack.empty()){
            // Pop U off the stack
            node = stack.peek();
            U = stack.pop();
            
            if(U.operation == UNLOCK){
               lock.isUnlocked();
            }
            else if(U.operation == SHAKE){
               lock.shakeIt();
            }
            else if(U.operation == PULL){
               lock.pullIt();
            }
            else if(U.operation == POKE){
               lock.pokeIt();
            }
            else if(U.operation == TWIST){
               lock.twistIt();
            }
            
            if(lock.isUnlocked()){
               return U;
            }
            lock.resetLock();
            
            // Check if within range
            if(U.depth < depthLimit){
               stack.push(new Node(U, count, SHAKE));
               stack.push(new Node(U, count, PULL));
               stack.push(new Node(U, count, POKE));
               stack.push(new Node(U, count, TWIST));
         }
         
      }
      // End Timer
      long end = System.nanoTime();
      // Calculate Time
      long diff = end - start;
      System.out.println("Time to find solution - DLDFS (nanoseconds): ");
      System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
      return node;
   }
 }
   
   public Node IDS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      
      // Check if already unlocked
      if(lock.isUnlocked()){
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - DLDFS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         return new Node(null, 0, UNLOCK);
      }
      else{
         int loop = -1;
         while(true){
            loop++;
            Node check = DLDFS(lock, count);
            if(lock.isUnlocked()){
               // End Timer
               long end = System.nanoTime();
               // Calculate Time
               long diff = end - start;
               System.out.println("Time to find solution - DLDFS (nanoseconds): ");
               System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
               return check;
            }
         }
      }
   }
   
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