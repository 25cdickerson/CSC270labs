import java.util.Stack;

public class History
{

   
   // Create Undo and Redo Stacks
   private Stack<Event> undo = new Stack<>();
   private Stack<Event> redo = new Stack<>();

    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {  
      
      // Push to undo stack
      undo.push(new Event(deletion, position, Change));
      
      while(!redo.empty()){
         redo.pop();
      }
   
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
      // Get the last string in the stack of undo
      // Store it in a variable
      Event temp = undo.peek();
      
      // Store that variable in the redo, so it can be redone later
      redo.push(temp);
            
      // Update undo stack
      undo.pop();
      
      if (temp.getDeletion()){
         note.insert(temp.getPos(), temp.getPrevious());
      } else {
         note.remove(temp.getPos(), temp.getPrevious().length());
      } 
      
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
   	// Get the last string in the stack of undo
      // Store it in a variable
      Event temp = redo.peek();
      
      // Store that variable in the undo, so it can be undone later
      undo.push(temp);
      
      // Update undo stack
      redo.pop();
      
      if (!temp.getDeletion()){
         note.insert(temp.getPos(), temp.getPrevious());
      } else {
         note.remove(temp.getPos(), temp.getPrevious().length());
      }
       
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       if (!undo.empty()){
         return true;
       }
       
       return false;
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
       if (!redo.empty()){
         return true;
       }
       
       return false;
   }
	

}
