
import java.awt.Graphics;
import java.util.Random;


public class CopCar extends Car
{   
    static private int xRatio;
    static private int yRatio;
    private int xDirection;
    private int yDirection;
 
    public CopCar()
    {
        super("Veloster", 5000, new Engine("V14", 30, 100), "cop-car.jpg");
        fillUp();
        Random num = new Random();
        xRatio = num.nextInt(11)-5; // random num between [-5, 5]
        yRatio = num.nextInt(11)-5;
                
        super.fillUp();
    }
    
    public void updateState(int Width, int Height)
    {   
        xDirection = xRatio;
        yDirection = yRatio;

        boolean comingFromBottom = false;
        if(getY() >= Height) // if past the Height value (i.e. past bottom of screen
            comingFromBottom = true;
        
        boolean comingFromTop = false;
        if(getY() <= 0) // if past top of screen
            comingFromTop = true;
        
        boolean comingFromLeft = false;
        if(getX() <= 0)
            comingFromLeft = true;
        
        boolean comingFromRight = false;
        if(getX() >= Width)
            comingFromRight = true;
       
            
        if(yRatio > 0 && comingFromBottom) // changed > to < // changed Bottom to Top
            yDirection = yRatio * -1; // changed yRatio to yDirection                
        if(yRatio < 0 && comingFromTop) // changed > to < // changed Top to Bottom
            yDirection = yRatio * -1;        
        if(xRatio > 0 && comingFromLeft)
            xDirection = xRatio * -1;
        if(xRatio < 0 && comingFromRight)
            xDirection = xRatio* -1;
        
        
        super.drive(2, xDirection, yDirection); // changed from xDirection to xRatio and yDirection to yRatio
    }
    
    public void updateImage(Graphics g)
    {
        super.updateImage(g); // changed from super.update(g) to super.updateImage(g)
    }
}
