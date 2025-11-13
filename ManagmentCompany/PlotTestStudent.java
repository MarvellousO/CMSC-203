import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class PlotTestStudent{
	private Plot p1 = new Plot(1, 2, 3, 4);
	private Plot p2 = new Plot(1, 2, 3, 4);
	
	/**
	 * Test method for {@link assignment_4.Plot#overlaps(assignment_4.Plot)}.
	 */
	@Test
	void testOverlaps() {
		
		assertTrue(p1.overlaps(p2));
	}

	/**
	 * Test method for {@link assignment_4.Plot#encompasses(assignment_4.Plot)}.
	 */
	@Test
	void testEncompasses() {
		assertTrue(p1.encompasses(p2));
	}

	/**
	 * Test method for {@link assignment_4.Plot#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("1,2,3,4",p2.toString());	
	}

}
