package model;

import java.util.ArrayList;

public interface Cuboid 
{
	//MAKE SURE TO IMPLEMENT THIS METHOD IN EACH OF THE CUBOID CLASSES
	public abstract ArrayList<String> findFrequentPredicateSets(double sup);
	
	public abstract void fillCuboid();
	
}
