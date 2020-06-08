import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

class Model
{
    private CopCar newCop; 
    private RobberCar newRobber; 
    private ArrayList<Sprite> spriteList;
 
    
    
    private Bank newBank;    
    
    static int carCount = 0;

    Model() throws IOException
    {
        newBank = new Bank();
        newBank.setX(300);
        newBank.setY(300);
        
        spriteList = new ArrayList<>();   
        spriteList.add(newBank);
    }

    public void update(Graphics g)
    {
        for(int i=0; i<spriteList.size(); i++)
            spriteList.get(i).updateImage(g); // changed from spriteList.get(i).update(g);
    }

    public void newSprite(int newX, int newY)
    {
        carCount++;
        if(carCount % 2 == 1) // EVEN
        {
            newRobber = new RobberCar();
            newRobber.setX(300); // changed from newX
            newRobber.setY(300); // change from newY
            spriteList.add(newRobber);
        }
        else if (carCount % 2 == 0)
        {
            newCop = new CopCar();
            newCop.setX(newX);
            newCop.setY(newY);
            spriteList.add(newCop);
        }
    }
    
    public void updateScene(int Width, int Height)
    {
        
        for(int i=0; i<spriteList.size(); i++)
        {
            spriteList.get(i).updateState(Width, Height);
            
            if(spriteList.get(i) instanceof CopCar) // if CopCar
            {
                if(spriteList.get(i).overlaps(newRobber))
                    newRobber.captured(); // changed from newRobber.captured();
            }
            
            if(spriteList.get(i) instanceof RobberCar)
            {
                if( ((RobberCar)spriteList.get(i)).hasEscaped())
                {
                    //removes that RobberCar Sprite from the list of spriteList.
                    spriteList.remove(i);
                    System.out.println("I'm free!");

                }
            }
        }
    }
    
    public int getEscapedNum()
    {
        return newRobber.escapedRobbers;
    }
    
    public int getCapturedNum()
    {
        return newRobber.capturedRobbers;
    }
    
    public void initialize()
    {
        //sets the arraylist of Sprites to a brand new, empty list,
        //adds the Bank again, and resets the number of RobberCars escaped/captured = 0
        spriteList.clear();
        newBank = new Bank();
        newBank.setX(300);
        newBank.setY(300);
        spriteList.add(newBank);
        
        newRobber.escapedRobbers = 0;
        newRobber.capturedRobbers = 0;
    }
    

}
