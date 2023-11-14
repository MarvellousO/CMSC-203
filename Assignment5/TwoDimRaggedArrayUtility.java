package holidayBonus;

import java.io.*;


/**
 * The TwoDimRaggedArrayUtility class provides utility methods for working with
 * two-dimensional ragged arrays.
 */
public class TwoDimRaggedArrayUtility {

    /**
     * Reads data from a file and returns a two-dimensional ragged array.
     *
     * @param file The file to read the data from.
     * @return A two-dimensional ragged array containing the data from the file.
     */
    public static double[][] readFile(File file) {
        double[][] raggedArr = new double[6][]; // Initialize a ragged array with 6 rows.

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;

            // Read each line from the file and populate the ragged array.
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                int size = temp.length;
                raggedArr[i] = new double[size];

                for (int j = 0; j < size; j++) {
                    raggedArr[i][j] = Double.parseDouble(temp[j]);
                }

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return raggedArr;
    }

    /**
     * Writes a two-dimensional ragged array to a file.
     *
     * @param raggedArr The ragged array to be written to the file.
     * @param file      The file to write the data to.
     */
    public static void writeToFile(double[][] raggedArr, File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            // Iterate through the ragged array and write each element to the file.
            for (double[] row : raggedArr) {
                for (double value : row) {
                    bw.write(value + " ");
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Calculates and returns the total of all elements in the ragged array.
     *
     * @param raggedArr The two-dimensional ragged array.
     * @return The total of all elements in the ragged array.
     */
    public static double getTotal(double[][] raggedArr) {
        double total = 0;

        for (double[] row : raggedArr) {
            for (double value : row) {
                total += value;
            }
        }

        return total;
    }
    /**
     * Calculates and returns the average of all elements in the ragged array.
     *
     * @param raggedArr The two dimensional ragged array.
     * @return The average of all elements in the ragged array.
     */
    public static double getAverage(double[][] raggedArr) {
        double total = 0;
        int numOfElements = 0;
     
        // Iterate through the ragged array and accumulate total and count of elements.
        for (double[] row : raggedArr) {
            for (double value : row) {
                total += value;
                numOfElements++;
            }
        }
        // Calculate and return the average
        return total / numOfElements;
    }

    /**
     * Calculates and returns the total of all elements in the specified row of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param rowIndex  The index of the row to calculate the total for.
     * @return The total of all elements in the specified row.
     */
    public static double getRowTotal(double[][] raggedArr, int rowIndex) {
        double total = 0;

        // Iterate through each value in the specified row and accumulate the total
        for (double value : raggedArr[rowIndex]) {
            total += value;
        }

        return total;
    }

    /**
     * Calculates and returns the total of all elements in the specified column of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param colIndex  The index of the column to calculate the total for.
     * @return The total of all elements in the specified column.
     */
    public static double getColumnTotal(double[][] raggedArr, int colIndex) {
        double total = 0;

        // Iterate through each row and accumulate the value at the specified column index
        for (double[] row : raggedArr) {
            if (colIndex < row.length) {
                total += row[colIndex];
            }
        }

        return total;
    }

    /**
     * Finds and returns the highest value in the specified row of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param rowIndex  The index of the row to find the highest value in.
     * @return The highest value in the specified row.
     */
    public static double getHighestInRow(double[][] raggedArr, int rowIndex) {
        double highest = raggedArr[rowIndex][0];

        // Iterate through each value in the specified row and find the highest value
        for (double value : raggedArr[rowIndex]) {
            if (value > highest) {
                highest = value;
            }
        }

        return highest;
    }

    /**
     * Finds and returns the index of the highest value in the specified row of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param rowIndex  The index of the row to find the highest value in.
     * @return The index of the highest value in the specified row.
     */
    public static int getHighestInRowIndex(double[][] raggedArr, int rowIndex) {
        int index = 0;

        // Iterate through each value in the specified row and find the index of the highest value
        for (int i = 1; i < raggedArr[rowIndex].length; i++) {
            if (raggedArr[rowIndex][i] > raggedArr[rowIndex][index]) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Finds and returns the lowest value in the specified row of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param rowIndex  The index of the row to find the lowest value in.
     * @return The lowest value in the specified row.
     */
    public static double getLowestInRow(double[][] raggedArr, int rowIndex) {
        double lowest = raggedArr[rowIndex][0];

        // Iterate through each value in the specified row and find the lowest value
        for (double value : raggedArr[rowIndex]) {
            if (value < lowest) {
                lowest = value;
            }
        }

        return lowest;
    }

    /**
     * Finds and returns the index of the lowest value in the specified row of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param rowIndex  The index of the row to find the lowest value in.
     * @return The index of the lowest value in the specified row.
     */
    public static int getLowestInRowIndex(double[][] raggedArr, int rowIndex) {
        int index = 0;

        // Iterate through each value in the specified row and find the index of the lowest value
        for (int i = 1; i < raggedArr[rowIndex].length; i++) {
            if (raggedArr[rowIndex][i] < raggedArr[rowIndex][index]) {
                index = i;
            }
        }

        return index;
    }

    /**
     * Finds and returns the highest value in the specified column of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param colIndex  The index of the column to find the highest value in.
     * @return The highest value in the specified column.
     */
    public static double getHighestInColumn(double[][] raggedArr, int colIndex) {
        double highest = raggedArr[0][colIndex];

        // Iterate through each row and find the highest value at the specified column index
        for (double[] row : raggedArr) {
            if (colIndex < row.length && row[colIndex] > highest) {
                highest = row[colIndex];
            }
        }

        return highest;
    }


    /**
     * Finds and returns the index of the highest value in the specified column of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param colIndex  The index of the column to find the highest value in.
     * @return The index of the highest value in the specified column.
     */
    public static int getHighestInColumnIndex(double[][] raggedArr, int colIndex) {
        int highestIndex = 0;

        // Iterate through each row and find the index of the highest value at the specified column index
        for (int i = 1; i < raggedArr.length; i++) {
            if (colIndex < raggedArr[i].length && raggedArr[i][colIndex] > raggedArr[highestIndex][colIndex]) {
                highestIndex = i;
            }
        }

        return highestIndex;
    }

    /**
     * Finds and returns the lowest value in the specified column of the ragged array.
     * 
     * @param raggedArr The ragged array.
     * @param colIndex  The index of the column to find the lowest value in.
     * @return The lowest value in the specified column.
     */
    public static double getLowestInColumn(double[][] raggedArr, int colIndex) {
        double lowest = raggedArr[0][colIndex];

        // Iterate through each row and find the lowest value at the specified column index
        for (double[] row : raggedArr) {
            if (colIndex < row.length && row[colIndex] < lowest) {
                lowest = row[colIndex];
            }
        }

        return lowest;
    }

    /**
     * Calculates and returns the lowest value in the entire ragged array.
     *
     * @param raggedArr The two-dimensional ragged array.
     * @return The lowest value in the entire ragged array.
     */
    public static double getLowestInArray(double[][] raggedArr) {
        double lowest = raggedArr[0][0];

        // Iterate through the ragged array and find the lowest value.
        for (double[] row : raggedArr) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }

        return lowest;
    }
}