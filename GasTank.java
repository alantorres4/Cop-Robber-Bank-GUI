public class GasTank 
{
	private int maxCapacity;
	private double currentLevel;
	
	public GasTank(int capacity) 
	{
		if(capacity < 0)
			maxCapacity = 0;
		else
			maxCapacity = capacity;
		
		currentLevel = 0; 
	}
	
	public int getCapacity()
	{
		return maxCapacity;
	}
	
	public double getLevel()
	{
		return currentLevel;
	}

	public void setLevel(double levelIn)
	{
		if(levelIn < 0)
			currentLevel = 0;
		else if(levelIn > maxCapacity)
			currentLevel = maxCapacity;
		else
			currentLevel = levelIn;
	}
}