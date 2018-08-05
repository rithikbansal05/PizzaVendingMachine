
/**
 * Write a description of class Alfredo here.
 * Inherits from the Base parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Alfredo extends Base
{

    /**
     * pre-condition: The Base class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Alfredo Base object
     *   by initializing it through constructor of
     *   parent class
     * 
     * @param: none
     * @return: none
     */
    public Alfredo(){
        super("Alfredo Base",new Money(11,99), 200);
    }
}
