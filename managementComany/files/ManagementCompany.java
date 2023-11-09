package managementComany;



public class ManagementCompany {
    private String name;
    private String taxId;
    private double managementFeePercentage;
    
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    private Property[] properties; //Array of property objects
    private Plot plot;
    private int numberOfProperties;

    public ManagementCompany() {
        // Default constructor
    }

    public ManagementCompany(String name, String taxId, double managementFeePercentage) {
        this.name = name;
        this.taxId = taxId;
        if (isMangementFeeValid(managementFeePercentage)) {
            this.managementFeePercentage = managementFeePercentage;
        } else {
            this.managementFeePercentage = 0; // Default to 0 if the fee is invalid.
        }
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    // Getter and setter methods for name, taxId, and managementFeePercentage
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getManagementFeePercentage() {
        return managementFeePercentage;
    }

    public void setManagementFeePercentage(double managementFeePercentage) {
        if (isMangementFeeValid(managementFeePercentage)) {
            this.managementFeePercentage = managementFeePercentage;
        }
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public void setNumberOfProperties(int numberOfProperties) {
        this.numberOfProperties = numberOfProperties;
    }
    public int addProperty(Property property) {
        // Implement the logic to add a property to the properties array
    	 if (isPropertiesFull()) {
    		 return -1; //the array is full
    	 }
    	  if (property == null) {
    		  return -2; // Property is null
    }
    	  if (!plot.encompasses(property.getPlot())) {
              return -3; // Plot not encompassed by management company plot
          }

          for (int i = 0; i < numberOfProperties; i++) {
              if (properties[i].getPlot().overlaps(property.getPlot())) {
                  return -4; // Plot overlaps with another property's plot
              }
          }
          
          properties[numberOfProperties] = property;
          numberOfProperties++;
          return numberOfProperties - 1;
      }

    public double getTotalRent() {
        // Implement the logic to calculate and return the total rent of all properties
    	 double totalRent = 0;
         for (int i = 0; i < numberOfProperties; i++) {
             totalRent += properties[i].getRentAmount();
         }
         return totalRent;
     }

    public Property getHighestRentProperty() {
        // Implement the logic to find and return the property with the highest rent
            if (numberOfProperties == 0) {
                return null;
         }
            Property highestRentProperty = properties[0];
            for (int i = 1; i < numberOfProperties; i++) {
                if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                    highestRentProperty = properties[i];
                }
        	}
            return highestRentProperty;
        }

    public void removeLastProperty() {
        // Implement the logic to remove the last property from the properties array
    	if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        // Implement the logic to check if the properties array is full
    	return numberOfProperties == MAX_PROPERTY;
    }
	

    public int getPropertiesCount() {
        // Implement the logic to return the current number of properties
    	 return numberOfProperties;
    }


    public boolean isMangementFeeValid( double fee) {
        // Implement the logic to check if the management fee is valid (between 0-100)
    	return fee >= 0 && fee <= 100;
    }
    @Override
    public String toString() {
        // Implement the logic to create and return a string representation of the management company
    	StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name).append(", taxID: ").append(taxId).append("\n");
        result.append("______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            Property property = properties[i];
            result.append(property.toString()).append("\n");
        }

        result.append("______________________________________________________\n\n");
        result.append("total management Fee: ").append(String.format("%.2f", getTotalRent() * (managementFeePercentage / 100)));
        
        return result.toString();
    }

	public Boolean isManagementFeeValid() {
		
		return null;
	}
}