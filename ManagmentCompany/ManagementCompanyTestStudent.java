import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
     ManagementCompany managementCompany = new ManagementCompany("United Rally", "2519003", 11);
    Property property;
    @Test
    void testAddProperty() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);		 
		assertEquals(managementCompany.addProperty(property),0,0);	
    }

    @Test
    void testGetTotalRent() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);		 
        managementCompany.addProperty(property);
        assertEquals(1000.0, managementCompany.getTotalRent());
    }

    @Test
    void testGetHighestRentProperty() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);		 
        managementCompany.addProperty(property);
        Property highestRentProperty = managementCompany.getHighestRentProperty();
        assertEquals("EkkoWaves", highestRentProperty.getPropertyName());
    }

    @Test
    void testRemoveLastProperty() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);		 
        managementCompany.addProperty(property);
        managementCompany.removeLastProperty();
        assertEquals(0, managementCompany.getPropertiesCount());
    }
    @Test
    void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            Property property = new Property("EkkoWaves" + i, "Sunderland", 1000, "Ekko",i, i, 1, 1);
            managementCompany.addProperty(property);
        }
        assertTrue(managementCompany.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);
        managementCompany.addProperty(property);
        assertEquals(1, managementCompany.getPropertiesCount());
    }

    @Test
    void testIsManagementFeeValid() {
        assertTrue(managementCompany.isManagementFeeValid());
    }
    
    @Test
	public void testToString() {
    	property = new Property ("EkkoWaves", "Sunderland", 1000, "Ekko",2,5,2,2);
		assertEquals(managementCompany.addProperty(property), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for United Rally, taxID: 2519003\n"
				+ "______________________________________________________\n"
				+ "EkkoWaves,Sunderland,Ekko,1000.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 110.00";
		System.out.println(expectedString);
		System.out.println(managementCompany.toString());
		assertEquals(expectedString, managementCompany.toString());
				
	}
}
