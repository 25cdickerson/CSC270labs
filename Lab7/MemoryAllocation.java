public class MemoryAllocation
{
    //package access-reachable by memory manager
    //but not those that would use this module
    String owner;  //which process owns this memory
    long pos;      //where does it start
    long len;      //how long is the memory
    MemoryAllocation prev; // Previous Allocation
    MemoryAllocation next; // Next Allocation


    // Constructs the Memory Allocation Object
    public MemoryAllocation(String owner, long pos, long len, MemoryAllocation prev, MemoryAllocation next)

    {
      this.owner = owner;
      this.pos = pos;
      this.len=len;
      this.prev = prev;
      this.next = next;
    }


    public String getOwner()
    {
      return owner;
    }

    public long getPosition()
    {
      return pos;
    }

    public long getLength()
    {
      return len;
    }
    


    public String toString()
    {
      return "Alloc "+owner+" at "+pos+" for "+len; 
    }

}
