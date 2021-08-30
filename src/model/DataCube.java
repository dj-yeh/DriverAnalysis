package model;

import java.util.ArrayList;

import dimensions.Dimension;

/**
 * This class represents a data cube that will be analyzed for frequent k-predicatesets.
 * General Notes: Bad extendability in terms of the constructor.
 * @author dj_yeh
 *
 */
public class DataCube 
{
	
	/**
	 * The one and only datacube instance allowed within the program
	 */
	private static DataCube d = null;
	
	
	//---------------------------------------Instance Variables---------------------------------------------
	/**
	 * Represents all the n-d cuboids constructed from the relevant attributes being analyzed of a database. 
	 * Will always be sorted from lowest dimensional cuboids to highest dimensional cuboids.
	 */
	private ArrayList<ArrayList<Cuboid>> cuboids;
	
	/**
	 * Represents all the tuples within the data structure
	 */
	private int numTuples;
	//------------------------------------------------------------------------------------------------------
	
	

	/**
	 * Constructor for the class.
	 * Private visibility as to implement the Singleton software pattern.
	 * Restricts the program to only one datacube. 
	 * @param dimensions
	 */
	private DataCube(ArrayList<Dimension> dimensions, int numTuples)
	{
		this.setNumTuples(numTuples);
		
		this.cuboids = new ArrayList<ArrayList<Cuboid>>();
		//giving the single datacube instance an alias
		ArrayList<ArrayList<Cuboid>> c = this.cuboids;
		//repeats based on the number of dimensions being analyzed to create all n-d cuboids
		for(int i = 0; i <= dimensions.size(); i++)
		{
			//BAD EXTENDABILITY, WOULD NEED TO BE MODIFIED TO EXTEND IT
			switch (i + 1) {
				case 1:
					//adds all the possible 1-D cuboids
					c.add(OneCuboid.construct1DCuboids(dimensions));
					break;
				case 2:
					//adds all the possible 2-D cuboids
					c.add(TwoCuboid.construct2DCuboids(dimensions));
					break;
				case 3:
					//adds all the possible 3-D cuboids
					c.add(ThreeCuboid.construct3DCuboids(dimensions));
					break;
				case 4:
					//adds all the possible 4-D cuboids
					c.add(FourCuboid.construct4DCuboids(dimensions));
					break;
				case 5:
					//adds all the possible 5-D cuboids
					c.add(FiveCuboid.construct5DCuboids(dimensions));
					break;
			}
		}
	}
	//NOTE: this method of creating the cuboids is a little too concrete since if this software were to be shipped to users
	//and the user wanted to extend the project by enabling it to analyze more dimensions, this method would need to be changed
	//BAD EXTENDABILITY
	
	
	//good
	/**
	 * Setter method for the instance variable numTuples
	 * @param numTuples
	 */
	public void setNumTuples(int numTuples)
	{
		this.numTuples = numTuples;
	}
	
	
	//good
	/**
	 * Getter method for the instance variable numTuples
	 * @return the number of tuples stored within the datacube
	 */
	public int getNumTuples()
	{
		return this.numTuples;
	}
	
	
	//--------------------------------------------Interface-----------------------------------------------
	

	//good
	public static DataCube constructDataCube(ArrayList<Dimension> dimensions, int numTuples)
	{
		//if a datacube instance has not yet been constructed, create one
		//if one has been created, creation will be skipped and the already created instance will be returned
		if(DataCube.d == null)
		{
			DataCube.d = new DataCube(dimensions, numTuples);
		}
		return DataCube.d;
	}
	//should have the same parameters as the constructor
	
	
}
