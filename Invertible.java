package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;


//A class for creating, and then inverting, invertible matrix-like structures:
public class Invertible extends Implementation implements StructureInterfaceA  {

    //Each matrix instance may have an associated inverse.  Each item of the inverse
    //will be stored in the 'invertedMatrx' instance variable.  Max matrix size: 10 x 10.
    private double[][] invertedMatrix = new double[10][10]; 

    //BASIC CONSTRUCTOR.
    public Invertible(Double[]... array)   {

        super(array);
    }
    
    
    //GENERIC CONSTRUCTOR.  This constructor allows for the processing of matrices 
    //whose elements are classes that implement the Number interface.
    //length is both row and column dimension.
    public <T extends Number> Invertible(T[][] passedMatrix, Class<T> type, int length)   {
    
        //Overcome the java generics matrix problem by creating the matrix at runtime.
        //Assign this matrix to the generic type.
        @SuppressWarnings("unchecked")
        T[][] theMatrix = (T[][]) Array.newInstance(type, length, length);
        
        //Elements that implement Number are here stored as Double.
        Double[][] matrixObjDouble = new Double[length][length];
        
        //Assign the values passed from class Main.
        theMatrix = passedMatrix;
        
        //Iterate over all matrix elements.
        for (int i = 0; i < passedMatrix.length; i++)   {
        
            for (int j = 0; j < passedMatrix[i].length; j++)   {
           
                //Transform something that implements Number to Double.
                matrixObjDouble[i][j] = theMatrix[i][j].doubleValue();
            }
            
            //Populate List 'doubleVal' with the rows. (One entry is one row).
            this.doubleVal.add(matrixObjDouble[i]);
        }
    }  
       
            
    //invertedMatrix getter.
    public double[][] getInvertedMatrix()   {
    
        return this.invertedMatrix;
    }
    
    //invertedMatrix setter.
    public void setInvertedMatrix(double[][] array)   {
    
        for (int i = 0; i < array.length; i++)   {
        
            for (int j = 0; j < array[i].length; j++)   {
            
                this.invertedMatrix[i][j] = array[i][j];
            }
        }
    }


    //Here calculate specifically for n = 2.
    //Assume our matrices behave exactly like normal matrices:  hence we demand a square matrix.
    public void invert2D()  {
    
        //A goAhead of 0 means e.g. the matrix is not square.
        if (this.getGoAhead() != 0)   {
        
            //For this demonstration, the 2 x 2 matrix will be retrieved as two rows.
            Double[] array0D = doubleVal.get(0);
            Double[] array1D = doubleVal.get(1);

            //But the rows need to be transformed to primitive type.  So call a utility method:
            double[][] dataDoublePrimitive = MyUtility.rowsToDoublePrim(array0D, array1D);
         
            //A class from Apache has a matrix instantiated on it. 
            Array2DRowRealMatrix matrix = new Array2DRowRealMatrix(2, 2);

            //The values, now in primitive type, may now be added.
            matrix.setRow(0, dataDoublePrimitive[0]);
            matrix.setRow(1, dataDoublePrimitive[1]);        
        
            //Apache's MatrixUtils allows us to perform the inversion.
            //Define inverse, as reference data type 'interface RealMatrix'.
            RealMatrix inverse = MatrixUtils.inverse(matrix);
        
            //Save the top and bottom row of the resulting matrix as properties of the new object.
            double[] invertedArray0 = inverse.getRow(0);       //top.
            double[] invertedArray1 = inverse.getRow(1);       //bottom.
            
            //Print to screen.
            System.out.println("\nMatrix after inversion, reported from class Invertible:");
            System.out.println(Arrays.toString(invertedArray0));
            System.out.println(Arrays.toString(invertedArray1));
            
            
            //Also, save the inversion as a 2D array.
            double[][] invertedMatrix = new double[10][10]; 
            
            for (int i = 0; i < 2; i++)   {
                
                for (int j = 0; j < 2; j++)   {
                
                    invertedMatrix[i][j] = inverse.getEntry(i,j);
                }
            }
            
            //Finally set the private instance variable.
            this.setInvertedMatrix(invertedMatrix);
            
        } //end 'if true...'
        
        else   {
        
            //If goAhead has been set to zero:
            System.out.println("\n" + "The inversion calculation has not proceeded, because the checking methods were called.  (The following zeros are default vals.)");
        }
    }
}   

