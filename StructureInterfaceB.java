package gitjavamatrix;

//This interface is specific to square matrices.
//Note that the super-interface defines matrix structures that are more general.
public interface StructureInterfaceB  extends StructureInterfaceA   {

    //These methods specify matrix features when the matrix is square.
    public void eigenvalues2D();
    public double[] getEigenvalues(); 
}
