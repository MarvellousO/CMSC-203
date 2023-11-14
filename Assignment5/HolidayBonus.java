package holidayBonus;

/**
 * The HolidayBonus class provides methods for calculating holiday bonuses
 * based on the highest and lowest values in each column of a two-dimensional array.
 */
public class HolidayBonus {

    /**
     * Calculates the holiday bonus for each store based on the highest, lowest,
     * and other values in each column of the data array.
     *
     * @param data  The two-dimensional array containing store sales data.
     * @param high  The bonus amount for the highest sales in a column.
     * @param low   The bonus amount for the lowest sales in a column.
     * @param other The bonus amount for sales other than the highest or lowest.
     * @return An array representing the holiday bonus for each store.
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
        // Create a two-dimensional array to store the bonus values for each store and each category.
        double[][] holidayBonusArr = new double[data.length][];

        // Initialize the holidayBonusArr array with the same structure as the data array.
        for (int i = 0; i < data.length; i++) {
            holidayBonusArr[i] = new double[data[i].length];
        }

        // Calculate the holiday bonus for each store and each category.
        for (int i = 0; i < holidayBonusArr.length; i++) {
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);

            for (int j = 0; j < holidayBonusArr[i].length; j++) {
                if (j == highIndex) {
                    holidayBonusArr[i][j] = high;
                } else if (j == lowIndex) {
                    holidayBonusArr[i][j] = low;
                } else {
                    holidayBonusArr[i][j] = other;
                }
            }
        }

        // Calculate the total holiday bonus for each store.
        double[] holidayBonusPerStore = new double[data.length];

        for (int i = 0; i < holidayBonusArr.length; i++) {
            for (int j = 0; j < holidayBonusArr[i].length; j++) {
                holidayBonusPerStore[i] += holidayBonusArr[i][j];
            }
        }

        // Return the array representing the holiday bonus for each store.
        return holidayBonusPerStore;
    }

    /**
     * Calculates the total holiday bonus for all stores based on the highest, lowest,
     * and other values in each column of the data array.
     *
     * @param data  The two-dimensional array containing store sales data.
     * @param high  The bonus amount for the highest sales in a column.
     * @param low   The bonus amount for the lowest sales in a column.
     * @param other The bonus amount for sales other than the highest or lowest.
     * @return The total holiday bonus for all stores.
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
        // Create a two-dimensional array to store the bonus values for each store and each category.
        double[][] holidayBonusArr = new double[data.length][];

        // Initialize the holidayBonusArr array with the same structure as the data array.
        for (int i = 0; i < data.length; i++) {
            holidayBonusArr[i] = new double[data[i].length];
        }

        // Calculate the holiday bonus for each store and each category.
        for (int i = 0; i < holidayBonusArr.length; i++) {
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);

            for (int j = 0; j < holidayBonusArr[i].length; j++) {
                if (j == highIndex) {
                    holidayBonusArr[i][j] = high;
                } else if (j == lowIndex) {
                    holidayBonusArr[i][j] = low;
                } else {
                    holidayBonusArr[i][j] = other;
                }
            }
        }

        // Calculate the total holiday bonus for all stores.
        double holidayTotal = 0.0;

        for (int i = 0; i < holidayBonusArr.length; i++) {
            for (int j = 0; j < holidayBonusArr[i].length; j++) {
                holidayTotal += holidayBonusArr[i][j];
            }
        }

        // Return the total holiday bonus for all stores.
        return holidayTotal;
    }
}