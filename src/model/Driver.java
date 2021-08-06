package model;

import java.util.ArrayList;

/**
 * 
 * @author dj_yeh
 *
 * This class represents a subject that used the driving simulator.
 */
public class Driver 
{
	//-------------------------------------------------------------------------------------------------------------------
	//INSTANCE VARIABLES
	/**
	 * de-identified ID of a participant in the study
	 */
	private int participantID;
	
	/**
	 * Number of times participant yawned.
	 */
	private int numYawns;
	
	/**
	 * True if the participant avoided a dangerous situation when the autopilot failed.
	 */
	private boolean avoidEvent;
	
	/**
	 * All the driving positions of the participant during the simulation.
	 */
	private ArrayList<PositionTuple> drivingPositions;
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	//CONSTRUCTOR
	/**
	 * General constructor for each driving participant.
	 * 
	 * @param participantID de-identified ID of a participant in the study
	 * @param numYawns Number of times participant yawned.
	 * @param avoidEvent True if the participant avoided a dangerous situation when the autopilot failed.
	 */
	public Driver(int participantID, int numYawns, boolean avoidEvent)
	{
		this.setParticipantID(participantID);
		this.setNumYawns(numYawns);
		this.setAvoidEvent(avoidEvent);
		this.drivingPositions = new ArrayList<PositionTuple>();
	}
	
	/**
	 * Constructor for a driver where the instance variable information is unknown at the moment. 
	 * Calls the most general constructor.
	 */
	public Driver()
	{
		this(0, 0, false);
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	//INTERFACE/SETTERS AND GETTERS
	/**
	 * Setter method for the variable participantID.
	 * @param participantID de-identified ID of a participant in the study
	 */
	public void setParticipantID(int participantID)
	{
		this.participantID = participantID;
	}
	
	/**
	 * Getter method for the variable participantID.
	 * @return participantID of the driving participant
	 */
	public int getParticipantID()
	{
		return this.participantID;
	}
	
	/**
	 * Setter method for the variable numYawns.
	 * @param numYawns Number of times participant yawned.
	 */
	public void setNumYawns(int numYawns)
	{
		this.numYawns = numYawns;
	}
	
	/**
	 * Getter method for the variable numYawns.
	 * @return number of times the participant yawned.
	 */
	public int getNumYawns()
	{
		return this.numYawns;
	}
	
	/**
	 * Setter method for the variable avoidEvent.
	 * @param avoidEvent True if the participant avoided a dangerous situation when the autopilot failed.
	 */
	public void setAvoidEvent(boolean avoidEvent)
	{
		this.avoidEvent = avoidEvent;
	}
	
	/**
	 * Getter method for the variable avoidEvent.
	 * @return the variable avoidEvent
	 */
	public boolean getAvoidEvent()
	{
		return this.avoidEvent;
	}
	/**
	 * Getter method for the variable drivingPositions
	 * @return All the driving positions of the participant during the simulation.
	 */
	public ArrayList<PositionTuple> getDrivingPositions()
	{
		return this.drivingPositions;
	}
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------
	/**
	 * This adds a driving position tuple to the ArrayList of driving positions of the participant.
	 * @param tuple a driving position of the driving participant during the simulation
	 */
	public void addDrivingPosition(PositionTuple tuple)
	{
		this.drivingPositions.add(tuple);
	}
}
