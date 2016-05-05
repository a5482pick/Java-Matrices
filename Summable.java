package gitjavamatrix;

import java.util.ArrayList;

//A class to represent structures whose elements are summable.
//The sum of all matrix elements is calculated.
public class Summable<T extends Number>   {

    //Private variable to store copy of elements.
    private ArrayList<Number> arrayList = new ArrayList<>();

    private double theSum = 0.0;

    //Preserve matrix elements for each instance, while also summing.
    public Summable(ArrayList<T> theElements, int width)    {
    
        for (int i = 0 ; i < theElements.size(); i++)   {
        
            this.theSum = this.theSum + theElements.get(i).doubleValue();   //Calculate sum.

            this.arrayList.add(theElements.get(i));  //Store the instance's elements.
        }
        
        System.out.println("\n" + "The sum of all elements is " + this.theSum + ".");    //Return sum in double format.
    }
}
