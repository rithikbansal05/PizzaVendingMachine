
/**
 * Write a description of class Goat here.
 * Inherits from the Cheese parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Goat extends Cheese
{

    /**
     * pre-condition: The cheese class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Goat cheese object
     *   by initializing it through constructor of
     *   parent class
     * 
     * @param: none
     * @return: none
     */
    public Goat(){
        super("Goat Cheese",new Money(10,00), 86);
    }
}
