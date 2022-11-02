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
   
   // Helper Function For Insert
   public void insert(T target, BSTNode<T> node){
      // Check if target is greater than val
      if(target.compareTo(node.val) > 0){
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
   // Helper Function for retrieve
   public T retrieve(T target, BSTNode<T> node){
      // Check if target is greater than val
      if(target.compareTo(node.val) > 0){
         // Check for leaf
         if(right == null){
            return null;
         }
         
         // If not move to the next
         retrieve(target, node.right);
      }
      // If target is less than val
      else if(target.compareTo(node.val) < 0){
         // Check for Leaf
         if(left == null){
            return null;
         }
         // If not move to the next
         retrieve(target, node.left);
      }
      // If target is val
      else{
         // return val
         return val;
      }
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   // Helper Function For retrieveDepth
   public int retrieveDepth(T target, BSTNode<T> node, int count){
      // Check if target is greater than val
      if(target.compareTo(node.val) > 0){
         // return the count if no more rights to look at
         if(right == null){
            return count;
         }
         // If not move to the next
         retrieveDepth(target, node.right, count+1);
      }
      else if(target.compareTo(node.val) < 0){
         // return the count if no more lefts to look at
         if(left == null){
            return count;
         }
         // If not move to the next
         retrieveDepth(target, node.left, count+1);
      }
      // Target is equal to val
      else{
         // return the count
         return count;
      }
   }

   /**
      Uses recursion to return the largest value in the tree
    */   
   public T getLargest(BSTNode<T> node){
      // If the right node is null, it is the largest, so return
      if(node.right == null){
         return node.val;
      }
      
      // If not, continue recursing right
      getLargest(node.right);  
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume, BSTNode node)
   {  
     // Go as far left as possible
     if(node.left != null){
       inOrderTraversal(consume, node.left);
     }
     
     if(node.left == null){
       // Consume Here
       
       // Go right
       if(node.right != null){
         inOrderTraversal(consume, node.right);
       }
     }
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */   
   public boolean myEquals(BSTNode<T> that, BSTNode<T> thiss){
   
      // Check if the values are equal
      if(!that.val.equals(thiss.val)){
         return false;
      }
      
      // If make it to null, return true
      if(that.left == null && thiss.left == null && that.right == null && thiss.right == null){
         return true;
      }
      
      // Recurse left and right
      // if left and right are not null and they're next vals are equal, then recurse
      // else return false
      if((that.left != null && thiss.left != null) && (that.left.val.equals(thiss.left.val))){
         myEquals(that.left, thiss.left);
      }
      else{
         return false;
      }
      
      if((that.right != null && thiss.right != null) && (that.right.val.equals(thiss.right.val))){
         myEquals(that.right, thiss.right);
      }
      else{
         return false;
      }
      
   }

}
