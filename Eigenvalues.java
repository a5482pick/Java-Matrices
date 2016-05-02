package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


//A class to find the eigenvalues of n x n matrix.
public class Eigenvalues implements StructureInterfaceA  {


    //'goAhead' is a property that's set to zero, if terminate early.
    //The default is to allow the calculation to go ahead regardless.
    private int goAhead = 1;
    
    //An instance variable to store the eigenvalues.
    private double[] eigenvalues = {0,0}; 

    //doubleVal is an ArrayList object where the values for the matrix instance are stored.
    private List<Double[]> doubleVal = new ArrayList<Double[]>();
    
    
    //The argument of the CONSTRUCTOR takes n arrays of size n. (i.e. n row arrays.) 
    public Eigenvalues(Double[]... array)   {
    
        //Add each of the n arrays (of size n) to the ArrayList object.
        for (int i = 0; i < array.length; i++)   {
        
            this.doubleVal.add(array[i]);
        }
    }
    
    
    //goAhead getter.
    public int getGoAhead()   {
    
        return goAhead;
    }
    
    //goAhead setter.
    public void setGoAhead(int i)   {
    
        this.goAhead = i;
    }
    
    //doubleVal getter.
    public List<Double[]> getDoubleVal()   {
    
        return this.doubleVal;
    }
    
    //doubleVal setter.
    public void setDoubleVal(Double[]... array)   {
    
        //Add each of the n arrays (of size n) to the ArrayList object.
        for (int i = 0; i < array.length; i++)   {
        
            this.doubleVal.add(array[i]);
        }
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
    
    
    /*---------------------------------------------------------------------------------*/
    
    //The three methods required by the interface implementation:
    
    //Check that each row is the same length as the number of rows.
    public void isCorrectDimension(int n)   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            if (doubleVal.get(i).length != n)   {
            
                System.out.println("Not an appropriate matrix dimension.");
                this.setGoAhead(0);
            }
        }
    }
    
    //Let's limit the matrix to elements of magnitude <= 1000.
    public void isItCorrectSize()   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            for (int j = 0; j  < doubleVal.get(i).length; j++)   {
        
                if (doubleVal.get(i)[j].doubleValue() > 1000)   {
            
                    System.out.println("Not an appropriate element type.");
                    this.setGoAhead(0);
                }
            }
        }
    }

    //Check that the matrix is square.
    public void isSquare()   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            if (doubleVal.get(i).length != doubleVal.size())   {
            
                System.out.println("Not a square matrix.");
                this.setGoAhead(0);
            }
        }
    }
    
    
    /*--------------------------------------------------------------------------------------*/

    //Calculate the eigenvalues of the 2 x 2 matrix example.
    public void eigenvalues2D()  {
    
        if (this.getGoAhead() != 0)   {
      
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
        
        else   {
        
            //If goAhead has been set to zero:
            System.out.println("The calculation has not proceeded, because the checking methods were called.");
        }
    }
}   

