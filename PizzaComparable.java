/**
 * Interface class
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
public interface PizzaComparable extends Comparable {  
    //Example of interface inheritance

    @Override
    public int compareTo(Object o);   //a.k.a compareToByPrice

    //non-overrides
    public int compareToBySize(Object o); //a.k.a. compareToByAreaLeft
    public int compareToByCalories(Object o);	
}
