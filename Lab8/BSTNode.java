import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;

   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
      this.val = val;
      left = l;
      right = r;
   }



   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
      insert(target, this);
   }
   
   // Helper Function For Insert
   public void insert(T target, BSTNode<T> node){
   {
      // Check if target is greater than val
      if(target > val){
         // Insert if right is null
         if(right == null){
            right = new BSTNode(target);
            return;
         }
         // If not move to the next
         insert(target, node.right);
      }
      else{
         // Insert if left is null
         if(left == null){
            left = new BSTNode(target);
            return;
         }
         // If not move to the next
         insert(target, node.left);
      }
   }



   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
      return retrieve(target, this);
   }
   
   // Helper Function for retrieve
   public T retrieve(T target, BSTNode<T> node){
      // Check if at a leaf
      if(node.right == null && node.left == null){
         if(node.val == target){
            return target;
         }
         // If not on leaf, return null
         return null;
      }
      
      // Move right
      
      
      // Move left
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {

   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
   

   }

}
