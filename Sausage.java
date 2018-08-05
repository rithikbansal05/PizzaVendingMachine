
/**
 * Write a description of class Sausage here.
 * Inherits from the Meat parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Sausage extends Meat
{
    
    /**
     * pre-condition: The Meat class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Sausage Meat object
     *   by initializing it through constructor of
     *   parent class
     * 
     * @param: none
     * @return: none
     */
    public Sausage(){
        super("Sausage meat",new Money(3,99), 60);
    }
}
