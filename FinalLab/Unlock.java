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
   
   // Print out Solution
   public void printSolution(Node node){
      System.out.println("The Solution is: ");
      while(node != null){
         if(node.operation == SHAKE){
               System.out.println("SHAKE IT!");
         }
         else if(node.operation == PULL){
               System.out.println("PULL IT!");

         }
         else if(node.operation == TWIST){
               System.out.println("TWIST IT!");
         }
         else if(node.operation == POKE){
               System.out.println("POKE IT!");
         }
         node = node.parent;
      }
   } 

   // Traverse Upward
   public boolean traverse(Node node, TheLock lock){
      while(node !=  null){
            if(node.operation == SHAKE){
               lock.shakeIt();
            }
            else if(node.operation == PULL){
                 lock.pullIt();

            }
            else if(node.operation == TWIST){
                    lock.twistIt();
            }
            else if(node.operation == POKE){
                   lock.pokeIt();
            }
                     
            if(node.operation == UNLOCK){
               if(lock.isUnlocked()){
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
      
      // Create Flag Variable for loop
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
            if(isCorrect){
               break;
            }
            
            // Do operation
            while(!queue.isEmpty()){
                  leaf = queue.poll();
                  
                  if(traverse(leaf, lock)){
                     isCorrect = true;
                     printSolution(leaf);
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
      
      // Create Flag Variable for loop
      boolean isCorrect = false;
      
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
            
            if(isCorrect){
               break;
            }
            
            if(traverse(leaf, lock)){
               isCorrect = true;
               printSolution(leaf);
               break;
            }
            
            lock.resetLock();
               
            // Check if within range
            if(leaf.depth < depthLimit){
                  count++;
                  stack.push(new Node(leaf, count, SHAKE));
                  stack.push(new Node(leaf, count, PULL));
                  stack.push(new Node(leaf, count, POKE));
                  stack.push(new Node(leaf, count, TWIST));
            }
            else{
               System.out.println("Solution Could Not Be Found in " + depthLimit + " Levels");
               break;
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