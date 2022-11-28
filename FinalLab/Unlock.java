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
   
   // Traverse Upward
   public boolean traverse(Node node, TheLock lock){
      while(node !=  null){
            if(node.operation == SHAKE){
               lock.shakeIt();
               System.out.println("Shake");
            }
            else if(node.operation == PULL){
                 lock.pullIt();
                 System.out.println("Pull");

            }
            else if(node.operation == TWIST){
                    lock.twistIt();
                    System.out.println("Twist");
            }
            else if(node.operation == POKE){
                   lock.pokeIt();
                   System.out.println("Poke");
            }
                     
            if(node.operation == UNLOCK){
               System.out.println("Is it unlocked?");
               if(lock.isUnlocked()){
                  System.out.println("Yes");
                  return true;
               }
            }
            node = node.parent;
      }
      return false;
   }
   
   
   // Breadth First Search to Unlock
   public Node BFS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      boolean isCorrect = false;
      
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
         
         while (queue.size() != 0)
         {
            System.out.println("Greater than 0");
            
            if(isCorrect){
               break;
            }
            
            // Do operation
            while(!queue.isEmpty()){
                  leaf = queue.poll();
                  
                  if(traverse(leaf, lock)){
                     isCorrect = true;
                     break;
                  }
                  
                  lock.resetLock();
                  count++;
                  queue.add(new Node(leaf, count, SHAKE));
                  queue.add(new Node(leaf, count, PULL));
                  queue.add(new Node(leaf, count, POKE));
                  queue.add(new Node(leaf, count, TWIST));
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
         stack.push(leaf);
         
         while(!stack.isEmpty()){
            leaf = stack.pop();
            if(traverse(leaf, lock)){
               break;
            }
            
            lock.resetLock();
               
               // Check if within range
               if(leaf.depth < depthLimit){
                  stack.push(new Node(leaf, count, SHAKE));
                  stack.push(new Node(leaf, count, PULL));
                  stack.push(new Node(leaf, count, POKE));
                  stack.push(new Node(leaf, count, TWIST));
            }
         }
         
      }
      // End Timer
      long end = System.nanoTime();
      // Calculate Time
      long diff = end - start;
      System.out.println("Time to find solution - DLDFS (nanoseconds): ");
      System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
      return leaf;
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