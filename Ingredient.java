
/**
 * Write a description of class Ingredient here.
 * THis is a general ingredient class which will be
 *  inherited by numerous child classes based on the
 *   Ingredient Hierarchy.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Ingredient implements Comparable
{
    //declaring the required instance variables
    private String description;
    private Money cost;
    private int calories;

    /**
     * pre-conditon: decalred the instance variables
     * 
     * post-condition: initializes the instance variables
     * 
     * @param: none
     * @return: none
     */
    public Ingredient(){
        description = "";
        cost = new Money(0,0);
        calories = 0;
    }

    /**
     * pre-conditon: decalred the instance variables
     * 
     * post-condition: initializes the instance variables
     *  based on the passed arguments
     * 
     * @param: String,Money, int
     * @return: none
     */
    public Ingredient(String description, Money cost, int calories){
        this.description = description;
        this.cost = new Money(cost.getDollars(), cost.getCents());
        this.calories = calories;
    }

    /**
     * pre-conditon: the instance variables ahve been initiaized
     * 
     * post-condition: returns a string impression of the ingredient
     *  object
     * 
     * @param: none
     * @return: String
     */
    @Override
    public String toString(){
        String retVal = "";
        retVal = "Pizza description " +this.description+ " has a calorie count of "
        +this.calories+ ". The cost of the pizza is " +this.cost.toString(); 
        return retVal;
    }

    /**
     * pre-conditon: the instance variable has been
     *  initialized and declared
     * 
     * post-condition: compares the passed argument with the 
     *  current object and return boolean value
     * 
     * @param: Object
     * @return: boolean
     */
    @Override
    public boolean equals(Object o){

        if(o != null && this.getClass() == o.getClass()){
            Ingredient obj = (Ingredient) o;

            if(this.description.equals(obj.getDescription())){
                if(this.cost.equals(obj.getCost())){
                    if(this.calories == obj.getCalories())
                        return true;
                }
            }
        } 

        return false;
    }

    /**
     * pre-conditon: cost has been decalred and iniitialized
     * 
     * post-condition: returns a copy of the current variable
     * 
     * @param: none
     * @return: Money
     */
    public Money getCost(){
        return new Money(this.cost.getDollars(), this.cost.getCents());
    }

    /**
     * pre-conditon: cost has been decalred and iniitialized
     * 
     * post-condition: returns a copy of the current variable
     * 
     * @param: none
     * @return: String
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * pre-conditon: cost has been decalred and iniitialized
     * 
     * post-condition: returns a copy of the current variable
     * 
     * @param: none
     * @return: int
     */
    public int getCalories(){
        return this.calories;
    }

    /**
     * pre-conditon: implemnted Comparable
     * 
     * post-condition: override the compareTo method to 
     *  return an int accordingly
     * 
     * @param: none
     * @return: int
     */
    @Override
    public int compareTo(Object o){
        if(o != null && this.getClass() == o.getClass()){
            Ingredient obj = (Ingredient) o;

            return this.cost.compareTo(obj.getCost());
        } 

        //returning -2 to keep compiler happy
        return -2;
    }

    
    
    //the methods beyond this point should not be allowed to be
    //used by the user so private
    //adding these methods only because the ingredeint heirarchy pdf says so
    /**
     * pre-condition: instance variable decalred and iitialized
     * 
     * post-condition: sets the instance variable with the passed in
     *  argument value
     * 
     * @param: Money
     * @return: none
     */
    private void setCost(Money cost){
        try{
            this.cost = cost.clone();
        } catch(CloneNotSupportedException e){
            System.out.println("setCost() failed. Try again.");
        }
    } 

    /**
     * pre-condition: instance variable decalred and iitialized
     * 
     * post-condition: sets the instance variable with the passed in
     *  argument value
     * 
     * @param: int
     * @return: none
     */
    private void setCalories(int cal){
        this.calories = cal;
    }
}
