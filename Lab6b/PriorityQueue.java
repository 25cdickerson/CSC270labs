import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
       Node temp = head;
       //super.push(val); //right now this is just a normal Queue as it will do what its parent did.
       if(isEmpty()){
         super.push(val);
         return;
       }
       
       while(temp.next != null && compare.compare(val, temp.next.val) == -1){
         temp = temp.next;
       }
       
       if (head == temp) { // if queue size is 1
        
         if (compare.compare(val, head.val) == 1) {
            head = new Node(val, head);
         } else {
            head.next = new Node(val, null);
            tail = head.next;
         }
         return;
       }
       
       Node newNode = new Node(val, temp.next);
       if (temp.next == null) {
         tail = newNode;
       }
       temp.next = newNode;
       
   }


}
