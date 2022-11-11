import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// Node class for 20 Questions
public class Node{
   public Node yes;
   public Node no;
   public Node parent;
   public String str;
   
   public Node(String str){
      this.str = str;
      yes = null;
      no = null;
      parent = null;
   }
   
   public void playGame(Scanner in, PrintStream out){
      // Ask user if the thing is alive
      String line;
      Node root = this;
      
      // Loop through until hitting a null
      while(root != null){
         out.println(root.str);
         line = in.nextLine();
         if(line.equals("y") || line.equals("Y")){
            root = root.yes;
            if(root.yes == null){
               break;
            }
         }
         else{
            root = root.no;
            if(root.no == null){
               break;
            }
         }
      }
      
      // Ask if answer is correct
      out.println(Strings.IS_IT_A + root.str + "?");
      line = in.nextLine();
      
      // If answer is correct, I WIN!
      if(line.equals("y") || line.equals("Y")){
         out.println(Strings.I_WIN);
      }
      // If not, what is it?
      else{
         out.println(Strings.WHAT_IS_THE_ANSWER);
         String newAns = in.nextLine();
         out.println(Strings.NEW_QUESTION + root.str + " and a " + newAns);
         String question = in.nextLine();
         out.println("Answering yes to " + question + " means " + newAns + "?");
         String check = in.nextLine();
         
         if(check.equals("y") || check.equals("Y")){
            // check which way parent went
            Node nodeQues = new Node(question);
            Node nodeAns = new Node(newAns);
            // Having out of bounds issues here
            if(root.parent.yes.str.equals(root.str)){
               root.parent.yes = nodeQues;
            }
            else if(root.parent.no.str.equals(root.str)){
               root.parent.no = nodeQues;
            }
            nodeQues.parent = root.parent;
            root.parent = nodeQues;
            nodeQues.yes = nodeAns;
            nodeQues.no = root;
            nodeAns.parent = nodeQues;
         }
         else{
            // check which way parent went
            Node nodeQues = new Node(question);
            Node nodeAns = new Node(newAns);
            // Having out of bounds issues here
            if(root.parent.yes.str.equals(root.str)){
               root.parent.yes = nodeQues;
            }
            else if(root.parent.no.str.equals(root.str)){
               root.parent.no = nodeQues;
            }
            nodeQues.parent = root.parent;
            root.parent = nodeQues;
            nodeQues.no = nodeAns;
            nodeQues.yes = root;
         }
         
         out.println(Strings.THANKS);
      }
   }  
}