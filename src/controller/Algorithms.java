package controller;

import java.util.ArrayList;

import model.FrequentItemset;

public class Algorithms 
{
	//--------------------------------------------------CASE 1------------------------------------------------
	/**
	 * Calculates the conditional probability of crashing based on the choice chosen by the user. 
	 * @param choice represents the attribute the conditional probability is calculated with respect to.
	 * 0: Quit
	 * 1: Yawn
	 * 2: Age
	 */
	public static ArrayList<Double> conditionalProb(int choice)
	{
		ArrayList<Double> prob = new ArrayList<Double>();
		
		//gets the regular probability of crashing
		double numCrashes = 0;
		for(int i = 0; i < Analyzer.drivers.size(); i++)
		{
			if(!Analyzer.drivers.get(i).getAvoidEvent())
			{
				numCrashes++;
			}
		}
		prob.add(100.0 * (numCrashes/(double)Analyzer.drivers.size()));
		prob.add((double)Analyzer.drivers.size());


		
		
		if(choice == 0)
		{
			
		}
		
		
		else if(choice == 1)
		{
			double yawners = 0;
			double yawnCrashers = 0;
			
			double nonYawnCrashers  = 0;
			
			//calculates the conditional probability of crashing with respect to people yawning and not yawning
			for(int i = 0; i < Analyzer.drivers.size(); i++)
			{
				//if people yawned
				if(Analyzer.drivers.get(i).getNumYawns() != 0)
				{
					yawners++;
					if(!Analyzer.drivers.get(i).getAvoidEvent())
					{
						yawnCrashers++;
					}
				}
				//if people didn't yawn
				else
				{
					if(!Analyzer.drivers.get(i).getAvoidEvent())
					{
						nonYawnCrashers++;
					}
				}
				
				
			}
			double nonYawners = Analyzer.drivers.size() - yawners;
			
			

			prob.add(100.0 * (yawnCrashers/yawners));
			prob.add((double)yawners);
			prob.add(100.0 * (nonYawnCrashers/nonYawners));
			prob.add((double)nonYawners);
	
		}
		else
		{
			
		}
		return prob;
	}
	
	//--------------------------------------------------CASE 2------------------------------------------------
	
	
	/*
	 * Ideas:
	 * 1.) Could create an n-dimensional cube that stores the count of each n-tuple using the value of each attribute as the key
	 */
	
	
	public static ArrayList<FrequentItemset> frequentItemsets(double min_sup)
	{
		
		return null;
	}
	
	private static void prune()
	{
		
	}
	
	private static void join()
	{
		
	}
	
	private static ArrayList<FrequentItemset> frequent_1_itemset()
	{
		return null;
		
	}
	
	public static ArrayList<FrequentItemset> associationRules(double min_conf)
	{
		return null;
	}
}
