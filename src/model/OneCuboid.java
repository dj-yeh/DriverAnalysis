package model;

import java.util.ArrayList;

import controller.Analyzer;
import dimensions.Dimension;

public class OneCuboid implements Cuboid
{
	/**
	 * This is the only set of 1-D cuboids allowed in the program.
	 */
	private static ArrayList<Cuboid> OneCuboids = null;
	
	//-------------------------------------------Instance Variables-----------------------------------------
	/**
	 * Instance variable that represents the dimension of the cuboid
	 */
	private int numDims;
	
	/**
	 * Instance variable that represents the support of each value of the dimension in the database tuples. 
	 */
	private int[] support;
	
	/**
	 * Instance variable that represents the name of the dimension.
	 */
	private String dim;
	//------------------------------------------------------------------------------------------------------
	
	//-------------------------------------------Instance Methods-------------------------------------------
	
	
	
	/**
	 * Constructor for the OneCuboid class
	 * Private as to use the "Singleton Pattern" to restrict the number of cuboids constructed.
	 * The logic of creating the cuboids should be pawned off to logic and not the user. 
	 * @param dim1
	 */
	private OneCuboid(Dimension dim1)
	{
		this.setNumDims(1);
		this.support = new int[dim1.getNumVals()];
		this.setDims(dim1.getName());
		
	}
	
	private void setNumDims(int numDims)
	{
		this.numDims = numDims;
	}
	
	public void setSupport(int[] support)
	{
		this.support = support;
	}
	
	private void setDims(String dim)
	{
		this.dim = dim;
	}
	
	
	//NOT DONE
	public ArrayList<String> findFrequentPredicateSets(double sup)
	{
		ArrayList<String> frequentPreds = new ArrayList<String>();
		//just read off the cube
		for(int i = 0; i < this.support.length; i++)
		{
			double propSup = (double)support[i]/(double)Analyzer.d.getNumTuples();
			if(propSup >= sup)
			{
				frequentPreds.add(this.dim + ": " + "******Fill with value translatino from dimension class******");
			}
		}
		return frequentPreds;
	}
	
	
	public void fillCuboid()
	{
		//for each driver
		for(Driver driver:Analyzer.drivers)
		{
			//for each position tuple of a driver
			for(PositionTuple posTup:driver.getDrivingPositions())
			{
				
			}
		}
	}
	
	//------------------------------------------------------------------------------------------------------
	
	
	public static ArrayList<Cuboid> construct1DCuboids(ArrayList<Dimension> dims)
	{
		//if the 1-D cuboids have not yet been constructed, it constructs them
		if(OneCuboid.OneCuboids == null)
		{
			ArrayList<Cuboid> cuboids = new ArrayList<Cuboid>();
			//creates one 1-D cuboid for each relevant dimension
			for(Dimension d:dims)
			{
				cuboids.add(new OneCuboid(d));
			}
			OneCuboid.OneCuboids = cuboids;
		}
		//once the 1-D cuboids have already been constructed, then it returns them
		return OneCuboid.OneCuboids;

	}
}
