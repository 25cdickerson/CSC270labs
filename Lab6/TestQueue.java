public class TestQueue{
  public static void main(String[] args){
    // Create a new test queue - Testing specifically Integers due to generic type
    Queue test = new Queue();
    
    // Check if the test queue is empty
    assert test.isEmpty();
    
    try{
         test.pop();
         assert false: "Should have thrown an exception";
    }
    catch(QueueUnderFlowException e){}
    
    // Push onto queue
    test.push(1);
    test.push(2);
    
    // Check if queue is empty
    assert !test.isEmpty();
    
    // pop the 1 and see if it is true
    assert test.pop().equals(1);
    assert !test.isEmpty();
    
    // pop the 2 and see if it is true and see if empty
    assert test.pop().equals(2);
    assert test.isEmpty();
    
    try{
         test.pop();
         assert false: "Should have thrown an exception";
    }
    catch(QueueUnderFlowException e){}
  }
}