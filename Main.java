package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.reflect.Array;
 
public class Main   {
 
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
    public static void main(String[] args)    {
        
        
        /*--------------------------------------------------------------------------------*/
        
        //An example array is immediately provided:
        //Ensure dimension is still set to 2.
        Main.setDimension(2, 2);
        
        //Then create the example matrix: array0 is the top row, array1 is the bottom row.
        //(Other methods demand accuracy limited to 5 d.p.).
        Double[] array0 = {0.5, -0.5};
        Double[] array1 = {-0.33333, 0.66666};
        
       
        //Instantiate an object to be inverted, then apply the inverting method.
        //For generality, use StructureInterfaceA type, rather than Invertible.
        StructureInterfaceA invertible = new Invertible(array0, array1);
        
        //These are extra checks that may be performed prior to calculation on Invertible object.
        invertible.isCorrectDimension(2);
        invertible.isItCorrectSize();
        invertible.isCorrectShape();
        invertible.rowZeros(array0, array1);
   
        //If we wish to know the trace:       
        System.out.println("\n" + "The trace of the submitted matrix is   " + MyUtility.theTrace(array0,array1) + ".");       

        //Perform the inversion.  Need to cast because the method isn't listed in StructureInterfaceA.
        ((Invertible)invertible).invert2D();
        
        //Print the matrix a second time, to ensure it is 'saved'.
        double[][] invertedMatrix = ((Invertible)invertible).getInvertedMatrix();
          
        System.out.println("\n");
        
        //(The output matrix elements will all be zero if the inversion fails.)  
        for (int i = 0; i < Main.getDimension()[0]; i++)   {
        
            System.out.println("The matrix after inversion (reported from class Main), row " + (i+1) + ":");
        
            for (int j = 0; j < Main.getDimension()[1]; j++)   {
            
                System.out.println("row " + (i + 1) + "   " + invertedMatrix[i][j]);
            }
        }
        
        /*-------------------------------------------------------------------------------------*/
        
        
        //And now perform an eigendecomposition on the example 2D matrix.  
        //StructureInterfaceB lists 
        StructureInterfaceB eigenObject = new Eigenvalues(array0, array1);
        
        //Check a feature of the matrix.        
        eigenObject.isItCorrectSize();
        
        //Calculate the eigenvalues.
        eigenObject.eigenvalues2D();

        //Bring the eigenvalues over to class Main, and print them out. 
        double[] theEigenvalues = eigenObject.getEigenvalues();
        
        System.out.println("\n");
        
        for (int i = 0; i < Main.getDimension()[0]; i++)   {
        
            System.out.println("The eigenvalue (for the non-inverted matrix)" + (i + 1) + ":  " + theEigenvalues[i] + ". ");
        } 
        
        /*-------------------------------------------------------------------------*/
        
        //And now demonstrate the inversion using generics and reflection.
        //This approach calls a constructor that allows matrices of non-Double elements to be processed.
        Integer[][] aMatrix = {{1,1},{1,2}};
        Invertible inverseTwo = new Invertible(aMatrix, Integer.class, 2);
        inverseTwo.invert2D();
        
        /*-------------------------------------------------------------------------*/
        
        //Now instantiate a summable matrix object, and sum the elements.
        //Matrices of any type that implements Number will work.
        Integer[][] matrix = {{1, 2}, {3, 4}};
       
        //The matrix will be stored and passed in an ArrayList object.
        ArrayList<Integer> initialList = new ArrayList<>();
       
        for (int i = 0; i < matrix.length; i++)   {
       
            for (int j = 0; j < matrix[i].length; j++)   {
           
                initialList.add(matrix[i][j]);
            }
        }
       
        //The number of columns.  This is passed in case added routines require it.
        int width = matrix[0].length;
           
        //Instantiate.
        Summable<Integer> summable = new Summable<>(initialList, width); 
    }      
}
