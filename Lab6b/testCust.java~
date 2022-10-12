public class testCust{
   public static void main(String[] args){
   
      // Testing Comparators
      Customer c1 = new Customer(5, 5, 5);
      Customer c2 = new Customer(3, 7, 2);
      Customer c3 = new Customer(5, 5, 5);
      Customer c4 = new Customer(5, 1, 3);
      
      assert c1 != null;
      assert c2 != null;
      
      Customer.WorthComparator wc = new Customer.WorthComparator();
      assert wc.compare(c1, c2) == 1;
      assert wc.compare(c2, c1) == -1;
      assert wc.compare(c1, c3) == 0;
      assert wc.compare(c3, c1) == 0;
      
      Customer.LoyaltyComparator lc = new Customer.LoyaltyComparator();
      assert lc.compare(c1, c2) == -1;
      assert lc.compare(c2, c1) == 1;
      assert lc.compare(c1, c3) == 0;
      assert lc.compare(c3, c1) == 0;
      
      Customer.WorthPoliteComparator pc = new Customer.WorthPoliteComparator();
      assert pc.compare(c1, c2) == 1;
      assert pc.compare(c2, c1) == -1;
      assert pc.compare(c1, c4) == 1;
      assert pc.compare(c4, c1) == -1;
      assert pc.compare(c1, c3) == 0;
      assert pc.compare(c3, c1) == 0;
      
      // Testing Queue
      PriorityQueue<Customer> pq1 = new PriorityQueue<Customer>(new Customer.WorthComparator());
      PriorityQueue<Customer> pq2 = new PriorityQueue<Customer>(new Customer.LoyaltyComparator());
      PriorityQueue<Customer> pq3 = new PriorityQueue<Customer>(new Customer.WorthPoliteComparator());
      
      assert pq1 != null;
      assert pq2 != null;
      assert pq3 != null;
      
      assert pq1.isEmpty();
      assert pq2.isEmpty();
      assert pq3.isEmpty();
      
      // Check push is working correctly with one push
      pq1.push(c1);
      assert !pq1.isEmpty();
      assert pq1.pop().equals(c1);
      assert pq1.isEmpty();
      
      // Push things to compare
      //pq1
      
      pq1.push(c1);
      pq1.push(c2);
      
      assert !pq1.isEmpty();
      
      assert pq1.pop().equals(c1);
      assert pq1.pop().equals(c2);
      
      assert pq1.isEmpty();
      
      pq1.push(c1);
      pq1.push(c3);
      
      assert !pq1.isEmpty();
      
      assert pq1.pop().equals(c1);
      assert pq1.pop().equals(c3);
      
      assert pq1.isEmpty();
      
      // pq2
      pq2.push(c1);
      pq2.push(c2);
      
      assert !pq2.isEmpty();
      
      assert pq2.pop().equals(c2);
      assert pq2.pop().equals(c1);
      
      assert pq2.isEmpty();
      
      pq2.push(c1);
      pq2.push(c3);
      
      assert !pq2.isEmpty();
      
      assert pq2.pop().equals(c1);
      assert pq2.pop().equals(c3);
      
      assert pq2.isEmpty();
      
      // pq3
      pq3.push(c1);
      pq3.push(c2);
      
      assert !pq3.isEmpty();
      
      assert pq3.pop().equals(c1);
      assert pq3.pop().equals(c2);
      
      assert pq3.isEmpty();
      
      pq3.push(c1);
      pq3.push(c4);
      
      assert !pq3.isEmpty();
      
      assert pq3.pop().equals(c1);
      assert pq3.pop().equals(c4);
      
      assert pq3.isEmpty();
      
      pq3.push(c1);
      pq3.push(c3);
      
      assert !pq3.isEmpty();
      
      assert pq3.pop().equals(c1);
      assert pq3.pop().equals(c3);
      
      assert pq3.isEmpty();
   }
}