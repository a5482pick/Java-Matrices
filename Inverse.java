package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


//A class for calculating inverses of n x n-dimension matrices.
public class Inverse   {

    //An ArrayList object to store each row as one Double[].
    private List<Double[]> doubleVal = new ArrayList<Double[]>();
    
    //The argument of the constructor takes n arrays of size n. (i.e. n row arrays.) 
    public Inverse(Double[]... array)   {
    
        //Add each of the n arrays (of size n) to the ArrayList object.
        for (int i = 0; i < array.length; i++)   {
        
            this.doubleVal.add(array[i]);
        }
    }


    //Until now, dimensions where of unknown n.  Here calculate specifically for n = 2.
    public void invert2D()  {
      
        //array0D is the top row, array1D is the bottom row.
        Double[] array0D = doubleVal.get(0);
        Double[] array1D = doubleVal.get(1);
        
        //To use Apache matrix methods, will need to transform to primitive type.
        //array0 and array1 will store the rows in primitive type.
        double[] array0 = {0,0};
        double[] array1 = {0,0};
        
        //Loop twice to store all four elements as primitive type.
        for (int i = 0; i < 2; i++)   {
        
            array0[i] = array0D[i].doubleValue();
            array1[i] = array1D[i].doubleValue();
        }
         
        //A class from Apache has a matrix instantiated on it. 
        Array2DRowRealMatrix matrix = new Array2DRowRealMatrix(2, 2);

        //The values are added.
        matrix.setRow(0, array0);
        matrix.setRow(1, array1);        
        
        //Apache's MatrixUtils allows us to perform the inversion.
        RealMatrix inverse = MatrixUtils.inverse(matrix);
        
        //Save the top and bottom row of the resulting matrix.
        double[] invertedArray0 = inverse.getRow(0);       //top.
        double[] invertedArray1 = inverse.getRow(1);       //bottom.
       
        //Print to screen.
        System.out.println(Arrays.toString(invertedArray0));
        System.out.println(Arrays.toString(invertedArray1));
    }
}   

