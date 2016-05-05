package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import org.apache.commons.lang3.ArrayUtils;


//Create a utility class that will return elements of the matrix-like objects in particular formats.
public abstract class MyUtility   {


    //Any variables required for calculations.
    
    private static double[][] matrixEntryDoublePrim = new double[10][10];
    
    private static double[][] returnedMatrix = new double[10][10];
    

    //A method to return the rows in primitive double format.
    //The rows are received in object Double format.
    //This also works when one Double[][] matrix is passed as an argument.
    public static double[][] rowsToDoublePrim(Double[]... array)   {
        
        //For each row:
        for (int i = 0; i < array.length; i++)   {
        
            //For each column:
            for (int j = 0; j < array[i].length; j++)   {
            
                //Store the elements in primitive format.
                matrixEntryDoublePrim[i][j] = array[i][j].doubleValue();
            }
            
            //For each row, trim the width, and store the row in an array.
            returnedMatrix[i] = ArrayUtils.subarray(matrixEntryDoublePrim[i], 0, array[i].length);
        }
        
        //Trim the number of rows.
        returnedMatrix = ArrayUtils.subarray(returnedMatrix, 0, array.length);
        
        //Return the n x n primitive double matrix.
        return returnedMatrix;
    }
    
    
    //If trace is needed, it is calculated here:    
    public static double theTrace(Double[]... array)   {
    
        double trace = 0.0;
        
        for (int i = 0; i < array.length; i++)   {
        
            trace = trace + array[i][i];
        }
      
        return trace;
    }
}
