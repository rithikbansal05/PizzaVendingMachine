import java.awt.Color;
import java.util.Random;
/**
 * Write a description of class Pizza here.
 * Creates a random pizza with random ingredients
 *  and shape. But ensures it has 1 cheese and base.
 *  
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
 */
public class Pizza implements PizzaComparable
{
    //decalring the instance variables
    private ArrayList<Ingredient> ingList = new ArrayList<Ingredient>();
    private int combCal = 0;
    private Money totCost = new Money(0,0);
    private Shape myShape = new Circle();
    private Fraction remPizza = new Fraction();

    /**
     * pre-conditon: no arg constructors
     * 
     * post-condition: initializes the instance variables
     *  to random ingredients and adds it to the pizza.
     *  Indirectly, updates the price and calories
     * 
     * @param: none
     * @return: none
     */
    public Pizza() throws PizzaException{ 
        Random ranNum = new Random();

        Ingredient tmpBa;
        Ingredient tmpCh;
        Ingredient tmpMt;
        Ingredient tmpVg;
        Shape tmpShape;

        if(ranNum.nextInt(2) == 1){
            tmpBa = new Marinara();            
        } else
            tmpBa = new Alfredo();

        addIngredient(tmpBa);    

        if(ranNum.nextInt(2) == 1){
            tmpCh = new Goat();            
        } else
            tmpCh = new Mozzarella();

        addIngredient(tmpCh);

        if(ranNum.nextInt(3) == 2){
            tmpMt = new Pepperoni();  
            addIngredient(tmpMt);
        } else if(ranNum.nextInt(3) == 1)
        {
            tmpMt = new Sausage();
            addIngredient(tmpMt);
        }

        if(ranNum.nextInt(3) == 2){
            tmpVg = new Pepper();   
            addIngredient(tmpVg);
        } else if(ranNum.nextInt(3) == 1){
            tmpVg = new Olive();
            addIngredient(tmpVg);
        }

        if(ranNum.nextInt(2) == 1){
            tmpShape = new Square();        
        } else
            tmpShape = new Circle();

        myShape = tmpShape;
    } 

    /**
     * pre-conditon: the remPizza instance variable has been declared
     * 
     * post-condition: returns a fraction which indicates the remaining
     *  fraction of the pizza
     * 
     * @param: none
     * @return: Fraction
     */
    public Fraction getRemaining(){
        return new Fraction(remPizza.getNumerator(),remPizza.getDenominator());
    }

    /**
     * pre-conditon: remPizza instance variable has been declared
     * 
     * post-condition: setting the fraction remPizza with 
     *  passed in argument
     * 
     * @param: Fraction
     * @return: none
     */
    public void setRemaining(Fraction f){
        this.remPizza = f;
    }

    /**
     * pre-conditon: instance variable has been declared
     * 
     * post-condition: returns an int value stored in
     *  the calories instnace variable
     * 
     * @param: none
     * @return: int
     */
    public int getCalories(){
        return this.combCal;
    }

    /**
     * pre-conditon: totCost instnace variable decalred
     * 
     * post-condition: returns a new Money object with data same
     *  as that in the totCost
     * 
     * @param: none
     * @return: Money
     */
    public Money getCost(){
        return new Money(this.totCost.getDollars(),this.totCost.getCents());
    }

    /**
     * pre-conditon: instance variable declared. getRemaining() works
     *  uses getArea() method from the Shape's child class respectively
     * 
     * post-condition: returns the double value of the remaining area 
     *  of the pizza
     * 
     * @param: none
     * @return: double
     */
    public double getRemainingArea(){
        double calc = (double)myShape.getArea() * ((double)remPizza.getNumerator()/
                (double)remPizza.getDenominator());

        String val = String.format("%.2f", (calc));
        double retVal = Double.parseDouble(val);
        return retVal;    
    } 

    /**
     * pre-conditon: shape instance variable declared
     * 
     * post-condition: sets the instance variable with the 
     *  passed in argument.
     * 
     * @param: Shape
     * @return: none
     */
    public void setShape(Shape s){
        this.myShape = (Shape)s.clone();
    }

    /**
     * pre-conditon: shape isntance variable decalred
     * 
     * post-condition: it is the getter for the Shape
     *  instance variable
     * 
     * @param: none
     * @return: Shape
     */
    public Shape getShape(){
        return (Shape)myShape.clone();
    } 

    /**
     * pre-conditon: Arraylist with Ingredient object
     * 
     * post-condition: updates totCost and totCal based on the 
     *  ingredients passed in as the argument.
     *  
     *  It makes sure that the specific ingreient sub class
     *   is being passed in but not the base,cheese.......
     * 
     * @param: Ingredient
     * @return: none
     */
    public void addIngredient(Ingredient a) throws PizzaException{
        if(a == null)
            throw new PizzaException("Cannot add un-defined ingredient");

        //declaring temporary objects for non-specific Ingredient classes
        //purpose to make sure that only specific ingredients are being added
        Ingredient tmpIng = new Ingredient();
        Base tmpBa = new Base("a", new Money(0,0),0);
        Cheese tmpCh = new Cheese("a", new Money(0,0),0);
        Meat tmpMt = new Meat("a", new Money(0,0),0);
        Vegetable tmpVg = new Vegetable("a", new Money(0,0),0,new Color(0,0,0)); 

        //the if statement ensures that only specific Ingredients are added and not
        // objects of class base, meat, cheese, vegetable and ingredient
        if(a.getClass() != tmpBa.getClass() || a.getClass() != tmpIng.getClass() 
        || a.getClass() != tmpMt.getClass() || a.getClass() != tmpCh.getClass() 
        || a.getClass() != tmpVg.getClass() ){
            this.totCost.add(a.getCost());
            this.combCal += a.getCalories();
            ingList.insert(a,0);
        } else
            throw new PizzaException(
                "Cannot add base, meat, cheese or veg. Add specific Ingredients");

    } 

