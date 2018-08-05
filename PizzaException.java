/**
 * Write a description of class PizzaException here.
 * Creates a custom exception which inherits from
 *  the exception class. 
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class PizzaException extends Exception
{
    /** no-arg constructor
     * pre-condition: relevant class has been inherited
     * 
     * post-condition: invokes no-arg constructor of the
     *  parent class
     * 
     * @return: none
     * @param: none
     */
    public PizzaException(){
        super("ERROR: possibly pizza error.");
    }

    /** COnstructor 2
     * pre-condition: relevant class has been inherited 
     * 
     * post-condition: invokes the parent class constructor
     *  that takes one string parameter.
     * 
     * @return: none
     * @param: none
     */
    public PizzaException(String message){
        super(message);
    }
}
