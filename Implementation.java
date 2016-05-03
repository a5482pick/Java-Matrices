package gitjavamatrix;

import org.apache.commons.math3.linear.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//Since we may wish to re-use the implementation, we here bring it in to a superclass.
public class Implementation    {

 
    //'goAhead' is a property that's set to zero, if terminate early.
    //The default is to allow the calculation to go ahead regardless.
    private int goAhead = 1;

    //doubleVal is an ArrayList instance where the values for the matrix instance are stored.
    protected List<Double[]> doubleVal = new ArrayList<Double[]>();
    
    //The argument of the CONSTRUCTOR takes n arrays of size n. (i.e. n row arrays.) 
    public Implementation(Double[]... array)   {
    
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
    
        return doubleVal;
    }
    
    //doubleVal setter.
    public void setDoubleVal(Double[]... array)   {
    
        //Add each of the n arrays (of size n) to the ArrayList object.
        for (int i = 0; i < array.length; i++)   {
        
            this.doubleVal.add(array[i]);
        }
    }

    
    //The three methods required by the interface implementation:
    
    //Check that each row is the same length as the number of rows.
    public void isCorrectDimension(int n)   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            if (doubleVal.get(i).length != n)   {
            
                System.out.println("\n" + "Not an appropriate matrix dimension.");
                this.setGoAhead(0);
            }
        }
    }
    
    //Let's limit the matrix to elements of magnitude <= 1000.
    public void isItCorrectSize()   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            for (int j = 0; j  < doubleVal.get(i).length; j++)   {
        
                if (doubleVal.get(i)[j].doubleValue() > 1000 || doubleVal.get(i)[j].doubleValue() < -1000)   {
            
                    System.out.println("\n" + "NOT AN APPROPRIATE ELEMENT VALUE.");
                    this.setGoAhead(0);
                }
            }
        }
    }

    //Check that the matrix is square.
    public void isCorrectShape()   {
    
        for (int i = 0; i < doubleVal.size(); i++)   {
        
            if (doubleVal.get(i).length != doubleVal.size())   {
            
                System.out.println("Not a square matrix.");
                this.setGoAhead(0);
            }
        }
    }
}      


