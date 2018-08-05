import java.awt.*;
/**
 * Write a description of class Vegetable here.
 * Inherits methods from the Ingredients class.
 * Adds a few more of its own methods. It will be
 * extended eventually by Olive and Pepper class
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Vegetable extends Ingredient
{
    //declaring a color instance variable
    private Color vegColor;

    /**
     * pre-condition: Ingredient class has been extended
     * 
     * post-condition: calls the constructor of the 
     *  parent class
     * 
     * @param: String, Money, int
     * @return: none
     */
    public Vegetable(String desc, Money cost, int cal){
        super(desc,cost,cal);
        
        //initializing the variable to keep the compiler and me happy
        vegColor = Color.BLUE;
    }
    
    /**
     * pre-condition: Ingredient class has been extended
     * 
     * post-condition: calls the constructor of the 
     *  parent class
     * 
     * @param: String, Money, int
     * @return: none
     */
    public Vegetable(String desc, Money cost, int cal, Color col){
        super(desc,cost,cal);
        vegColor = col;
    }

    /**
     * pre-conditon: relevant COlor imports ahve been made
     * 
     * post-condition: reutnrs the color object of the vegColor
     * 
     * @param: none
     * @return: Color
     */
    public Color getColor(){
        return this.vegColor;
    } 

    /**
     * pre-conditon: relevant COlor imports ahve been made
     *  Instance variable has been decalred
     * 
     * post-condition: sets the instnace variable with passed
     *  in arg  value
     * 
     * @param: Color
     * @return: none
     */
    public void setColor(Color a){
        this.vegColor = a;
    } 

    /**
     * pre-conditon: other methods are decalred and work fine
     * 
     * post-condition: returns a string impression of the vegetable
     *  ingredient
     * 
     * @param: none
     * @return: string
     */
    @Override
    public String toString(){
        String retVal = "";
        retVal = super.toString() +". The color is " +vegColor.toString();//this.getColor();
        return retVal;
    }

    /**
     * pre-conditon: other methods are decalred and work fine
     * 
     * post-condition: compares teh current ingredient with the passed
     *  in ingredient. Returns a boolean accordingly
     * 
     * @param: Object
     * @return: boolean
     */
    @Override
    public boolean equals(Object o){
        if(o != null && this.getClass() == o.getClass()){
            Vegetable obj = (Vegetable) o;

            if(this.vegColor.equals(obj.getColor())){
                return super.equals(obj);
            }
        } 

        return false;
    }
}
