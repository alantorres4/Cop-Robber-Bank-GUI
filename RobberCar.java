
import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car
{
    private int xRatio;
    private int yRatio;
    
    static public int capturedRobbers = 0;
    private boolean capturedAlready = false;
    
    static public int escapedRobbers = 0;
    private boolean escapedAlready = false;
    private boolean hasEscaped = false;
        
    public RobberCar()
    { 
        super("Veloster", 5000, new Engine("V14", 20, 200), "red-car.jpg");
        fillUp();
        Random num = new Random();
        xRatio = num.nextInt(11)-5; // random num between [-5, 5]
        yRatio = num.nextInt(11)-5;
        
        super.fillUp();
    }
    
    public void updateState(int Width, int Height)
    {
        //check if image has moved completely out of window 
        boolean outOfX = false;
        boolean outOfY = false;
        int posX = getX();
        int posY = getY();
        
        if(posX > Width || posX < 0)
            outOfX = true;
        if(posY > Height || posY < 0)
            outOfY = true;
        
        
        if(outOfX | outOfY) // if either of these are true
        {
            hasEscaped = true;
            if(escapedAlready == false)
            {
                escapedRobbers++;
            }
            escapedAlready = true;
        }
        
        super.drive(4, xRatio, yRatio);
    }
    
   
    public void updateImage(Graphics g)
    {
        super.updateImage(g);
    }
    
    public void captured()
    {
        //causes RobberCar object to change image to jail.jpg and stops moving
        super.setImage("jail.jpg");
        
        super.stop();
        super.drive(0, 0, 0); // maybe ?
        if(capturedAlready == false)
            capturedRobbers++;
        
        capturedAlready = true;
//        isCaptured();
    }
    
    public boolean isCaptured()
    {
        boolean isCaptured = false;
        if(super.jpg == "jail.jpg")
            isCaptured = true;
        
        return isCaptured;
    }
    
    public boolean hasEscaped()
    {
        boolean escaped;
        if(hasEscaped)
            escaped = true;
        else
            escaped = false;
        
        return escaped;
    }

    
}
