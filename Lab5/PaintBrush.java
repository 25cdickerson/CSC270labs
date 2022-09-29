import java.util.Stack;
import javafx.scene.paint.Color;


public class PaintBrush
{

	
	Paint paint;
	int mode;

	public final static int paintMode =1;
	public final static int fillMode = 2;
	public final static int pattern1Mode=3;
	public final static int pattern2Mode=4;
	
	Paint Gold = new PaintColor(Color.GOLD);
	Paint White = new PaintColor(Color.WHITE);
	
	
/**
set the "paint" for the paintbrush
*/	
	public void setPaint(Paint paint)
	{
     this.paint = paint;
	}


/*
   gets the present paint on the paint brush
*/
	public Paint getPaint()
	{
		return paint;
	}
	
   
   /*
   makes the paint on the paint brush a brigter shade.
   */
	public void setBrighter()
	{		
      paint = new PaintBrighter(paint);
	}


   /*
      makes the paint on the paintbrush a darker shade
   */
	public void setDarker()
	{
		paint = new PaintDarker(paint);
	}


   /*
      paints the mesh, usign the current paint and mode at point x,y
   */
	public void paint(int x, int y, Paint[][] mesh)
	{
		// Check for Point Mode
      if(mode == 1){
         mesh[x][y] = paint;
      }
      // Check for Fill Mode
      else if(mode == 2){
         // Get the previous color for base cases
         Paint prevColor = mesh[x][y];
         
         if(!prevColor.equals(paint)){
            fill(x, y, mesh, prevColor);
         }
      }
      // Check for Pattern1
      else if(mode == 3){
         Paint prevColor = mesh[x][y];
         
         fill2(x, y, mesh, prevColor);
      }
	}
	
   private void fill(int x, int y, Paint[][] mesh, Paint prevColor){
         // Base cases
         // Check bounds of x and y
         if(x < 0 || x >= mesh.length || y < 0 || y >= mesh[x].length){
            return;
         }
         
         // Check if the not the prevColor
         if(!mesh[x][y].equals(prevColor)){
            return;
         }
         
         mesh[x][y] = paint;
         fill(x+1, y, mesh, prevColor);
         fill(x-1, y, mesh, prevColor);
         fill(x, y+1, mesh, prevColor);
         fill(x, y-1, mesh, prevColor);
   }
   
   private void fill2(int x, int y, Paint[][] mesh, Paint prevColor){
         // Base cases
         // Check bounds of x and y
         if(x < 0 || x >= mesh.length || y < 0 || y >= mesh[x].length){
            return;
         }
         
         // Check if the not the prevColor
         if(!mesh[x][y].equals(prevColor)){
            return;
         }
         
         if(paint.equals(prevColor)){
            return;
         }
         
         
         // Making sure there is no endless loop by checking if
         // Area is white
         if(prevColor.equals(new PaintColor(Color.WHITE))){
            // Check if mod 2 = 0, if so set to gold, if not set to white
            if(x % 2 == 0){
               mesh[x][y] = Gold;
               fill2(x+1, y, mesh, prevColor);
               fill2(x-1, y, mesh, prevColor);
               fill2(x, y+1, mesh, prevColor);
               fill2(x, y-1, mesh, prevColor);
            }
            else{
               fill2(x+1, y, mesh, prevColor);
               fill2(x-1, y, mesh, prevColor);
            }
        }
        else{
            if(x % 2 == 0){
               mesh[x][y] = Gold;
            }
            else{
               mesh[x][y] = White;
            }
            fill2(x+1, y, mesh, prevColor);
            fill2(x-1, y, mesh, prevColor);
            fill2(x, y+1, mesh, prevColor);
            fill2(x, y-1, mesh, prevColor);
        }
   }
	
/*
   set the drawing mode of the paint brush.
*/
	public void pointMode()
	{
		mode= paintMode;
	}

	public void fillMode()
	{
		mode = fillMode;
	}

	public void pattern1Mode()
	{
		mode = pattern1Mode;
	}

	public void pattern2Mode()
	{
		mode = pattern2Mode;
	}

}
