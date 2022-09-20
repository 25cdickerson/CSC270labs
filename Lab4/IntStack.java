
public class IntStack
{
   private Node head;
   
   public IntStack()
   {
      head = null;
   }



   //pushes val onto the stack
   public void push(int val)
   {
      head = new Node(val, head);
   }

    //returns the top element from the stack
    //If the stack is empty, it will throw a StackUnderFlowException.
   public int top() throws StackUnderFlowException
   {
      if(head == null){
         StackUnderFlowException e = new StackUnderFlowException("Cannot top an empty stack");
         throw e;
      }
	   return head.val;
   }


    //returns the top element from the stack
    //removes the top element from the stack
    //If the stack is empty, it will throw a StackUnderFlowException.
   public int pop()
   {
      if(head == null){
         StackUnderFlowException e = new StackUnderFlowException("Cannot pop an empty stack");
         throw e;
      }
      int temp = head.val;
      head = head.next;
	   return temp;
   }
   
    //reports if the stack is empty
   public boolean isEmpty()
   {
       if(head == null){
         return true;
       }
       return false;
   }

   // Node Class
   private class Node{
      
      int val;
      Node next;
      
      Node(int val, Node next){
         this.val = val;
         this.next = next;
      }
      
   }

}
