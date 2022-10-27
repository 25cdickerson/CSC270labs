import java.util.List;
import java.util.ArrayList;

public class BSTest{
  public static void main(String[] args){
    // Create a new tree
    BSTree tree = new BSTree();
    
    // Check Largest
    assert tree.largest() == null;
    
    // Check if the tree is empty
    assert tree.isEmpty();
    
    // Check the count using consumer
    assert tree.getSize() == 0;
    
    // Check the toList
    List<Integer> empty = new ArrayList<Integer>();
    
    assert empty.equals(tree.toList());
    
    // Check sum
    assert tree.sum() == 0;
    
    // Insert into the tree
    tree.insert(5);
    
    // Check that the tree is not empty
    assert !tree.isEmpty();
    
    // Check the retrieve is working correctly
    assert tree.retrieve(6) == null;
    assert tree.retrieve(5) == 5;
    
    // Check retrieve height for 5
    assert tree.retrieveDepth(5) == 0;
    
    // Insert more into tree
    tree.insert(6);
    tree.insert(4);
    
    // Check depth of previously inserted
    assert tree.retrieveDepth(6) == 1;
    assert tree.retrieveDepth(4) == 1;
    
    // Check depth for not inserted
    assert tree.retrieveDepth(3) == 2;
    
    // Check count using consumer
    assert tree.getSize() == 3;
    
    // Check Largest
    assert tree.largest() == 6;
    
    // Create arraylist
    List<Integer> checkList = new ArrayList<Integer>();
    
    checkList.add(5);
    checkList.add(4);
    checkList.add(6);
    
    // Check if the lists are the same
    assert checkList.equals(tree.toList());
    
    // Check sum
    assert tree.sum() == 15;
    
    // create trees to compare and compare
    BSTree treeSame = new BSTree();
    BSTree treeDiff = new BSTree();
    
    treeSame.insert(5);
    treeSame.insert(4);
    treeSame.insert(6);
    
    assert treeSame.equals(tree);
    
    treeDiff.insert(1);
    treeDiff.insert(2);
    treeDiff.insert(3);
    
    assert !treeDiff.equals(tree);
    
    
  }
}