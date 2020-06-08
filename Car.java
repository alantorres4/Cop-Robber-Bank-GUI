
import java.awt.Graphics;

public class Car extends Sprite
{
        private String Description;
        private GasTank obj1;
        private Engine obj2; // I added the new Engine() part for now

        public Car(String Describe, int MaxFuelCapacity, Engine EngineObject, String jpgName)
        {
            super(jpgName);
                if(Describe.length() == 0)
                        Description = "Generic car";
                else
                        Description = Describe;

                if(EngineObject == null)
                {
                        obj2 = new Engine("", 0, 0); // FIX THIS PART OF THE CODE (I THINK THIS IS OKAY NOW)
                }
                else
                        obj2 = EngineObject;

                obj1 = new GasTank(MaxFuelCapacity);
        }

        public String getDescription()
        {
                String formattedFuelLevel = String.format("%.2f", getFuelLevel());
                return Description + " (engine: " + obj2.getDescription() + "), fuel: " + formattedFuelLevel + "/" + obj1.getCapacity() + ", location: (" + getX() + "," + getY() + ")";
        }

        public double getFuelLevel()
        {
                return obj1.getLevel();
        }


        public int getMPG()
        {
                return obj2.getMilesPerGallon();
        }


        public void fillUp()
        {
                obj1.setLevel(obj1.getCapacity());
        }


        public int getMaxSpeed()
        {
                return obj2.getMaxSpeedValue();
        }

        public double drive(int distance, double xRatio, double yRatio)
        {
                int yChange = (int) (distance * Math.sin(Math.atan(yRatio / xRatio)));
                int xChange = (int) (distance * Math.cos(Math.atan(yRatio / xRatio)));

                if(xRatio < 0)
                {
                        if(xChange > 0)
                                xChange = 0 - xChange;
                }

                if(yRatio < 0)
                {
                        if(yChange > 0)
                                yChange = 0 - yChange;
                }
         int Y = getY();
         int X = getX();
                Y = Y + yChange;
                X = X + xChange;
         setX(X);
         setY(Y);

                double reciprocal = 1.0 / (double) obj2.getMilesPerGallon();
                double usedGas = (double) distance * reciprocal;


                if(usedGas > obj1.getLevel())
                {
                        double actuallyTravelled = obj1.getLevel() * (double) obj2.getMilesPerGallon();
//                        System.out.println("Ran out of gas after driving " + actuallyTravelled + " miles");

                        int newyChange = (int) (actuallyTravelled * Math.sin(Math.atan(yRatio / xRatio)));
                        int newxChange = (int) Math.sqrt((actuallyTravelled * actuallyTravelled) - (newyChange * newyChange));

                        if(xRatio < 0) // if negative, make sure xChange is negative
                        {
                                if(newxChange > 0)
                                        newxChange = 0 - newxChange;

                        }

                        if(yRatio < 0) // if negative, make sure yChange is negative
                        {
                                if(newyChange > 0)
                                        newyChange = 0 - newyChange;
                        }

                        
             Y = getY();
             X = getX();
                        Y = Y + newyChange - yChange;
                        X = X + newxChange - xChange;
             setX(X);
             setY(Y);

                        obj1.setLevel(0);
                        return actuallyTravelled;
                }
                else
                {
                        obj1.setLevel(obj1.getLevel() - usedGas);
                }

                return distance;
        }
        
        public void updateImage(Graphics g) 
        {
            super.updateImage(g); // changed from super.update(g);
        }
        
        public void stop()
        {
            obj1.setLevel(0.0);
        }

}

