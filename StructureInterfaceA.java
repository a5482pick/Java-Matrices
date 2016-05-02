package gitjavamatrix;

//An interface type that specifies our fundamental properties for our matrix-like structures:
//These are matrix dimension and shape, and element size and accuracy.
public interface StructureInterfaceA   {

    //Check that the matrix is suitable dimension.
    //n is the matrix's dimension.
    void isCorrectDimension(int n);
    
    //Check that the matrix elements are in required size bounds.
    void isItCorrectSize();
    
    //Check that the matrix is square.
    void isSquare();
    
    //At a later date, added a default method.
    //This default method issues a warning, when a row is all zeros to an accuracy of 5 d.p.
    //Override this method if want different accuracy levels.
    default public void rowZeros(Double[]... array)   {
        
        //If this is still false after checks, issue no warning.
        boolean issueWarning = false;
        
        for (int i = 0; i < array.length; i++)   {
                   
            //This will set to false if a row has a non-zero number.
            boolean failedTest = true;
        
            for (int j = 0; j < array[i].length; j++)   {
            
                //If any num on the row is non-zero, can proceed without warning.
                if (array[i][j] > 0.000001 || array[i][j] < -0.000001)   {
                
                    failedTest = false;
                }
            }
            
            if (failedTest)   {
            
                issueWarning = true;
            }
        }
        
        if (issueWarning)   {
         
            System.out.println("You've a non-zero row.");
        } 
    }
}

