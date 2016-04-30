package gitjavamatrix;

//An interface type to specify any of the properties we want for our square matrix:
//We implement checkSquareArray whenever we demand that a matrix be square n x n.
public interface CheckSquareArray   {

    //Check that the matrix is suitable dimension.
    //n is the matrix's dimension.
    void isCorrectDimension(int n);
    
    //Check that the matrix is square.
    void isItDouble();
    
    //Check that the matrix is square.
    void isSquare();
    
    //At a later date, added a default method that warns if a row is all zeros.
    //Assume an accuracy of 5 d.p. on our provided values.
    //Note that identical instance methods will take precedence.
    default public void rowZeros(Double[]... array)   {
    
        for (int i = 0; i < array.length; i++)   {
        
            Double sum = 0.0;
        
            for (int j = 0; j < array[i].length; j++)   {
            
                sum = sum + array[i][j]; 
            }
            
            if (sum < 0.000001)    {
            
                System.out.println("Warning:  You've a row that's all zeros.");
            }
        }
    }
}

