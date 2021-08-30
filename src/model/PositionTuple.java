package model;

import dimensions.AutopilotDim;
import dimensions.EyePositionDim;
import dimensions.FootPlacementDim;
import dimensions.HandPlacementDim;
import dimensions.NumHandsDim;

/**
 * 
 * @author dj_yeh
 *
 * This class represents the manually recorded driving position of a participant from the annotations.
 */

public class PositionTuple 
{
	//GOOD
	//-------------------------------------------------------------------------------------------------------------------
	//INSTANCE VARIABLES
	/**
	 * The starting frame of the driving position.
	 */
	private int frame;
	
	/**
	 * True if the autopilot is turned on.
	 */
	//private boolean autopilotOn;
	
	private AutopilotDim autopilotOn;
	
	/**
	 * The number of hands on the steering wheel.
	 */
	//private int numHands;
	
	private NumHandsDim numHands;
	
	/**
	 * Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	//private int handPlacement;
	
	private HandPlacementDim handPlacement;
	
	/**
	 * Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	//private int footPlacement;
	
	private FootPlacementDim footPlacement;
	
	/**
	 * True if the participant is watching the road.
	 */
	//private boolean eyesOnRoad;
	
	private EyePositionDim eyesOnRoad;
	
	/**
	 * Duration of the position measured in frames. 
	 */
	private int duration;
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	//CONSTRUCTOR
	/**
	 * General Constructor for each position state the participant was in during their drive.
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
	
	/**
	 * A more specific constructor for the class which is used when no information is known.
	 * It calls the more general constructor, passing default values to instantiate the instance variables
	 */
	public PositionTuple()
	{
		this(0, false, 0, 0, 0, false, 0);
	}
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
	
	//good
	/**
	 * Setter for the variable autopilotOn.
	 * @param autopilotOn True if the autopilot is turned on.
	 */
	public void setAutopilotOn(boolean autopilotOn)
	{
		AutopilotDim a = new AutopilotDim();
		if(autopilotOn)
		{
			a.setValue(1);
		}
		else
		{
			a.setValue(2);
		}
		this.autopilotOn = a;
	}
	
	//good
	/**
	 * Getter for the variable autopulotOn.
	 * @return True if the autopilot is turned on.
	 */
	public AutopilotDim getAutopilotOn()
	{
		return this.autopilotOn;
	}
	
	//good
	/**
	 * Setter for the variable numHands.
	 * @param numHands The number of hands on the steering wheel.
	 */
	public void setNumHands(int numHands)
	{
		NumHandsDim nH = new NumHandsDim();
		nH.setValue(numHands);
		this.numHands = nH;
		
	}
	
	//good
	/**
	 * Getter for the variable numHands.
	 * @return The number of hands on the steering wheel.
	 */
	public NumHandsDim getNumHands()
	{
		return this.numHands;
	}
	
	//DO THIS NEXT
	
	/**
	 * Setter for the variable handPlacement.
	 * @param handPlacement Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	public void setHandPlacement(HandPlacementDim handPlacement)
	{
		this.handPlacement = handPlacement;
	}
	
	/**
	 * Getter for the variable handPlacement.
	 * @return Position of a hand based on a ranking system. The larger the number, the worse the position.
	 */
	public HandPlacementDim getHandPlacement()
	{
		return this.handPlacement;
	}
	
	/**
	 * Setter for the variable footPlacement.
	 * @param footPlacement Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	public void setFootPlacement(FootPlacementDim footPlacement)
	{
		this.footPlacement = footPlacement;
	}
	
	/**
	 * Getter for the variable footPlacement.
	 * @return Position of their right foot based on a ranking system. The larger the number, the worse the position.
	 */
	public FootPlacementDim getFootPlacement()
	{
		return this.footPlacement;
	}
	
	/**
	 * Setter for the variable eyesOnRoad.
	 * @param eyesOnRoad True if the participant is watching the road.
	 */
	public void setEyesOnRoad(EyePositionDim eyesOnRoad)
	{
		this.eyesOnRoad = eyesOnRoad;
	}
	
	/**
	 * Getter for the variable getEyesOnRoad.
	 * @return True if the participant is watching the road.
	 */
	public EyePositionDim getEyesOnRoad()
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
