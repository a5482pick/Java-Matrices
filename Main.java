package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;

 
public class Main   {
 
    //The entry point.
    public static void main(String[] args)    {
        
        //An example array is immediately provided:
        //array0 is the top row of a 2 x 2 matrix, array1 is the bottom row.
        Double[] array0 = {0.5, -0.5};
        Double[] array1 = {-0.33333, 0.66666};
        
        //Instantiate an object to be inverted, then apply the inverting method.
        Inverse inverse = new Inverse(array0, array1);
        inverse.invert2D();
    }
}