    /**
     * pre-conditon: getRemainig() works.
     * 
     * post-condition: updates the fraction of the pizza from which
     *  the user took a "bite".
     * 
     * @param: Fraction
     * @return: none
     */
    public void eatSomePizza(Fraction amt) throws PizzaException{
        if(amt == null)
            throw new PizzaException("Eating fraction cannot be null.");

        if(remPizza.compareTo(amt) < 0 && remPizza.getNumerator() != 0)
            throw new PizzaException("Remaining pizza less than eating fraction." 
                + "Pizza not eaten.");

        if(amt.getFraction() < 0 )
            throw new PizzaException("Cannot eat a negative amount from Pizza");

        if(remPizza.getNumerator() == 0)
            throw new PizzaException("No more pizza left to eat.");

        int n1 = remPizza.getNumerator();
        int n2 = amt.getNumerator();
        int d1 = remPizza.getDenominator();
        int d2 = amt.getDenominator();

        if(d1 == d2){
            remPizza.setNumerator(n1-n2);
        } else  if(d1 != d2){
            remPizza.setNumerator(n1*d2-n2*d1);
            remPizza.setDenominator(d1*d2);
        }

        if(this.getCost().getCents() != 0){
            int newPriceDol = this.getCost().getDollars() * 
                this.getRemaining().getNumerator()/this.getRemaining().getDenominator();
            int newPriceCents = this.getCost().getCents() * 
                this.getRemaining().getNumerator()/this.getRemaining().getDenominator();

            totCost = new Money(newPriceDol,newPriceCents);
        } else if (this.getCost().getCents() == 0){
            int newPriceDol = this.getCost().getDollars() * 
                this.getRemaining().getNumerator()/this.getRemaining().getDenominator();
            int newPriceCents = 50;

            totCost = new Money(newPriceDol,newPriceCents);
        }

        //to reduce the values of the fraction
        this.remPizza = new Fraction(remPizza.getNumerator(), remPizza.getDenominator());

    }

    /**
     * pre-conditon: PizzaComparable has been implmented
     * 
     * post-condition: returns an int based in the comparison
     *  based on the price
     * 
     * @param: Object
     * @return: int
     */
    @Override //based on price
    public int compareTo(Object o){
        if(o == null || getClass() != o.getClass()){
            System.out.println("Illegal parameters passed.");
            System.out.println("Returning -2: ");            
            return -2;
        } else {
            Pizza obj = (Pizza) o;

            return this.getCost().compareTo(obj.getCost());            
        }
    }

    /**
     * pre-conditon: PizzaComparable has been implmented
     * 
     * post-condition: returns int upon comparing based on 
     *  Size
     * 
     * @param: Object
     * @return: int
     */
    @Override //based on size
    public int compareToBySize(Object o){
        if(o == null || getClass() != o.getClass()){
            System.out.println("Illegal parameters passed.");
            System.out.println("Returning -2: ");
            return -2;
        } else {
            Pizza obj = (Pizza) o;

            Fraction ThisSize = this.getRemaining();
            Fraction ThatSize = obj.getRemaining();

            return ThisSize.compareTo(ThatSize);                      
        }
    }

    /**
     * pre-conditon: PizzaComparable has been implmented
     * 
     * post-condition: returns int upon comparing based on 
     *  Calories
     * 
     * @param: Object
     * @return: int
     */
    @Override //based on calories
    public int compareToByCalories(Object o){
        if(o == null || getClass() != o.getClass()){
            System.out.println("Illegal parameters passed.");
            System.out.println("Returning -2: ");
            return -2;
        } else {
            Pizza obj = (Pizza) o;

            int thisCal = this.getCalories();
            int thatCal = obj.getCalories();

            if(thisCal < thatCal) return -1;
            else if(thisCal > thatCal) return 1;
            else return 0;                       
        }
    }

    /**
     * pre-conditon: the getters for the instnace variables work perfectly
     * 
     * post-condition: returns a string impression of the pizza details
     * 
     * @param: none
     * @return: String
     */
    @Override
    public String toString(){
        String retVal = "";
        retVal = "Pizza has a price: $" +getCost().getMoney()+ " and calories: " 
        +getCalories()+ ", Fraction remaining: " +getRemaining()+ 
        " and area left: " +getRemainingArea()+ " and shape: "
        +myShape.toString();// +"\n" + ingList ;
        return retVal;            
    }
}
