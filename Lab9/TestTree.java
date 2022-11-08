import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class TestTree 
{
	
	Scanner comp;
	PrintStream me;
	boolean show = true; //if set to true, will print out respones to and from the game.  Set to false to make it faster.
	
    
    //initializes the Testing environment with piped streams (Queues)
	public TestTree() throws IOException
	{
		PipedOutputStream inputHandle = new PipedOutputStream();
		PipedInputStream input= new PipedInputStream(inputHandle);
		
		PipedOutputStream output = new PipedOutputStream();
		PipedInputStream outputHandle= new PipedInputStream(output);
		
		QTree game = new QTree(input,new PrintStream(output));

		Thread t = new Thread(()->{game.playGame();});
		t.start();

        comp = new Scanner(outputHandle);
		me = new PrintStream(inputHandle);

	
	}

    /*
        Helper methods for IO and testing
    
        These methods are beefed up versions of assert.  
    
    */
    
    //Use this to "check" if the string from the program is correct.
	public void check(String s)
	{
		String observed = comp.nextLine();
		if(show) {System.out.println("observed:"+observed);}
		//will not work with simple assert statements due to multithreading	
		if( ! observed.equals(s))
		{
			System.out.println("expected "+s+" but got "+observed);
			System.exit(1);
		}
	}
	
	public void say(String s)
	{
		me.println(s);
		me.flush(); //greatly increases speed of program, lets other side know there is new data.
		if(show) {System.out.println("said:"+s);}
	}
	
	
	public void run()
	{
		
      // Check if it is a Duck
		check(Strings.IS_IT_ALIVE);
        say("Y");
		
      check(Strings.IS_IT_A + Strings.DUCK + "?");
        say("Y");
       
      check(Strings.I_WIN);
      
      check(Strings.PLAY_AGAIN);
         say("Y");
      
      // Check if it is a Rock
      check(Strings.IS_IT_ALIVE);
        say("N");
		
      check(Strings.IS_IT_A + Strings.ROCK + "?");
        say("Y");
       
      check(Strings.I_WIN);
      check(Strings.PLAY_AGAIN);
         say("Y");
      
      // Check Alive (That is Not Duck), Positive
      check(Strings.IS_IT_ALIVE);
        say("Y");
		
      check(Strings.IS_IT_A + Strings.DUCK + "?");
        say("N");
       
      check(Strings.WHAT_IS_THE_ANSWER);
         say("Tree");
       
      check(Strings.NEW_QUESTION + Strings.DUCK + " and a Tree");
         say("Does it have green leaves?");
        
      check("Answering yes to Does it have green leaves? means Tree?");
         say("Y");
         
      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
         say("Y");
      
      // Check Alive (That is Not Duck), Negative
      check(Strings.IS_IT_ALIVE);
        say("Y");
        
      check("Does it have green leaves?");
        say("N");
		
      check(Strings.IS_IT_A + Strings.DUCK + "?");
        say("N");
       
      check(Strings.WHAT_IS_THE_ANSWER);
         say("Dog");
       
      check(Strings.NEW_QUESTION + Strings.DUCK + " and a Dog");
         say("Does it have flippers?");
        
      check("Answering yes to Does it have flippers? means Dog?");
         say("N");
         
      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
      say("Y");
      
      // Check Not Alive (That is not Rock), Positive
      check(Strings.IS_IT_ALIVE);
        say("N");
		
      check(Strings.IS_IT_A + Strings.ROCK + "?");
        say("N");
       
      check(Strings.WHAT_IS_THE_ANSWER);
         say("Toy");
       
      check(Strings.NEW_QUESTION + Strings.ROCK + " and a Toy");
         say("Can you buy this at a toy store?");
        
      check("Answering yes to Can you buy this at a toy store? means Toy?");
         say("Y");
         
      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
      say("Y");
      
      // Check Not Alive (That is not Rock), Negative
      check(Strings.IS_IT_ALIVE);
        say("N");
		
      check("Can you buy this at a toy store?");
        say("N");
      
      check(Strings.IS_IT_A + Strings.ROCK + "?");
        say("N");
       
      check(Strings.WHAT_IS_THE_ANSWER);
         say("Shoes");
       
      check(Strings.NEW_QUESTION + Strings.ROCK + " and a Shoes");
         say("Can you skip them on water?");
        
      check("Answering yes to Can you skip them on water? means Shoes?");
         say("N");
         
      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
         say("Y");
         
      // Check Shoes
      check(Strings.IS_IT_ALIVE);
        say("N");
		
      check("Can you buy this at a toy store?");
        say("N");
      
      check("Can you skip them on water?");
        say("N");
       
      check(Strings.IS_IT_A + "Shoes?");
         say("Y");
         
      check(Strings.I_WIN);
      check(Strings.PLAY_AGAIN);
         say("N");

      
      
           
      
       
        
        //close the streams at the end to enrue good behavior.
		comp.close();
		me.close();
	}





	public static void main(String[] args) 
	{
		try
		{
			TestTree test = new TestTree();
			test.run();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	
		
	}
	
	
}
