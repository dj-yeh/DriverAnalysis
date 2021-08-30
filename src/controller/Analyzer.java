package controller;

import model.DataCube;
import model.Driver;
import model.PositionTuple;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dimensions.AutopilotDim;

import org.apache.poi.ss.usermodel.CellType;

/**
 * This is the driver class for the program.
 * @author dj_yeh
 */
public class Analyzer 
{
	/**
	 * This is a global variable of all the drivers being analyzed throughout the program.
	 */
	public static ArrayList<Driver> drivers;
	
	public static DataCube d;
	
	
	public static void main(String[] args) 
	{
		importData();
		siftBadData();
		calculateDurationOfTuples();
		calculateTotalNumOfTuples();
		//printData();
		queryData();
	}
	
	//--------------------------------------Analyzing Methods-------------------------------------------
	
	/**
	 * This method imports all the data from the Excel Spreadsheet.
	 */
	public static void importData()
	{
		drivers = new ArrayList<Driver>();
		
		try
        {
            FileInputStream file = new FileInputStream(new File("Highway Spreadsheet Analysis.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            for(int sheetIndex = 0; sheetIndex <= 11; sheetIndex++) 
            {
            	//creates a driver
            	Driver driver = new Driver();
            	
            	
            	//Get first/desired sheet from the workbook
            	XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
 
            	//Iterate through each rows one by one
            	Iterator<Row> rowIterator = sheet.iterator();
            	
            	int yawns = 0;
            	
            	while (rowIterator.hasNext()) 
            	{
            		PositionTuple tuple = new PositionTuple();
            		Row row = rowIterator.next();
            		//For each row, iterate through all the columns
            		Iterator<Cell> cellIterator = row.cellIterator();
                 
            		//records which column is currently being read from
            		int col = 0;
            		while (cellIterator.hasNext()) 
            		{
            			

            			Cell cell = cellIterator.next();
            			//Check the cell type and format accordingly
            			
            			if(cell.getCellType() == CellType.BLANK)
            			{
            				break;
            			}
            			
            		    switch (col)
            		    {
            		    	case  0:
            		    		driver.setParticipantID((int)cell.getNumericCellValue());
            		    		break;
            		    	case  1:
            		    		tuple.setFrame((int)cell.getNumericCellValue());
            		    		break;
            		    	case  2:
            		    		break;
            		    	case  3:
            		    		driver.setAvoidEvent(cell.getBooleanCellValue());
            		    		break;
            		    	case  4:
            		    		tuple.setAutopilotOn(cell.getBooleanCellValue());
            		    		break;
            		    	case  5:
            		    		tuple.setNumHands((int)cell.getNumericCellValue());
            		    		break;
            		    	case  6:
            		    		tuple.setHandPlacement((int)cell.getNumericCellValue());
            		    		break;
            		    	case  7:
            		    		tuple.setFootPlacement((int)cell.getNumericCellValue());
            		    		break;
            		    	case  8:
            		    		int eyes = (int)cell.getNumericCellValue();
            		    		if(eyes == 1)
            		    		{
            		    			tuple.setEyesOnRoad(true);
            		    		}
            		    		else
            		    		{
            		    			tuple.setEyesOnRoad(false);
            		    		}
            		    		break;
            		    	case  9:
            		    		if((int)cell.getNumericCellValue() == 1)
            		    		{
            		    			yawns++;
            		    		}
            		    		break;
            		    	case  10:
            		    		break;
            		    		
            		    } 			
            		    col++;
            		}
            		
            		driver.addDrivingPosition(tuple);
            		//adds newly created driver to the list of drivers to be analyzed
            		
            	}
            	driver.setNumYawns(yawns);
            	Analyzer.drivers.add(driver);
            	file.close();

            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		
		
		
		
		

	}
	
	/**
	 * Sifts out any extra driving positions that are incorrect.
	 */
	public static void siftBadData()
	{
		
		for(int i = 0; i < Analyzer.drivers.size(); i++)
		{
			int start = 0;
			int reps = 0;
			Driver driver = Analyzer.drivers.get(i);
			for(int x = 0; x < driver.getDrivingPositions().size(); x++)
			{
				PositionTuple tuple = driver.getDrivingPositions().get(x);
				if(tuple.getFrame() == 0)
				{
					start = x;
					reps = driver.getDrivingPositions().size() - start;
					break;
				}
			}
			for(int x = 0; x < reps; x++)
			{
				driver.getDrivingPositions().remove(start);
			}
		}
	}
	
	/**
	 * Prints the data of all the drivers and all their driving positions.
	 */
	public static void printData()
	{
		for(int i = 0; i < Analyzer.drivers.size(); i++)
		{
			Driver driver = Analyzer.drivers.get(i);
			for(int x = 0; x < driver.getDrivingPositions().size(); x++)
			{
				PositionTuple tuple = driver.getDrivingPositions().get(x);
				System.out.print("ID: " + driver.getParticipantID() + "  ");
				System.out.print("Frame: " +tuple.getFrame() + "  ");
				System.out.print("Event Result: " + driver.getAvoidEvent() + "  ");
				System.out.print("Autopilot: " + tuple.getAutopilotOn() + "  ");
				System.out.print("# of Hands: " + tuple.getNumHands() + "  ");
				System.out.print("Hand Placement: " + tuple.getHandPlacement() + "  ");
				System.out.print("Foot Placement: " + tuple.getFootPlacement() + "  ");
				System.out.print("Eye Position: " + tuple.getEyesOnRoad() + "  ");
				System.out.print("Duration: " + tuple.getDuration() + "  ");
				System.out.println("");

				
			}
			System.out.println("Number of Yawns: " + driver.getNumYawns());
			
		}
		
	}
	
	public static void calculateDurationOfTuples()
	{
		//-----------------------------------------------Calculate Number of Frames Instance Var---------------------------
		for(int i = 0; i < Analyzer.drivers.size(); i++)
		{
			Driver driver = Analyzer.drivers.get(i);
			for(int x = 0; x < driver.getDrivingPositions().size() - 1; x++)
			{
				PositionTuple tuple = driver.getDrivingPositions().get(x);
				PositionTuple tuple_1 = driver.getDrivingPositions().get(x + 1);
				tuple.setDuration(tuple_1.getFrame() - tuple.getFrame());
			}
			driver.getDrivingPositions().get(driver.getDrivingPositions().size() - 1).setDuration(100);
		}
	}
	
	public static void calculateTotalNumOfTuples()
	{
		//---------------------------------Calculates the total number of "tuples" in the database-----------------------------------------
		Analyzer.numTuples = 0;
		for (int i = 0; i < Analyzer.drivers.size(); i++) 
		{
			Driver driver = Analyzer.drivers.get(i);
			ArrayList<PositionTuple> tuples = driver.getDrivingPositions();
			for (int j = 0; j < tuples.size(); j++) 
			{
				Analyzer.numTuples += tuples.get(j).getDuration();
			}
		}
		//System.out.println(Analyzer.numTuples);
	}
	
	/**
	 * This method will allow the user to query the dataset.
	 */
	public static void queryData()
	{
		int choice = -1;
		
		while(choice != 0)
		{
			//prints out directions for the user
			System.out.println("What type of query would you like to perform?"
					+ "(Please enter the number associated with the operation and 0 to quit at any time.)");
			System.out.println("0:Quit");
			System.out.println("1:Conditional Probability");
			System.out.println("2:Frequent Itemset Analysis");
			
			//setting up ability to take user input
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			
			switch (choice) {
				case 0:
					break;
				case 1:
					System.out.println();
					System.out.println("With resepct to which of the following attributes would you like to "
							+ "calculate the conditional probability of crashing?");
					System.out.println("0: Quit");
					System.out.println("1: Yawning");
					System.out.println("2: Age");
					choice = sc.nextInt();
					ArrayList<Double> condProb;
					if(choice == 0)
					{
						break;
					}
					else
					{
						condProb = Algorithms.conditionalProb(choice);
					}
					
					for(int i = 0; i < condProb.size(); i++)
					{
						System.out.println();
						if(i == 0)
						{
							System.out.println("Probability of Crashing: " + condProb.get(i) + "%");
							i++;
							System.out.println("People in the Universe: " + condProb.get(i));
						}
						else if(i == 1)
						{
							System.out.println("Conditional Probability of Crashing: " + condProb.get(i) + "%");
							i++;
							System.out.println("People in the Universe: " + condProb.get(i));
						}
						else
						{
							System.out.println("Conditional Probability of Crashing(no yawning): " + condProb.get(i) + "%");
							i++;
							System.out.println("People in the Universe: " + condProb.get(i));
						}
					}

					
					break;
				case 2:
					//Algorithms.frequentItemsets(0);
					break;
				default:
					System.out.println("That is not a valid choice.");
					break;
					
					
					
			}
			System.out.println();
			
		}
	}
	
	

}

















