package dimensions;

public class Dimension 
{
	
	//-----------------------------------------------Instance Variables------------------------------------------------
	protected int numVals;
	protected int value;
	protected String name;
	protected String[] dictionaryValues;
	//-------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------Constructors---------------------------------------------------
	public Dimension(int numVals, String name, String... dictionaryValues)
	{
		this.setNumVals(numVals);
		this.setName(name);
		this.setDictionary(dictionaryValues);
	}
	//-------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------Instance Methods-------------------------------------------------------
	//Setter and Getters
	private void setNumVals(int numVals)
	{
		this.numVals = numVals;
	}
	
	public int getNumVals()
	{
		return this.numVals;
	}
	
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	private void setDictionary(String[] dictionaryValues)
	{
		this.dictionaryValues = dictionaryValues;
	}
	
	public String[] getDictionary()
	{
		return this.dictionaryValues;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	
	
}
