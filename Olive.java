import java.awt.Color;

/**
 * Write a description of class Olive here.
 * Inherits from the Vegetable parent class.
 *  Assigns a programmer defined cost and 
 *   calorie count to it.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Olive extends Vegetable
{

    /**
     * pre-condition: The Vegetable class ahas been 
     *  successfully inherited.
     * 
     * post-condition: assigns a random price and
     *  calorie count to the Olive Vegetable object
     *   by initializing it through constructor of
     *   parent class. THis also assigns it the 
     *   relevant color
     * 
     * @param: none
     * @return: none
     */
    public Olive(){
        super("Olive vegetable",new Money(2,50),40,
            Color.RED);
    }
}

