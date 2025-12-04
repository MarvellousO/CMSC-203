package assignment_5;

public class HolidayBonus {
    
    // Constant bonus amounts
    public static final double HIGHEST_BONUS = 5000.0;
    public static final double LOWEST_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;
    
    /**
     * Default constructor
     *  Empty
    }
     */
    public HolidayBonus() {
    }
    
    /**
     * Calculates the holiday bonus for each store
     * @param data - the two dimensional array of store sales
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        // Handle null or empty data
        if (data == null || data.length == 0) {
            return new double[0];
        }
        
        double[] bonuses = new double[data.length];
        
        
        int maxCols = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].length > maxCols) {
                maxCols = data[i].length;
            }
        }
        
        // Process each column
        // Count how many stores have the category 
        for (int col = 0; col < maxCols; col++) {
            int storesWithCategory = 0;
            for (int row = 0; row < data.length; row++) {
                if (hasCategory(data, row, col)) {
                    storesWithCategory++;
                }
            }
            
            // Continue if no stores have the category
            if (storesWithCategory == 0) {
                continue;
            }
            
            // Get highest and lowest values using TwoDimRaggedArrayUtility
            double highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            double lowestInCol = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
            
            // Check if highest and lowest are the same 
            boolean highestEqualsLowest = (storesWithCategory == 1) || (highestInCol == lowestInCol);
           
            for (int row = 0; row < data.length; row++) {
                if (hasCategory(data, row, col)) {
                    double sales = data[row][col];
                    
                    // When only one store has a category or all values are equal
                    if (storesWithCategory == 1 || highestEqualsLowest) {
                        bonuses[row] += OTHER_BONUS;
                    } 
                    // Multiple stores with a category
                    else if (sales == highestInCol) {
                        bonuses[row] += HIGHEST_BONUS;
                    } else if (sales == lowestInCol) {
                        bonuses[row] += LOWEST_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        
        return bonuses;
    }
    
    /**
     * Calculates the total holiday bonuses
     * @param data - the two dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0.0;
        
        for (double bonus : bonuses) {
            total += bonus;
        }
        
        return total;
    }
    
    /**
     * Helper method to check if a store has a specific category
     * 
     */
    private static boolean hasCategory(double[][] data, int row, int col) {
        return data != null && row < data.length && 
        	data[row] != null && col < data[row].length;
    }
}