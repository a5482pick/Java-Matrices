package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


//A class to find the eigenvalues of n x n matrix-like structure.  (These objects override
//isItCorrectSize(), so are not necessarily also Invertible.)
public class Eigenvalues extends Implementation implements StructureInterfaceB  {

    //An instance variable to store the eigenvalues.
    private double[] eigenvalues = {0,0}; 

    //The constructor.
    public Eigenvalues(Double[]... array)   {

        super(array);
    }
 
    //eigenvalues getter.
    public double[] getEigenvalues()   {
    
        return this.eigenvalues;
    }
    
    //eigenvalues setter.
    public void setEigenvalues(double[] array)   {
    
        for (int i = 0; i < array.length; i++)   {
        
            this.eigenvalues[i] = array[i];
        }
    }
    
    
    //Pretend that eigenvalue-possessing objects have a different limit to their element size than e.g.
    //invertible objects.  
    public void isItCorrectSize()   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            for (int j = 0; j  < doubleVal.get(i).length; j++)   {
        
                if (doubleVal.get(i)[j].doubleValue() > 500 || doubleVal.get(i)[j].doubleValue() < -500)   {
            
                    System.out.println("\n" + "NOT AN APPROPRIATE ELEMENT VALUE.");
                    this.setGoAhead(0);
                }
            }
        }
    }
    
        
    //Calculate the eigenvalues of the 2 x 2 matrix example.
    public void eigenvalues2D()  {
    
        //The three checks are not sufficient to fail the eigen-calculation, so continue regardless.
        if (this.getGoAhead() != 2)   {
    
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
        
            //Create an object that can perform the eigendecomposition.
            EigenDecomposition eigen = new EigenDecomposition(matrix);
            
            //Save the eigenvalues in an array.
            this.eigenvalues = eigen.getRealEigenvalues();
                        
        } //end 'if true...'
         
        //If goAhead has been set to zero:
        if (this.getGoAhead() == 0)   {
         
            System.out.println("The inversion failed, but the following eigenvalues (for the submitted matrix) are correct.");   
        }
    }
}   

