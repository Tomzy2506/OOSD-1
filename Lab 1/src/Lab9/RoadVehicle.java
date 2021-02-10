package Lab9;

public class RoadVehicle extends Object implements ImportDuty
{
	private int wheels;	    //How many wheels it has
	private int passengers; //How many passengers it can carry
 
	public RoadVehicle() 
	{
 		this(0,0);	
	}
 
	public RoadVehicle(int w, int p) 
	{
		setWheels(w);
		setPass(p);
	}
 
	public void setWheels(int num) 
	{
		wheels = num;
	}
 
	public int getWheels() 
	{
		return wheels;
	}
 
	public void setPass(int num) 
	{
	passengers = num;
	}
 
	public int getPass()
	{
		return passengers;
	}

	@Override
	public double calculateDuty() {
		// TODO Auto-generated method stub
		return 0;
	}
}