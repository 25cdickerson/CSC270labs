import java.util.*;
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
   
    // Check toList
    List<Integer> checkList2 = tree.toList();
    assert checkList2.get(0) == 4;
    assert checkList2.get(1) == 5;
    assert checkList2.get(2) == 6;
    
    
    // Check sum
    assert tree.sum() == 15;
    
    // create trees to compare
    BSTree comp = new BSTree();
    
    comp.insert(50);
    comp.insert(72);
    comp.insert(96);
    comp.insert(94);
    comp.insert(107);
    comp.insert(26);
    comp.insert(12);
    comp.insert(11);
    comp.insert(9);
    comp.insert(10);
    comp.insert(25);
    comp.insert(51);
    comp.insert(16);
    comp.insert(17);
    comp.insert(95);
    
    assert comp.sum() == 691;
    assert comp.largest() == 107;
    
    BSTree diff1 = new BSTree();
    
    diff1.insert(50);
    diff1.insert(72);
    diff1.insert(96);
    diff1.insert(94);
    diff1.insert(107);
    diff1.insert(26);
    diff1.insert(12);
    diff1.insert(11);
    diff1.insert(9);
    diff1.insert(25);
    diff1.insert(51);
    diff1.insert(16);
    diff1.insert(17);
    diff1.insert(95);
    
    BSTree diff2 = new BSTree();
    
    diff2.insert(50);
    diff2.insert(72);
    diff2.insert(96);
    diff2.insert(94);
    diff2.insert(107);
    diff2.insert(26);
    diff2.insert(12);
    diff2.insert(11);
    diff2.insert(9);
    diff2.insert(10);
    diff2.insert(25);
    diff2.insert(51);
    diff2.insert(16);
    diff2.insert(17);
    diff2.insert(95);
    diff2.insert(18);
    
    
    BSTree diff3 = new BSTree();
    
    diff3.insert(50);
    diff3.insert(72);
    diff3.insert(96);
    diff3.insert(94);
    diff3.insert(107);
    diff3.insert(26);
    diff3.insert(12);
    diff3.insert(11);
    diff3.insert(9);
    diff3.insert(10);
    diff3.insert(25);
    diff3.insert(16);
    diff3.insert(17);
    diff3.insert(95);
    
    BSTree diff4 = new BSTree();
    
    
    diff4.insert(50);
    diff4.insert(72);
    diff4.insert(96);
    diff4.insert(94);
    diff4.insert(107);
    diff4.insert(26);
    diff4.insert(12);
    diff4.insert(11);
    diff4.insert(9);
    diff4.insert(10);
    diff4.insert(25);
    diff4.insert(51);
    diff4.insert(16);
    diff4.insert(17);
    diff4.insert(95);
    diff4.insert(51);
    
    BSTree same = new BSTree();
    
    same.insert(50);
    same.insert(72);
    same.insert(96);
    same.insert(94);
    same.insert(107);
    same.insert(26);
    same.insert(12);
    same.insert(11);
    same.insert(9);
    same.insert(10);
    same.insert(25);
    same.insert(51);
    same.insert(16);
    same.insert(17);
    same.insert(95);
    
    BSTree em = new BSTree();
    BSTree em2 = new BSTree();
    
    assert em.myEquals(em2);
    assert !em.myEquals(comp);
    assert !em2.myEquals(comp);
    assert comp.myEquals(same);
    assert !comp.myEquals(em);
    assert !comp.myEquals(diff1);
    assert !comp.myEquals(diff2);
    assert !comp.myEquals(diff3);
    assert !comp.myEquals(diff4);
    
  }
}