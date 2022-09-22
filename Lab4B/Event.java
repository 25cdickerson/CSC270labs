public class Event {
   
   private boolean deletion;
   private int position; 
   private String previous;
   
   public Event(boolean deletion, int position, String previous){
      this.deletion = deletion;
      this.position = position;
      this.previous = previous;
   }
   
   public boolean getDeletion(){
      return deletion;
   }
   
   public int getPos(){
      return position;
   }
   
   public String getPrevious(){
      return previous;
   }
}