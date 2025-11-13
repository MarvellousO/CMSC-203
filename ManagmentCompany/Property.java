public class Property {
	
	private String city;
	private String owner;
	private String propertyName;
	private Plot plot;
	private double rentAmount;
	
	/**
	 * Default constructor  
	 */
	public Property() 
	{
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.plot = new Plot(0,0,1,1);
		this.rentAmount = 0.0;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	Property(String propertyName, String city, 
			double rentAmount, String owner)
	{
		this.city = city;
		this.owner = owner;
		this.plot = new Plot(0,0,1,1);
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
	}
	
	/**
	 * 
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	Property(String propertyName, String city, double rentAmount, 
			String owner, int x, int y, int width, int depth)
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.plot = new Plot(x,y,width,depth);
		this.rentAmount = rentAmount;
	}
	
	/**
	 * 
	 * @param otherProperty
	 */
	Property(Property otherProperty)
	{ 
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.plot = otherProperty.plot;
		this.propertyName = otherProperty.propertyName;
		this.rentAmount = otherProperty.rentAmount;
	}

	
	// Accessors
	/**
	 * 
	 * @return city
	 */
	public String getCity(){return this.city; }
	
	/**
	 * 
	 * @return owner
	 */
	public String getOwner(){return this.owner;}
	
	/**
	 * 
	 * @return plot
	 */
	public Plot getPlot() {return this.plot;}
	
	/**
	 * 
	 * @return property Name
	 */
	public String getPropertyName() {return this.propertyName;}
	
	/**
	 * 
	 * @return rent amount
	 */
	public double getRentAmount() {return this.rentAmount;}

	//Mutator
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city){this.city = city; }
	
	/**
	 * 
	 * @param owner
	 */
	public void setOwner(String owner){this.owner = owner;;}
	
	/**
	 * 
	 * @param plot
	 */
	public void setPlot(Plot plot) {this.plot = plot;}
	
	/**
	 * 
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {this.propertyName = propertyName ;}
	
	/**
	 * 
	 * @param rentAmount
	 */
	public void setRentAmount( double rentAmount) {this.rentAmount = rentAmount;}

	/**
	 * Returns the information of the property
	 */
	@Override
	public String toString() { return this.propertyName + "," + 
								this.city + "," + 
								this.owner + "," + 
								this.rentAmount;}
	
}
