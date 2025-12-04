import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    TwoDimRaggedArrayUtility() {}

    /**
     * 
     * @param file
     * @return myArray: double[][] 
     * @throws FileNotFoundException
     */
    static double[][] readFile(File file) throws FileNotFoundException {
        final int MAX_ROW = 10;
        final int MAX_COLUMN = 10;
        int row = 0;

        String[][] tempArray = new String[MAX_ROW][MAX_COLUMN];
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNextLine() && row < MAX_ROW) {
            String line = fileReader.nextLine();
            String[] separate = line.split(" ");

            for (int col = 0; col < separate.length && col < MAX_COLUMN; col++) {
                tempArray[row][col] = separate[col];
            }

            row++;
        }

        fileReader.close();

        if (row == 0) {
            return null;
        }

        double[][] myArray = new double[row][];

        for (int i = 0; i < row; i++) {

            int numOfCol = 0;
            for (int c = 0; c < MAX_COLUMN; c++) {
                if (tempArray[i][c] != null) {
                    numOfCol++;
                }
            }

            myArray[i] = new double[numOfCol];

            for (int j = 0; j < numOfCol; j++) {
                myArray[i][j] = Double.parseDouble(tempArray[i][j]);
            }
        }

        return myArray;
    }
    
    /**
     * 
     * @param data
     * @param outputFile
     * @throws FileNotFoundException
     */
    static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
    {
		
		 PrintWriter outPut = new PrintWriter(outputFile);
		 
		 for(int row =0; row < data.length;row ++) {
			 
			 for(int col = 0; col < data[row].length; col++) {
				 
				 outPut.print(data[row][col]);
				 
				 if(col < data[row].length - 1) {
					 outPut.print(" ");
				 }
			 }
			 
			 outPut.println();
		 }
		 outPut.close();
    }
    
    /**
     * 
     * @param data
     * @return
     */
    static double getTotal(double[][] data) {
    	double sum = 0;
    	for(int row=0; row < data.length; row++) {
//    Returns the total of all the elements of the two dimensional array
//    Parameters:
	    	for(int col=0; col < data[row].length; col++) {
	    		sum += data[row][col];
	//    data - the two dimensional array getting total of
	//    Returns:
	//    the sum of all the elements in the two dimensional array
	    	}
	    	
	    }
    	return sum;
    }
    
    /**
     * 
     * @param data
     * @return
     */
    static double getAverage(double[][] data) {
//	    Returns the average of the elements in the two dimensional array
//	    Parameters:
//	    data - the two dimensional array getting the average of
//	    Returns:
//	    the average of the elements in the two dimensional array 
//    	(total of elements/number of elements)
    	double sum = 0;
    	double avg = 0;
    	double numOfElements = 0;
    	for(int row=0; row < data.length; row++) {
    		
	    	for(int col=0; col < data[row].length; col++) {
	    		sum += data[row][col];
	    		 numOfElements++;
	    	}
	    }
    	avg = sum/numOfElements;
    	return avg;
    }
    
    static double getRowTotal(double[][] data, int row) {
    	
//    Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
//    Parameters:
//    data - the two dimensional array
//    row - the row index to take the total of (0 refers to the first row)
//    Returns:
//    the total of the row
    	int selectedRow = row;
    	double sumOfRow = 0;
    	for(int col = 0; col < data[selectedRow].length; col++) {
    		sumOfRow += data[selectedRow][col];
	    	} 
    	return sumOfRow;
    
    }
    
    static double getColumnTotal(double[][] data, int col) {
//    Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
//	  If a row in the two dimensional array doesn't have this column index, it is not an error, 
//    it doesn't participate in this method.
//    Parameters:
//    data - the two dimensional array
//    col - the column index to take the total of (0 refers to the first column)
//    Returns:
//    the total of the column
    	int selectedCol = col;
    	double sumOfcol = 0;
    	for(int row = 0; row < data.length; row++) {
    		if (col < data[row].length) { 
	    		sumOfcol += data[row][selectedCol];
		    } 
    	}
	    	return sumOfcol;
		
    }
    
    static double getHighestInRow(double[][] data, int row) {
//    Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
//    Parameters:
//    data - the two dimensional array
//    row - the row index to find the largest element of (0 refers to the first row)
//    Returns:
//    the largest element of the row
    	double highestInRow = 0.0;
    	int selectedRow = row;
    	for(int col=1; col < data[selectedRow].length; col++) {
	    	if(highestInRow < data[selectedRow][col]) {
	    		highestInRow = data[selectedRow][col];
	    	}
	    }
    	return highestInRow;
    }
    
    static int getHighestInRowIndex(double[][] data, int row) {
//		Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
//    	Parameters:
//    		data - the two dimensional array
//    		row - the row index to find the largest element of (0 refers to the first row)
//    		Returns:
//    		the largest element of the row
    		if (data[row].length == 0) {return -1;}
    		
    		double highestInRow = 0.0;
	    	int highestInRowIndex= 0;
	    	int selectedRow = row;
	    	int colCheck = 0;
	    	
	    	while (colCheck < data.length) {
				if (colCheck < data[row].length) {
					highestInRow = data[row][colCheck];
					break;
				} else {
					colCheck++;
				}
			}
	    	for(int col=0; col < data[selectedRow].length; col++) {
		    	if(highestInRow < data[selectedRow][col]) {
		    		highestInRowIndex = col;
		    	}
		    }
	    	return highestInRowIndex;
	    }

    static double getLowestInRow(double[][] data, int row) {
//    	Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
//    	Parameters:
//    	data - the two dimensional array
//    	row - the row index to find the smallest element of (0 refers to the first row)
//    	Returns:
//    	the smallest element of the row
    	double lowestInRow = 0.0;
    	int selectedRow = row;
    	int colCheck = 0;
    	
    	while (colCheck < data.length) {
			if (colCheck < data[row].length) {
				lowestInRow = data[row][colCheck];
				break;
			} else {
				colCheck++;
			}
		}
    	
    	for(int col=0; col < data[selectedRow].length; col++) {
	    	if(lowestInRow > data[selectedRow][col]) {
	    		lowestInRow = data[selectedRow][col];
	    	}
	    }
    	return lowestInRow;
    }
    

    static int getLowestInRowIndex(double[][] data, int row) {
//    	Returns the index of the smallest element of the selected row in the two dimensional 
//    	array index 0 refers to the first row.
//    	Parameters:
//    	data - the two dimensional array
//    	row - the row index to find the smallest element of (0 refers to the first row)
//    	Returns:
//    	the index of the smallest element of the row
    	if (data[row].length == 0) {return -1;}
    	
    	double lowestInRow  = 0.0;
    	int lowestInRowIndex = 0;
    	int selectedRow = row;
    	int colCheck = 0;
    	
    	while (colCheck < data.length) {
			if (colCheck < data[row].length) {
				lowestInRow = data[row][colCheck];
				break;
			} else {
				colCheck++;
			}
		}
    	for(int col=0; col < data[selectedRow].length; col++) {
    		
    		if(lowestInRow  > data[selectedRow][col]) {
    			lowestInRow  = data[row][col];
    			lowestInRowIndex = col;
	    	}
	    }
    	return lowestInRowIndex;
    }
    
    static double getHighestInColumn(double[][] data, int col) {
//    Returns the largest element of the selected column in the two dimensional 
//    array index 0 refers to the first column. If a row in the two dimensional 
//    array doesn't have this column index, it is not an error, it doesn't participate 
//    in this method.
//    Parameters:
//    data - the two dimensional array
//    col - the column index to find the largest element of (0 refers to the first column)
//    Returns:
//    the largest element of the column
    	double highestInCol = 0.0;
    	int selectedCol = col;
    	int rowCheck = 0;
    	
    	while (rowCheck < data.length) {
			if (col < data[rowCheck].length) {
				 highestInCol = data[rowCheck][col];
				break;
			} else {
				rowCheck++;
			}
		}
    	for(int row=0; row < data.length;row++) {
    		
    		if (data[row].length > col) {
	    		
	    		if(data[row][selectedCol] > highestInCol) {
	    			
	    			highestInCol = data[row][selectedCol];
	    		}
    		}
    	}
    	return highestInCol;
    }
    
    static int getHighestInColumnIndex(double[][] data, int col) {
//    Returns index of the largest element of the selected column in the two dimensional array 
//    index 0 refers to the first column. If a row in the two dimensional array doesn't 
//    have this column index, it is not an error, it doesn't participate in this method.
//    Parameters:
//    data - the two dimensional array
//    col - the column index to find the largest element of (0 refers to the first column)
//    Returns:
//    the index of the largest element of the column
		double highestInCol = 0.0;
		int highestInColIndex = 0;
		int selectedCol = col;
		 
		for(int row=0; row < data.length;row++) {
			
			if (data[row].length > col) {
	           
			
				if(data[row][selectedCol] > highestInCol) {
					
					highestInCol = data[row][selectedCol];
					highestInColIndex = row;
				}
			}
		}
		return highestInColIndex;
	}
    
    static double getLowestInColumn(double[][] data, int col) {
//    	Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.
//    	Parameters:
//    	data - the two dimensional array
//    	row - the row index to find the smallest element of (0 refers to the first row)
//    	Returns:
//    	the smallest element of the row
    	double lowestInCol = 0.0;
    	int selectedCol = col;
		int rowCheck = 0;
		    	
    	while (rowCheck < data.length) {
			if (col < data[rowCheck].length) {
				lowestInCol = data[rowCheck][col];
				break;
			} else {
				rowCheck++;
			}
		}
    	
    	for(int row=1; row < data.length; row++) {
	    	if(data[row].length > col) {
	    		if(lowestInCol > data[row][selectedCol] ) {
		    		lowestInCol = data[row][selectedCol];
		    		
	    		}
	    	}
	    }
    	return lowestInCol;
    }
    

    static int getLowestInColumnIndex(double[][] data, int col) {
//    	Returns the index of the smallest element of the selected row in the two dimensional 
//    	array index 0 refers to the first row.
//    	Parameters:
//    	data - the two dimensional array
//    	row - the row index to find the smallest element of (0 refers to the first row)
//    	Returns:
//    	the index of the smallest element of the row
    	double lowestInCol = data[0][0];
    	int lowestInColIndex = 0;
    	int selectedCol = col;
    	
    	
    	for(int row=0; row < data.length; row++) {
    		if(data[row].length > col){
		    	if(lowestInCol > data[row][selectedCol]) {
		    		lowestInCol = data[row][col];
		    		lowestInColIndex = row;
		    	}
    		}
	    }
    	return lowestInColIndex;
    }
    
    static double getHighestInArray(double[][] data) {
//    	Returns the largest element in the two dimensional array
//    	Parameters:
//    	data - the two dimensional array
//    	Returns:
//    	the largest element in the two dimensional array
    	double max = data[0][0];
  		for(int row=0; row<data.length; row++) {
  			for(int col=0; col< data[row].length; col++) {
  				if(data[row][col] > max) {
  					max = data[row][col];
  				}
  				
  			}
  		}
  		return max;
      }
  		
    static double getLowestInArray(double[][] data) {
//    Returns the smallest element in the two dimensional array
//    Parameters:
//    data - the two dimensional array
//    Returns:
//    the smallest element in the two dimensional array
	    double minimum = data[0][0];
		for(int row=0; row<data.length; row++) {
			for(int col=0; col< data[row].length; col++) {
				if(data[row][col] < minimum) {
					minimum =data[row][col];
				}
				
			}
		}
		return minimum;
    }
		
}

