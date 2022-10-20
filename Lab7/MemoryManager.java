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
     head.next = head;
     head.prev = head;
   }



    /**
       takes the size of therequested memory and a string of the process requesting the memory
       returns a memory allocation that satisfies that request, or
       returns null if the request cannot be satisfied.
     */
    
   public MemoryAllocation requestMemory(long size,String requester)
   {
      long pos = 0;
      // Check if the allocation is greater than the memMan
     if(size > this.size || requester.equals("header") || requester.equals("free")){
       return null;
     }
     
     // Add to the linked list here
     // If the list has not been added to yet
     MemoryAllocation ret = null;
     if(head.next == head){
       ret = new MemoryAllocation(requester, 0, size, head, head);
       head.next = ret;
       head.prev = ret;
       pos = pos + size;
     }
     else{
       // Search for a place to put the memory
       // If there is a free space in the middle break and add there
       boolean isFreed = false;
       MemoryAllocation trav = head;
       long position = 0;
       while(!trav.next.getOwner().equals(head.getOwner())){
         if(trav.getOwner().equals("free") && trav.getLength() >= size){
            isFreed = true;
            break;
         }
         trav = trav.next;
       }
       
       if(trav.getOwner().equals("free")){
         isFreed = true;
       }
       
       if(isFreed == true){
         long nextPos = trav.next.getPosition();
         if(trav.getLength() == size){
            // if the allocation is the same as the freed
            trav.owner = requester;
         }
         else{
           // Change the original freed
           long s = trav.getLength() - size;
           trav.owner =  requester;
           trav.setLength(size);
           MemoryAllocation free = new MemoryAllocation("free", (trav.getPosition() + trav.getLength()), s, trav, trav.next);
           free.prev.next = free;
           free.next.prev = free;
           //ret.next = free;
           //ret.next.next.prev = free;
         }
         return trav;
       }
       else{
         pos = trav.getPosition() + trav.getLength();
         if(pos + size <= this.size){
           ret =  new MemoryAllocation(requester, pos, size, trav, head);
           trav.next = ret;
           head.prev = ret;
         }
       }
       

     }
     
     return ret;
   }


    
    /**
       takes a memoryAllcoation and "returns" it to the system for future allocations.
       Assumes that memory allocations are only returned once.       

     */
   public void returnMemory(MemoryAllocation mem)
   {
     mem.owner = "free";
     
     // Check previous
     long count = mem.getLength();
     boolean isMerged = false;
     while(mem.prev.getOwner().equals("free")){
       mem = mem.prev;
       count = count + mem.getLength();
       mem.next = mem.next.next;
       mem.next.prev = mem;
       isMerged = true;
     }
     
     // Check next
     while(mem.next.getOwner().equals("free")){
       mem = mem.next;
       count = count + mem.getLength();
       mem.prev.next = mem.next;
       mem.next.prev = mem;
       isMerged = true;
     }
      
     // Create new mem
     if(isMerged == true){
       mem.setLength(count);
     }
   }
    



}
