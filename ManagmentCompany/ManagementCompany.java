import java.util.Arrays;
import java.util.Properties;

public class ManagementCompany {

	// Constants instance fields -> final keyWord
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	// Private instance fields -> private keyWord
	private String name;
	private String taxID;
	private double mgmFeePer;
	private int numberOfProperties;
	
	private Property[] properties;
	private Plot plot;
	
	
	
	
	/**
	 * Default constructor 
	 */
	public ManagementCompany() 
	{ 
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0.0;
		this.plot = new Plot(0,0, MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}
	
	
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany (String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0, MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.numberOfProperties = 0;
	}

	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name,
			 				 String taxID,
							 double mgmFee,
							 int x,
							 int y,
							 int width,
							 int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		
		this.plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * 
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
		this.properties = Arrays.copyOf(otherCompany.properties, MAX_PROPERTY);
		this.numberOfProperties = otherCompany.numberOfProperties;
	}
	
	
	// Accessors
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return taxID
	 */
	public String getTaxID() {
		return taxID;
	}
	
	/**
	 * 
	 * @return properties
	 */
	public Property[] getProperties() {
		return properties;
	}
	
	/**
	 * 
	 * @return plot
	 */
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * 
	 * @return numberOfProperties
	 */
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	/**
	 * 
	 * @return mgmFeePer
	 */
	public double getMgmFeePer() 
	{
		return mgmFeePer;
	}
	
	
	// Mutators
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * 
	 * @param taxID
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	
	/**
	 * 
	 * @param numberOfProperties
	 */
	public void setNumberOfProperties(int numberOfProperties) {
		this.numberOfProperties = numberOfProperties;
	}

	/**
	 * 
	 * @param properties
	 */
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	/**
	 * 
	 * @param plot
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	/**
	 * 
	 * @param mgmFeePer
	 */
	public void setMgmFeePer( double mgmFeePer) 
	{
		this.mgmFeePer = mgmFeePer;
	}
	
	
	// other methods
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String name, 
							String city, 
							double rent,
							String owner) {
		
        return addProperty(name, city, rent, owner, 0, 0, 1, 1);
    }
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, 
							double rent, String owner,
							int x, int y, int width, int depth) 
	{

		Property newProperty = new Property(name, city, rent, 
											owner, x, y, width, depth);
		
		return addProperty(newProperty);
	}
	
	/**
	 * 
	 * @param property
	 * @return
	 */
	public int addProperty(Property property) {
	     
        if (property == null) {
            return -2;
        }

        if (this.numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }

        for (int i = 0; i < this.numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        properties[this.numberOfProperties] = new Property(property);
        this.numberOfProperties++;

        return this.numberOfProperties - 1;
    }
	
	/**
	 * removes the last property in the Property array
	 * by setting it to a null value
	 * only if there are properties in the array
	 * 
	 */
	public void removeLastProperty() 
		{
			// Removes(nullifies) the LAST property in the properties array
		 if(this.numberOfProperties > 0) 
		 {
			 properties[this.numberOfProperties -1] = null;
			 this.numberOfProperties--;
		 }
		}
	
	/**
	 * 
	 * @return true if properties array is full, 
	 * false otherwise
	 */
	public boolean isPropertiesFull() 
		{
		 boolean full = false;
		 if(this.numberOfProperties >= MAX_PROPERTY) {full = true;}
			return full;
		}
	
	
	/**
	 *  
	 * @return summation of all rent amount in the properties array
	 */
	public double getTotalRent() {
	    double total = 0.0;
	    for (int i = 0; i < numberOfProperties; i++) {
	        total += properties[i].getRentAmount();
	    }
	    return total;
	}
	
	/**
	 * 
	 * @return the index of the highest rent property 
	 * in the properties array 
	 */
	private int getHighestRentPropertyIndex() 
	{
		int highestIndex = 0;
	    double highestRent = properties[0].getRentAmount();

	    for (int i = 1; i < numberOfProperties; i++) {  
	        Property p = properties[i];
	        if (p != null && p.getRentAmount() > highestRent) {
	            highestRent = p.getRentAmount();
	            highestIndex = i;
	        }
	    }
	    return highestIndex;
	}
	
	/**
	 * 
	 * @return true if the management fee is within the specified bound of 
	 * 0 and 100 false if it is not
	 */
	public boolean isManagementFeeValid()
	{
		boolean valid = false;
		// Returns: true of the management fee is valid (between 0-100), 
		// false otherwise
		if (mgmFeePer >= 0 && mgmFeePer <= 100) {valid = true;}
		
		return valid;
	}
	
	/**
	 * 
	 * @return the highest rent property 
	 * using the getHighestRentPropertyIndex()
	 * 
	 */
	public Property getHighestRentProperty() 
	{
		int index = getHighestRentPropertyIndex();
		// Returns:the property in the 
		// array which has the highest amount of rent
		Property highestRentProperty = properties[index];
		
		return highestRentProperty;
	}
	
	/**
	 * Overrides the built in to string method 
	 * and return the information of the management company 
	 * as well as the information of the properties in the properties 
	 */
	@Override
	public String toString() {
		double totalManagementFee = getTotalRent() * mgmFeePer / 100.0;
		String result = "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n"
	                  + "______________________________________________________\n";

	    for (int i = 0; i < numberOfProperties; i++) {
	        Property p = properties[i];
	        result += p.getPropertyName() + "," + p.getCity() + "," + p.getOwner() + "," + p.getRentAmount() + "\n"
	                + "______________________________________________________\n";
	    }

	    // Format to 2 decimal places
	    result += "\n total management Fee: " + String.format("%.2f", totalManagementFee);

	    return result;
	}



	
	
	
	
}
