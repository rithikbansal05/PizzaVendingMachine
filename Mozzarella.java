
/**
 * Write a description of class Mozzarella here.
 * Inherits from the Cheese parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Mozzarella extends Cheese
{

    /**
     * pre-condition: The cheese class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Mozzarella cheese object
     *   by initializing it through constructor of
     *   parent class
     * 
     * @param: none
     * @return: none
     */
    public Mozzarella(){
        super("Mozzarella Cheese",new Money(12,50), 125);
    }
}
