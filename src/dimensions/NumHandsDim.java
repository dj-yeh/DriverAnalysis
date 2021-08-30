package dimensions;

public class NumHandsDim extends Dimension
{
	//-------------------------------------------------------------------------------------------------------------------
	//INHERITED INSTANCE VARIABLES
	//Dictionary:
	//1.) 0 hands
	//2.) 1 hands
	//3.) 2 hands
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	public NumHandsDim()
	{
		super(3, "NumHandsDim", "0 hands", "1 hand", "2 hands");
	}
	
	@Override
	public String toString()
	{
		return "NumHandsDim";
	}
}
