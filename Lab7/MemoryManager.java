public class MemoryManager
{
   protected MemoryAllocation head;
    
   protected final String Free = "Free";
   
   long size;


    /* size- how big is the memory space.  
     *  Allways assume the position starts at 0
     *
     */
   public MemoryManager(long size)
   {
     // Store the size
     this.size = size;
     
     // Create the header node that holds no info
     head = new MemoryAllocation("header", 0, 0, head, head);
   }



    /**
       takes the size of therequested memory and a string of the process requesting the memory
       returns a memory allocation that satisfies that request, or
       returns null if the request cannot be satisfied.
     */
    
   public MemoryAllocation requestMemory(long size,String requester)
   {
      // Check if the allocation is greater than the memMan
     if(size > this.size || requester.equals("header") || requester.equals("free")){
       return null;
     }
     
     // Add to the linked list here
     
     // Updated size
     this.size = this.size - size;
     
   }


    
    /**
       takes a memoryAllcoation and "returns" it to the system for future allocations.
       Assumes that memory allocations are only returned once.       

     */
   public void returnMemory(MemoryAllocation mem)
   {
     // Update size
     size = size + mem.getLength();
     
     // Check previous
     long count = 0;
     boolean isMerged = false;
     long pos = mem.getPosition();
     while(mem.prev.getOwner().equals("free")){
       if(mem.getPosition() < pos){
         pos =  mem.getPosition();
       }
       count = count + mem.getLength();
       mem = mem.prev;
       isMerged = true;
     }
     
     // Check next
     while(mem.next.getOwner().equals("free")){
       count = count + mem.getLength();
       mem = mem.next;
       isMerged = true;
     }
      
     // Create new mem
     if(isMerged == true){
       mem = new MemoryAllocation("free", pos, count, mem.prev, mem.next);
     }
   }
    



}
