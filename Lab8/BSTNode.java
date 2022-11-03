import java.lang.Comparable;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;
   
   public BSTNode(){}

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
   public void insert(T target){
      // Check if target is greater than val
      if(target.compareTo(val) > 0){
         // Insert if right is null
         if(right == null){
            right = new BSTNode<T>(target);
            return;
         }
         // If not move to the next
         right.insert(target);
      }
      else{
         // Insert if left is null
         if(left == null){
            left = new BSTNode<T>(target);
            return;
         }
         // If not move to the next
         left.insert(target);
      }
   }



   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   // Helper Function for retrieve
   public T retrieve(T target){
      // Check if target is greater than val
      if(target.compareTo(val) > 0){
         // Check for leaf
         if(right == null){
            return null;
         }
         
         // If not move to the next
         return right.retrieve(target);
      }
      // If target is less than val
      else if(target.compareTo(val) < 0){
         // Check for Leaf
         if(left == null){
            return null;
         }
         // If not move to the next
         return left.retrieve(target);
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
   public int retrieveDepth(T target, int count){
      // Check if target is less than val
      if(val.compareTo(target) < 0){
         // return the count if no more rights to look at
         if(right == null){
            return count+1;
         }
         // If not move to the next
         return right.retrieveDepth(target, count+1);
      }
      else if(val.compareTo(target) > 0){
         // return the count if no more lefts to look at
         if(left == null){
            return count+1;
         }
         // If not move to the next
         return left.retrieveDepth(target, count+1);
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
      return getLargest(node.right);  
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {  
        if(left != null){
         left.inOrderTraversal(consume);
        }
        
        if(this != null){
         consume.accept(this.val);
        }
        
        if(right != null){
         right.inOrderTraversal(consume);
        }
   }
   
   public void preOrderTraversal(Consumer<T> consume){
        if(this != null){
           consume.accept(this.val);
        }
        
        if(left != null){
           left.inOrderTraversal(consume);
        }
 
        if(right != null){
           right.inOrderTraversal(consume);
        }
   }
   
   public void postOrderTraversal(Consumer<T> consume){
        if(left != null){
           left.inOrderTraversal(consume);
        }
 
        if(right != null){
           right.inOrderTraversal(consume);
        }
        
        if(this != null){
           consume.accept(this.val);
        }
   }



   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
     
     This one is long!
    */   
   public boolean myEquals(BSTNode<T> that){
      // Check PreOrder, PostOrder, and InOrder
      ArrayList<T> preO = new ArrayList<>();
      ArrayList<T> preO1 = new ArrayList<>();
      ArrayList<T> postO = new ArrayList<>();
      ArrayList<T> postO1 = new ArrayList<>();
      ArrayList<T> inO = new ArrayList<>();
      ArrayList<T> inO1 = new ArrayList<>();
      
      this.preOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  preO.add(i);
               }
            });
      
      that.preOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  preO1.add(i);
               }
            });
            
      this.postOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  postO.add(i);
               }
            });
            
       that.postOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  postO1.add(i);
               }
            });
            
       this.inOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  inO.add(i);
               }
            });
            
        that.inOrderTraversal(
            new Consumer<T>() //here is the type 
            {
               public void accept(T i)
               {
                  inO1.add(i);
               }
            });
            
        if(preO.equals(preO1) && postO.equals(postO1) && inO.equals(inO1)){
            return true;
        }
        return false;
   }
   
   
   public T getVal(){
      return val;
   }

}
