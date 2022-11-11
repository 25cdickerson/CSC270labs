import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class QTree
{
	Node root;
   Node duck;
   Node rock;
	
	Scanner in;
	PrintStream out;
	
    //initializes the game
	public QTree(InputStream in,PrintStream out)
	{
		this.out=out;
		this.in=new Scanner(in);
		root = new Node(Strings.IS_IT_ALIVE);
      duck = new Node("Duck");
      rock = new Node("Rock");
      root.yes = duck;
      root.no = rock;
      duck.parent = root;
      rock.parent = root;
	}
	
    //plays the game, be sure to grab input from the Scanner "in", and send your output to "out".
	public void playGame()
	{
      // Start Questions
      root.playGame(in, out);
      out.println(Strings.PLAY_AGAIN);
      out.flush();
      String line = in.nextLine();
      
      do{
         root.playGame(in, out);
         out.println(Strings.PLAY_AGAIN);
         out.flush();
         line = in.nextLine();
      }while(line.equals("y") || line.equals("Y"));
	}
	
	
	public static void main(String[] args)
	{
		QTree t = new QTree(System.in, System.out);
		t.playGame();
	}
	
	
}
