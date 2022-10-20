public class TestMemory{
  public static void main(String[] args){
    // Set a new memory manager with the size of 10
    MemoryManager mem = new MemoryManager(10);
    
    // Allocate a new piece of memory
    MemoryAllocation allocate = mem.requestMemory(5, "Own1");
    
    // Check all of the stored data is correct
    assert allocate.getOwner().equals("Own1");
    assert allocate.getPosition() ==  0;
    assert allocate.getLength() == 5;
    
    // Make another allocation request
    MemoryAllocation allocate2 = mem.requestMemory(4, "Own2");
    
    // Check all of the stored data is correct
    assert allocate2.getOwner().equals("Own2");
    assert allocate2.getPosition() == 5;
    assert allocate2.getLength() == 4;
    
    // Return an allocation
    //mem.returnMemory(allocate);
    
    // Check if the memory allocation was returned
    //assert allocate2.getPosition() == 0;
    
    // Check if I can add more than the length
    assert mem.requestMemory(10, "Own3") == null;
    assert mem.requestMemory(11, "Own3") == null;
    
    // Create a new Memory Manager
    MemoryManager mem2 = new MemoryManager(5);
    
    // Check what happens when add the length of the memory manager
    MemoryAllocation allocate3 = mem2.requestMemory(5, "Own");
    
    assert allocate3.getOwner().equals("Own");
    assert allocate3.getPosition() == 0;
    assert allocate3.getLength() == 5;
    
    // Create a new memory manager to check returns
    MemoryManager mem3 = new MemoryManager(100);
    
    // Add to the memory manager
    MemoryAllocation a1 = mem3.requestMemory(10, "Own");
    assert a1.getPosition() == 0;
    assert a1.getLength() == 10;
    
    MemoryAllocation a2 = mem3.requestMemory(15, "Own");
    assert a2.getPosition() == 10;
    assert a2.getLength() == 15;
    
    MemoryAllocation a3 = mem3.requestMemory(5, "Own");
    assert a3.getPosition() == 25;
    assert a3.getLength() == 5;
    
    MemoryAllocation a4 = mem3.requestMemory(20, "Own");
    assert a4.getPosition() == 30;
    assert a4.getLength() == 20;
    
    MemoryAllocation a5 = mem3.requestMemory(25, "Own");
    assert a5.getPosition() ==  50;
    assert a5.getLength() == 25;
    
    MemoryAllocation a6 = mem3.requestMemory(10, "Own");
    assert a6.getPosition() ==  75;
    assert a6.getLength() == 10;
    
    MemoryAllocation a7 = mem3.requestMemory(15, "Own");
    assert a7.getPosition() ==  85;
    assert a7.getLength() == 15;
    
    // Return the memory to check the use
    mem3.returnMemory(a2);
    mem3.returnMemory(a4);
    
    System.out.println(a4.owner);
    // Add memory allocations to see if they add in the correct place
    MemoryAllocation a8 = mem3.requestMemory(5, "Own");
    
    assert a8.getOwner().equals("Own");
    assert a8.getPosition() == 10;
    assert a8.getLength() == 5;
    
    // Add another memory allocation
    MemoryAllocation a9 = mem3.requestMemory(20, "Own");
    
    assert a9.getOwner().equals("Own");
    System.out.println(a9.getPosition());
    assert a9.getPosition() == 30;
    assert a9.getLength() == 20;
    
    // Add one last memory allocation
    MemoryAllocation a10 = mem3.requestMemory(10, "Own");
        
    assert a10.getOwner().equals("Own");
    System.out.println(a10.getPosition());
    assert a10.getPosition() == 15;
    assert a10.getLength() == 10;
    
    // Create a new Memory Manager to create a contigous memory block
    MemoryManager mem4 = new MemoryManager(100);
    
    // Add to the memory manager
    MemoryAllocation alo1 = mem4.requestMemory(10, "Own");
    MemoryAllocation alo2 = mem4.requestMemory(15, "Own");
    MemoryAllocation alo3 = mem4.requestMemory(5, "Own");
    MemoryAllocation alo4 = mem4.requestMemory(20, "Own");
    MemoryAllocation alo5 = mem4.requestMemory(25, "Own");
    MemoryAllocation alo6 = mem4.requestMemory(10, "Own");
    MemoryAllocation alo7 = mem4.requestMemory(15, "Own");
    
    
    // Return contigous block
    mem4.returnMemory(alo2);
    mem4.returnMemory(alo3);
    
    // Check if I can add too much
    assert mem4.requestMemory(30, "Own") == null;
    
    // Check if you can add
    MemoryAllocation alo8 = mem4.requestMemory(20, "Own");
    
   
    assert alo8.getOwner().equals("Own");
    System.out.println(alo8.getPosition());
    assert alo8.getPosition() == 10;
    assert alo8.getLength() == 20;
    
    // Check if you can return everything
    mem4.returnMemory(alo1);
    mem4.returnMemory(alo8);
    mem4.returnMemory(alo4);
    mem4.returnMemory(alo5);
    mem4.returnMemory(alo6);
    mem4.returnMemory(alo7);
    
    MemoryAllocation alo9 = mem4.requestMemory(100, "Own");
    assert alo9.getPosition() == 0;
    assert alo9.getLength() == 100;
    
    // Create a new memory manager
    MemoryManager mem5 = new MemoryManager(60);
    
    MemoryAllocation newMem1 = mem5.requestMemory(20, "Own");
    MemoryAllocation newMem2 = mem5.requestMemory(20, "Own");
    MemoryAllocation newMem3 = mem5.requestMemory(20, "Own");
    
    // Check right
    mem5.returnMemory(newMem3);
    
    MemoryAllocation newMem5 = mem5.requestMemory(20, "Own");
    
    assert newMem5.getPosition() == 40;
    assert newMem5.getLength() ==20;
    
    // Check left
    mem5.returnMemory(newMem1);
    
    MemoryAllocation newMem6 = mem5.requestMemory(20, "Own");
    
    assert newMem6.getPosition() == 0;
    assert newMem6.getLength() == 20;
    
    // Check Center
    mem5.returnMemory(newMem2);
    
    MemoryAllocation newMem7 = mem5.requestMemory(20, "Own");
    
    assert newMem7.getPosition() == 20;
    assert newMem7.getLength() == 20;
    
    // Left Center
    mem5.returnMemory(newMem6);
    mem5.returnMemory(newMem7);
    
    MemoryAllocation newMem9  = mem5.requestMemory(40, "Own");
    
    assert newMem9.getPosition() == 0;
    assert newMem9.getLength() == 40;
    
    // Return to original state
    mem5.returnMemory(newMem9);
    
    mem5.requestMemory(20, "Own");
    MemoryAllocation center = mem5.requestMemory(20, "Own");
    
    // Right Center
    mem5.returnMemory(center);
    mem5.returnMemory(newMem5);
    
    MemoryAllocation newMem10 = mem5.requestMemory(40, "Own");
    assert newMem10.getPosition() == 20;
    assert newMem10.getLength() == 40;
    
    
    
    // Remove all and check
    mem5.returnMemory(newMem10);
    mem5.returnMemory(newMem6);
    
    MemoryAllocation newMem8 = mem5.requestMemory(60, "Own");
    
    assert newMem8.getPosition() == 0;
    assert newMem8.getLength() == 60;
    
    
    // Create a new memory manager to check deletion of all
    MemoryManager mem6 = new MemoryManager(60);
    
    MemoryAllocation A = mem6.requestMemory(20, "Own");
    MemoryAllocation B = mem6.requestMemory(20, "Own");
    MemoryAllocation C = mem6.requestMemory(20, "Own");
    
    mem6.returnMemory(C);
    mem6.returnMemory(A);
    mem6.returnMemory(B);
    
    MemoryAllocation D = mem6.requestMemory(60, "Own");
    
    assert D.getPosition() == 0;
    assert D.getLength() == 60;    
    
  }
}