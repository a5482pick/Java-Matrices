package gitjavamatrix;

//An interface to specify any of the properties we want for our square matrix:
//We implement checkSquareArray whenever we demand that a matrix be square n x n.
public interface CheckSquareArray   {

    //Check that the matrix is suitable dimension.
    //n is the matrix's dimension.
    public void isCorrectDimension(int n);
    
    //Check that the matrix is square.
    public void isItDouble();
    
    //Check that the matrix is square.
    public void isSquare();
}

