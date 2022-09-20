public class TestStack 
{
   public static void main(String[] args)
   {
      IntStack test = new IntStack();
      
      assert test.isEmpty();
      try {
         test.pop();
         assert false: "Should have thrown an exception";
      } catch (StackUnderFlowException e) {}
      try {
         test.top();
         assert false: "Should have thrown an exception";
      } catch (StackUnderFlowException e) {}
      
      test.push(1);
      assert !test.isEmpty();
      assert test.top() == 1;
      
      test.push(2);
      assert !test.isEmpty();
      assert test.top() == 2;
      
      test.pop();
      assert !test.isEmpty();
      assert test.top() == 1;
      
      test.pop();
      assert test.isEmpty();
      try {
         test.pop();
         assert false: "Should have thrown an exception";
      } catch (StackUnderFlowException e) {}
      try {
         test.top();
         assert false: "Should have thrown an exception";
      } catch (StackUnderFlowException e) {}
      
   }
}