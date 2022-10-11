public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them

   private Node<T> head = null;
   private Node<T> tail = null;
   
   public Queue(){}


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
      if(tail == null){
         head = new Node<T>(val, head);
         tail = head;
         return;
      }
      
      tail.next = new Node<T>(val, null);
      tail = tail.next;
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
       if(head == null){
         throw new QueueUnderFlowException("Cannot dequeue empty queue");
       }
       
       T temp = head.val;
       head = head.next;
       
       if(head == null){
         tail = null;
       }
       
       return temp;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return head == null;
   }

   
   private class Node<T>{
      private Node next;
      private T val;
      
      public Node(T val, Node next){
         this.next = next;
         this.val = val;
      }
   }



}
