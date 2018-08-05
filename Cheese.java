
/**
 * Write a description of class Cheese here.
 * Inherits methods from the Ingredients class.
 * Adds a few more of its own methods. It will be
 * extended eventually by Goat and Mozarella class
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Cheese extends Ingredient
{

    /**
     * pre-condition: Ingredient class has been extended
     * 
     * post-condition: calls the constructor of the 
     *  parent class
     * 
     * @param: String, Money, int
     * @return: none
     */
    public Cheese(String desc, Money cost, int cal){
        super(desc,cost,cal);
    }
}
