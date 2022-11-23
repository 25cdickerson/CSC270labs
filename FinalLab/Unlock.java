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
      long start = System.nanoTime();
      Node root = new Node(null, 0, UNLOCK);
      Node temp = root;
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);
      int cDepth = 0;
      
      // Check if queue is empty
      while(!q.isEmpty()){
         temp = q.peek();
         q.remove();
         // Go up the tree to check if unlock
         while(temp.operation != UNLOCK){
            temp = temp.parent;
            // Apply action to the lock here
            if(temp.operation == SHAKE){
               lock.shakeIt();
            }
            else if(temp.operation == PULL){
               lock.pullIt();
            }
            else if(temp.operation == POKE){
               lock.pokeIt();
            }
            else if(temp.operation == TWIST){
               lock.twistIt();
            }
            
            // Check if not unlocked
            if(!lock.isUnlocked()){
               // reset the lock
               lock.resetLock();
               
               // Generate children
               q.add(new Node(temp, cDepth+1, 1));
               q.add(new Node(temp, cDepth+1, 2));
               q.add(new Node(temp, cDepth+1, 3));
               q.add(new Node(temp, cDepth+1, 4));
            }
         }
      }
      long end = System.nanoTime();
      long diff = end - start;
      System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
      return temp;
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