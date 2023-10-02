import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

class GradeBookTester {
	
	// Declare GradeBook objects
    private GradeBook gradeBook1;
    private GradeBook gradeBook2;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		// Create GradeBook objects
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);
        
     // Add scores to GradeBook objects
        gradeBook1.addScore(85);
        gradeBook1.addScore(92);
        gradeBook1.addScore(78);
	    gradeBook1.addScore(90);
	  
	}

	@AfterEach
	void tearDown() throws Exception {
		
		// Set GradeBook objects to null
        gradeBook1 = null;
        gradeBook2 = null;
	}

	@Test
	void testAddScore() {
	    // Add scores
	    gradeBook1.addScore(85);
	    gradeBook1.addScore(92);
	    gradeBook1.addScore(78);
	    gradeBook1.addScore(90);
	    gradeBook1.addScore(88);

	    // Assert the final state
	    assertArrayEquals(new double[]{85.0, 92.0, 78.0, 90.0, 88.0}, gradeBook1.getScores());
	    assertEquals(5, gradeBook1.getScoreSize());
	}




		@Test
	      void testSum() {
	   // Expected sum: 85 + 92 + 78 + 90
	      assertEquals(345, gradeBook1.sum());
	}
		@Test
	      void testMinimum() {
	    	  assertEquals(78.0, gradeBook1.minimum());
		    
	}
		
		@Test
		void testFinal() {
		    // Test case when more than two scores are added
		    gradeBook1.addScore(85);
		    gradeBook1.addScore(92);
		    gradeBook1.addScore(78);
		    gradeBook1.addScore(90);
		    gradeBook1.addScore(88);
		    // Expected final score: 85 + 92 + 90 + 88 = 355 (dropping the minimum score 78)
		    assertEquals(352.0, gradeBook1.finalScore());
		}
	
}