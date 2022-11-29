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
   
   // Variable to store the number of nodes visited
   private int nodesVisited = 0;
   
   // Storing information for IDS
   private int nodesIDS = 0;
   private Stack<Node> stackIDS = new Stack<Node>();
   
   
   // Empty Unlock Constructor
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
      // Traverse Upwards until reaching null
      while(node !=  null){
            // Do the operation
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
            // Increment nodesVisited to store the number of nodesVisited
            nodesVisited++;
            // Traverse Upwards
            node = node.parent;
      }
      return false;
   }
   
   
   // Breadth First Search to Unlock
   public Node BFS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      
      // Reset nodesVisited to 0
      nodesVisited = 0;
      
      // Create the root node
      Node leaf = new Node(null, 0, UNLOCK);
      
      // Create a new queue
      LinkedList<Node> queue = new LinkedList<Node>();
      
      // Check if already unlocked
      if(!lock.isUnlocked()){
         // If not already unlocked, attempt to unlock
         
         // Enqueue root
         queue.add(leaf);
         

            // Do operation
            while(!queue.isEmpty()){
                  // Dequeue from the queue
                  leaf = queue.poll();
                  
                  // Traverse the nodes back up to see if unlocks the lock
                  if(traverse(leaf, lock)){
                     printSolution(leaf);
                     break;
                  }
                  
                  // if it doesn't, continue
                  lock.resetLock();
                  count++;
                  queue.add(new Node(leaf, count, SHAKE));
                  queue.add(new Node(leaf, count, PULL));
                  queue.add(new Node(leaf, count, POKE));
                  queue.add(new Node(leaf, count, TWIST));
            }
         }
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - BFS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         System.out.println("Number of Nodes Visited: " + nodesVisited);
         System.out.println("Length of the Queue: " + queue.size());
         // Return Path
         return leaf;
   }
   
   public Node DLDFS(TheLock lock, int depthLimit){
      // Start Timer
      long start = System.nanoTime();
      
      // Create the root node
      Node leaf = new Node(null, 0, UNLOCK);
      
      // Reset nodesVisited to 0 and store IDS values
      nodesVisited = 0;
      
      // Create a stack for DFS
      Stack<Node> stack = new Stack<Node>();
      stackIDS = stack;
      stack.push(leaf);
      
      if(!lock.isUnlocked()){
         // If not already unlocked, try to unlock
         // Do operation
         while(!stack.isEmpty()){
            leaf = stack.pop();
            
            // Check if we have reached an unlocked state
            if(traverse(leaf, lock)){
               printSolution(leaf);
               break;
            }
            
            // If not, reset the lock   
            lock.resetLock();
            
            // Check if within range
            if(leaf.depth < depthLimit){
               stack.push(new Node(leaf, leaf.depth + 1, SHAKE));
               stack.push(new Node(leaf, leaf.depth + 1, PULL));
               stack.push(new Node(leaf, leaf.depth + 1, POKE));
               stack.push(new Node(leaf, leaf.depth + 1, TWIST));
            }
         }
      }
      
      // Set the nodesIDS to nodesVisited
      nodesIDS = nodesIDS + nodesVisited;
      
      // End Timer
      long end = System.nanoTime();
      // Calculate Time
      long diff = end - start;
      System.out.println("Time to find solution - DLDFS (nanoseconds): ");
      System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
      System.out.println("Number of Nodes Visited: " + nodesVisited);
      System.out.println("Length of the Stack: " + stack.size());
      return leaf;
   }
   
   public Node IDS(TheLock lock){
      // Start Timer
      long start = System.nanoTime();
      int count = 0;
      
      // Reset nodesVisited to 0
      nodesVisited = 0;
      
      // Check if already unlocked
      if(lock.isUnlocked()){
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         System.out.println("Time to find solution - IDS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         return new Node(null, 0, UNLOCK);
      }
      else{
         // If not, try to find unlock state
         
         // Create a loop variable to count the depth
         int loop = -1;
         
         // Node variable, leaf
         Node leaf;
         
         // Create an infinite loop until finding a correct answer
         while(true){
            loop++;
            leaf = DLDFS(lock, loop);
            if(lock.isUnlocked()){
               break;
            }
            lock.resetLock();
         }
         // End Timer
         long end = System.nanoTime();
         // Calculate Time
         long diff = end - start;
         printSolution(leaf);
         System.out.println("Time to find solution - IDS (nanoseconds): ");
         System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
         System.out.println("Number of Nodes Visited: " + nodesIDS);
         System.out.println("Length of Stack: " + stackIDS.size());
         return leaf;
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