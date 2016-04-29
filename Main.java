package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.io.*;
 
public class Main  {
 
    //Set the default matrix dimension as 2 x 2;
    //Use the following getter and setter to alter. 
    private static int dimension[] = {2,2};
    
    //dimension getter.
    public static int[] getDimension()   {
    
        return Main.dimension;
    }
    
    //dimension setter.
    public static void setDimension(int row, int column)   {
    
        Main.dimension[0] = row;
        Main.dimension[1] = column;
    }
 
    //The entry point.
    public static void main(String[] args) throws IOException   {
        
        
        /*--------------------------------------------------------------------------------*/
        
        //An example array is immediately provided:
        //Ensure dimension is still set to 2.
        Main.setDimension(2, 2);
        
        //Then create the example matrix: array0 is the top row, array1 is the bottom row.
        Double[] array0 = {0.5, -0.5};
        Double[] array1 = {-0.33333, 0.66666};
        
        /*---------------------------------------------------------------------------------*/
        
        //Instantiate an object to be inverted, then apply the inverting method.
        Inverse inverse = new Inverse(array0, array1);
        
        //These are extra checks that may be performed prior to calculation on Inverse object.
        inverse.isCorrectDimension(2);
        inverse.isItDouble();
        inverse.isSquare();
        
        //Perform the inversion.
        inverse.invert2D();
        
        
        //Print the matrix a second time, to ensure it is 'saved'.
        double[][] invertedMatrix = inverse.getInvertedMatrix();
        
        //(The output matrix elements will all be zero if the calculation was not performed.)      
        for (int i = 0; i < Main.getDimension()[0]; i++)   {
        
            System.out.println("The matrix after inversion, row " + (i+1) + ":");
        
            for (int j = 0; j < Main.getDimension()[1]; j++)   {
            
                System.out.println(", " + invertedMatrix[i][j]);
            }
        }
        
        /*-------------------------------------------------------------------------------------*/
        
        
        //And now perform an eigendecomposition on the example matrix.        
        Eigenvalues eigenObject = new Eigenvalues(array0, array1);
        
        eigenObject.eigenvalues();
        
        //Print out the eigenvalues.
        double[] theEigenvalues = eigenObject.getEigenvalues();
        
        for (int i = 0; i < Main.getDimension()[0]; i++)   {
        
            System.out.println("The eigenvalue " + (i + 1) + ":  " + theEigenvalues[i] + " ");
        } 
    }      
}
