
/**
 * Write a description of class Meat here.
 * Inherits methods from the Ingredients class.
 * Adds a few more of its own methods. It will be
 * extended eventually by Pepperoni and Sausage class
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Meat extends Ingredient
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
   public Meat(String desc, Money cost, int cal){
       super(desc,cost,cal);
    }
}
