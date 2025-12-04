package assignment_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityStudentTest {

    private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
    private double[][] dataSet2 = {{7, 2, 9, 4},{5},{8, 1, 3},{11, 6, 7, 2}};
    private double[][] dataSet3 = {{7.2, 2.5, 9.3, 4.8},{5.9},{8.1, 1.7, 3.3},{11.6, 6.9, 7.3, 2.7}};
    private double[][] dataSet4 = {{-2.5, -5.3, 6.1},{-4.4, 8.2},{2.3, -7.5},{-4.2, 7.3, -5.9, 2.6}};


    @Test
    void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.0001);
    }

    @Test
    void testGetAverage() {
        assertEquals(71.3 / 12, TwoDimRaggedArrayUtility.getAverage(dataSet3), 0.0001);
    }

    @Test
    void testGetRowTotal() {
        assertEquals(22.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 0), 0.0001);
    }

    @Test
    void testGetHighestInRow() {
        assertEquals(9.3, TwoDimRaggedArrayUtility.getHighestInRow(dataSet3, 0), 0.0001);
    }

    @Test
    void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3, 0));
    }

    @Test
    void testGetLowestInRow() {
        assertEquals(-5.3, TwoDimRaggedArrayUtility.getLowestInRow(dataSet4, 0), 0.0001);
    }
    
    @Test
    void testGetLowestInRowIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet4, 0));
    }


    @Test
    void testGetColumnTotal() {
        assertEquals(31.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 0), 0.0001);
    }

    @Test
    void testGetHighestInColumn() {
        assertEquals(6.9, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet3, 1), 0.0001);
    }

    @Test
    void testGetHighestInColumnIndex() {
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet3, 1));
    }

    @Test
    void testGetLowestInColumn() {
        assertEquals(-4.4, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4, 0), 0.0001);
    }

    @Test
    void testGetLowestInColumnIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4, 0));
    }


    @Test
    void testGetHighestInArray() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), 0.0001);
    }

    @Test
    void testGetLowestInArray() {
        assertEquals(-7.5, TwoDimRaggedArrayUtility.getLowestInArray(dataSet4), 0.0001);
    }
}
