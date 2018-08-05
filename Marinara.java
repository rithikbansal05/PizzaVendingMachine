
/**
 * Write a description of class Marinara here.
 * Inherits from the Base parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Marinara extends Base
{

    /**
     * pre-condition: The Base class ahas been 
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
    public Marinara(){
        super("Marinara Base",new Money(13,49), 175);
    }
}
