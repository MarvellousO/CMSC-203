import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	
	private Property p1 = new Property("Montgomery Hotel", 
										"Rockville", 2450.00,
										"Wells Fargo Bank");
	
	@Test
	void testGetPropertyName() {
		assertEquals("Montgomery Hotel", p1.getPropertyName());
	}

	
	@Test
	void testGetRentAmount() {
		assertEquals(2450.00, p1.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, p1.getPlot().getX());
		assertEquals(0, p1.getPlot().getY());
		assertEquals(1, p1.getPlot().getWidth());
		assertEquals(1, p1.getPlot().getDepth());
	}

	
	@Test
	void testToString() {
		assertEquals("Montgomery Hotel,Rockville,Wells Fargo Bank,2450.0",p1.toString());	
	}

}
