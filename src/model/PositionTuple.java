package model;

/**
 * 
 * @author dj_yeh
 *
 * This class represents the manually recorded driving position of a participant from the annotations.
 */

public class PositionTuple 
{
	//-------------------------------------------------------------------------------------------------------------------
	//INSTANCE VARIABLES
	/**
	 * The starting frame of the driving position.
	 */
	private int frame;
	
	/**
	 * True if the autopilot is turned on.
	 */
	private boolean autopilotOn;
	
	/**
	 * The number of hands on the steering wheel.
	 */
	private int numHands;
	
	/**
	 * Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	private int handPlacement;
	
	/**
	 * Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	private int footPlacement;
	
	/**
	 * True if the participant is watching the road.
	 */
	private boolean eyesOnRoad;
	
	/**
	 * Duration of the position measured in frames. 
	 */
	private int duration;
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	//CONSTRUCTOR
	/**
	 * Constructor for each position state the participant was in during their drive.
	 * @param frame The starting frame of the driving position.
	 * @param autopilotOn True if the autopilot is turned on.
	 * @param numHands The number of hands on the steering wheel.
	 * @param handPlacement Position of a hand based on a ranking system. The larger the number, the worse the position.
	 * @param footPlacement Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 * @param eyesOnRoad True if the participant is watching the road.
	 * @param duration Duration of the position measured in frames. 
	 */
	public PositionTuple(int frame, boolean autopilotOn, int numHands, 
						 int handPlacement, int footPlacement, 
						 boolean eyesOnRoad, int duration)
	{
		this.setFrame(frame);
		this.setAutopilotOn(autopilotOn);
		this.setNumHands(numHands);
		this.setHandPlacement(handPlacement);
		this.setFootPlacement(footPlacement);
		this.setEyesOnRoad(eyesOnRoad);
		this.setDuration(duration);
	};
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	//INTERFACE/SETTER AND GETTERS
	/**
	 * Setter for the variable frame.
	 * @param frame The starting frame of the driving position.
	 */
	public void setFrame(int frame)
	{
		this.frame = frame;
	}
	
	/**
	 * Getter for the variable frame.
	 * @return The starting frame of the driving position.
	 */
	public int getFrame()
	{
		return this.frame;
	}
	
	/**
	 * Setter for the variable autopilotOn.
	 * @param autopilotOn True if the autopilot is turned on.
	 */
	public void setAutopilotOn(boolean autopilotOn)
	{
		this.autopilotOn = autopilotOn;
	}
	
	/**
	 * Getter for the variable autopulotOn.
	 * @return True if the autopilot is turned on.
	 */
	public boolean getAutopilotOn()
	{
		return this.autopilotOn;
	}
	
	/**
	 * Setter for the variable numHands.
	 * @param numHands The number of hands on the steering wheel.
	 */
	public void setNumHands(int numHands)
	{
		this.numHands = numHands;
	}
	
	/**
	 * Getter for the variable numHands.
	 * @return The number of hands on the steering wheel.
	 */
	public int getNumHands()
	{
		return this.numHands;
	}
	
	/**
	 * Setter for the variable handPlacement.
	 * @param handPlacement Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	public void setHandPlacement(int handPlacement)
	{
		this.handPlacement = handPlacement;
	}
	
	/**
	 * Getter for the variable handPlacement.
	 * @return Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	public int getHandPlacement()
	{
		return this.handPlacement;
	}
	
	/**
	 * Setter for the variable footPlacement.
	 * @param footPlacement Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	public void setFootPlacement(int footPlacement)
	{
		this.footPlacement = footPlacement;
	}
	
	/**
	 * Getter for the variable footPlacement.
	 * @return Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	public int getFootPlacement()
	{
		return this.footPlacement;
	}
	
	/**
	 * Setter for the variable eyesOnRoad.
	 * @param eyesOnRoad True if the participant is watching the road.
	 */
	public void setEyesOnRoad(boolean eyesOnRoad)
	{
		this.eyesOnRoad = eyesOnRoad;
	}
	
	/**
	 * Getter for the variable getEyesOnRoad.
	 * @return True if the participant is watching the road.
	 */
	public boolean getEyesOnRoad()
	{
		return this.eyesOnRoad;
	}
	
	/**
	 * Setter for the variable duration.
	 * @param duration Duration of the position measured in frames. 
	 */
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	/**
	 * Getter for the variable duration.
	 * @return Duration of the position measured in frames. 
	 */
	public int getDuration()
	{
		return this.duration;
	}
	//-------------------------------------------------------------------------------------------------------------------
}
