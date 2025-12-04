package assignment_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HolidayBonusStudentTest {
	
 private double[][] dataSet2 = { { 7 ,2, 9, 4 }, {5}, {8 ,1, 3 }, { 11 ,6 ,7 ,2 } };
	
	@Test
	void testCalculateHolidayBonus() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
			assertEquals(14000.0, result[0], .001);
			assertEquals(1000.0, result[1], .001);
			assertEquals(4000.0, result[2], .001);
			assertEquals(13000.0, result[3], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
        
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
	}

}
