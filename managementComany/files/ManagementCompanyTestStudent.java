package managementComany;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ManagementCompanyTestStudent {
    ManagementCompany managementCompany;
    Property property;

    @BeforeEach
    void setUp() throws Exception {
        managementCompany = new ManagementCompany("CompanyName", "TaxID", 10.0);
        property = new Property("PropertyName", "City", 1000.0, "Owner");
    }

    @AfterEach
    void tearDown() throws Exception {
        managementCompany = null;
        property = null;
    }

    @Test
    void testAddProperty() {
        assertEquals(0, managementCompany.addProperty(property));
    }

    @Test
    void testGetTotalRent() {
        managementCompany.addProperty(property);
        assertEquals(1000.0, managementCompany.getTotalRent());
    }

    @Test
    void testGetHighestRentProperty() {
        managementCompany.addProperty(property);
        Property highestRentProperty = managementCompany.getHighestRentProperty();
        assertEquals("PropertyName", highestRentProperty.getPropertyName());
    }

    @Test
    void testRemoveLastProperty() {
        property = new Property("PropertyName", "City", 1000.0, "Owner");
        managementCompany.addProperty(property);
        managementCompany.removeLastProperty();
        assertEquals(0, managementCompany.getPropertiesCount());
    }
    @Test
    void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            Property property = new Property("Property" + i, "City", 1000.0, "Owner");
            assertEquals(0, managementCompany.addProperty(property));
        }
        assertEquals(true, managementCompany.isPropertiesFull());
    }

    @Test
    void testGetPropertiesCount() {
        managementCompany.addProperty(property);
        assertEquals(1, managementCompany.getPropertiesCount());
    }

    @Test
    void testIsManagementFeeValid() {
        assertTrue(managementCompany.isManagementFeeValid());
    }
}
