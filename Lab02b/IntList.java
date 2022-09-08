
public class IntList
{



   protected int maxSize=0;
   protected int[] array = null;
   protected int size = 0;

   public IntList(int maxSize)
   {
      array = new int[maxSize];
      // Fixed Bug (2) maxSize passed into the constructor was not updating the protected maxSize
      this.maxSize = maxSize;
      size=0;
   }


/**
   returns the maximum number of integers that can be stored in the array
*/

   public int getMaxSize()
   {
      return maxSize;
   }



/**
returns the element at position, pos.
If the position pos does not exist simply return -1
*/
   public int getPos(int pos)
   {
      // Fixed Bug (1) of not returning -1 when pos does not exist
      if(size == 0){
         return -1;
      }
      // Fixed Bug (6) was out of bounds because I was checking if pos
      // was greater than size rather than greather than or equal to
      else if(pos >= size){
         return -1;
      }
      else if(pos < 0){
         return -1;
      }
      else{
         return array[pos];
      }
   }

   public int length()
   {
   
      return size;
   
   }


/**
removes the element at position, pos
returns true if the element was removed successfully, and false otherwise.
*/
   public boolean remove(int pos)
   {
      if(pos<0 || pos >=size)
      { 
         return false;
      }
                   
      if(size==1 && pos==0)
      {
   	  //no need to move things down.
        // Bug (7) the size was not being decremented
        size = 0;
   	  return true;
      }
      
      // Fixed Bug (3) Array was going out of bounds after fixing bug 2 with max size
      for(int i=pos;i<size-1;i++)
      {
         array[i] = array[i+1];
      } 
      // Fixed Bug (4) using test cases, I found that when removing, there was no resetting of the last variable
      array[size-1] = 0;
      size--;      
      return true;
   }


/**
adds the element right before the positions listed.  
(I.e) the new element will become the element at position pos.
All other elements will be shifted down to make room.
If the insert is successful, this will return true.
Otherwise, if there is no room in the list or if the insert position occured after empty spaces, return false
*/
   public boolean insertBefore(int element, int pos)
   {
      if(pos<0 || pos>=size +1 || size==maxSize)
      {
         return false;   
      }
      // Fixed Bug (5) using JGrasp Dbugger and assert statements.
      // The loop needed to be incremented down, which it was
      // But, the loop was not working because it was checking if i < pos rather than i > pos
      for(int i = size; i>pos;i--)
      {
         array[i] = array[i-1];
      }
      array[pos] = element;
      size++;
      return true;
   
   
   }

}
