public class Engine 
{
	private String Description;
	private int MilesPerGallon;
	private int MaxSpeedValue;
	
	public Engine(String Describe, int MPG, int MaxSpeed)
	{
		if(Describe.length() == 0)
			Description = "Generic engine";
		else
			Description = Describe;
		
		if(MPG < 0)
			MilesPerGallon = 0;
		else
			MilesPerGallon = MPG;
		
		if(MaxSpeed < 0)
			MaxSpeedValue = 0;
		else
			MaxSpeedValue = MaxSpeed;
	}
	
	public String getDescription()
	{
		return Description + " (MPG: " + MilesPerGallon + ", Max speed: " + MaxSpeedValue + ")";
	}
	
	public int getMilesPerGallon()
	{
		return MilesPerGallon;
	}
	
	public int getMaxSpeedValue()
	{
		return MaxSpeedValue;
	}
}