// Lab 2a -- Unit Testing a Broken Program
public class TestIntList{
   public static void main(String[] args){
      // Create IntList
      IntList list = new IntList(5);
      
      // Check boundaries on insertBefore
      assert !list.insertBefore(100, 100): "Cannot insert out of bounds";
      assert !list.insertBefore(-1, -1): "Cannot insert out of bounds";
      
      // Check out of bounds on remove
      assert !list.remove(0): "Remove does not work correctly";
      assert !list.remove(-1): "Remove is not working correctly";
      assert !list.remove(100): "Remove is not working correctly";
      
      // Check out of bounds on getPos
      assert list.getPos(0) == -1: "getPos is not working correctly when out of bounds";
      
      // Check if the length before adding is 0
      assert list.length() == 0:"List Length Before Adding is not Zero";
      
      // Check the max size of the IntList
      assert list.getMaxSize() == 5:"Max Size is Incorrect";
      
      // Insert into IntList
      for(int i = 0; i < 5; i++){
         // Check if inserting correctly each loop through
         assert list.insertBefore(i, i): "Inserting at position " + i + " is not working correctly";
         assert list.getPos(i) == i: "Insert at position " + i + " is not working correctly";
      }
      
      
      // Check for correct outputs from insertBefore
      assert list.getPos(0) == 0: "Inserting is not working correctly";
      
      // Check if length changes when inserting into IntList
      assert list.length() == 5: "List length after inserting is incorrect";
      
      // Check if getPos works correctly
      assert list.getPos(0) == 0: "Get Position is not working correctly";
      
      // Check if remove works correctly;
      assert list.remove(2): "Remove does not work correctly";
      
      // Check if the element was removed
      assert list.getPos(2) == 3: "Remove does not work correctly";
      
      // Check boundaries on getPos
      assert list.getPos(-1) == -1 : "getPos is not working correctly when out of bounds";
      assert list.getPos(10) == -1: "getPos is not working correctly when out of bounds";
      
      
      // Check Values on Insert Before
      int checkPos = list.getPos(3);
      assert list.insertBefore(3,3);
      assert list.getPos(3) == 3: "Insert Before is not working correctly";
      assert list.getPos(4) == checkPos: "Insert Before is not working correctly";
      
      /* Start New */
      // Init New intList
      /*IntList list2 = new IntList(5);
      
      // Insert at Start, Middle, and End
      assert list2.insertBefore(5, 0): "1";
      assert list2.insertBefore(10, 2): "2";
      assert list2.insertBefore(15, 4): "3";
      
      // Delete from end, start, middle
      assert list2.remove(4): "4";
      assert list2.remove(0): "5";
      assert list2.remove(2): "6";
      
      // Insert Until Full
      assert list2.insertBefore(5, 0): "7";
      assert list2.insertBefore(10, 2): "8";
      assert list2.insertBefore(15, 4): "9";
      assert list2.insertBefore(7, 1): "10";
      assert list2.insertBefore(12, 3): "11";
      
      // Delete and Check Size
      for(int i = 0; i < 5; i++){
         assert list2.remove(i): "12";
      }
      
      // Check size and index at 0
      assert list2.length() == 0: "13";
      assert list2.getPos(0) == -1: "14";*/
   }
}