
/**
 * Write a description of class Pepperoni here.
 * Inherits from the Meat parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Pepperoni extends Meat
{
    
    /**
     * pre-condition: The Meat class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Pepperoni Meat object
     *   by initializing it through constructor of
     *   parent class
     * 
     * @param: none
     * @return: none
     */
    public Pepperoni(){
        super("Pepperoni meat",new Money(7,49), 110);
    }
}
