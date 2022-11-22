import java.util.LinkedList;
import java.util.Queue;

public class Unlock{
   // Variables to store operations
   public static final int UNLOCK = 0;
   public static final int SHAKE = 1;
   public static final int PULL = 2;
   public static final int POKE = 3;
   public static final int TWIST = 4;
   // Variable to store the lock
   TheLock lock;
   
   public Node BFS(Node curr){
      Node temp;
      Queue<Node> q = new LinkedList<Node>();
      q.add(curr);
      
      // Check if queue is empty
      while(!q.empty){
         temp = q.peek();
         q.remove();
         // Go up the tree to check if unlock
         while(temp.parent != null){
            temp = temp.next
            // Apply action to the lock here
            
         }
         
         // Check if unlocked
         
         // if not, generate children
         
      }
   }
   
   public Node DLDFS(Node curr, int depthLimit){
   
   }
   
   public Node IDS(Node curr){
   
   }
   
   public void main(){
   
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