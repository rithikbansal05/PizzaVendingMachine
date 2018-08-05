/**
 * Write a description of class Money here.
 * 
 * This class is used to keep track of money
 * in USD currency through use of 2 variables:
 * 1 for dollars and 1 for cents.
 *
 * Rithik Bansal
 * 1/27/18
 */
public class Money implements Comparable, Cloneable
{
    //declaring instance varibales to be used in class
    private int dollars;
    private int cents;

    /**
     * Constructor 1
     * pre-condition: dol is never less than 0.
     * post-condition: initializes the instance variable
     *  dollars to value of dol. If value of dol is negative
     *  dollars is initialized to 0.
     */
    public Money(){
        this.dollars = 0;
        this.cents = 0;
    }
    
    /**
     * Constructor 1
     * pre-condition: dol is never less than 0.
     * post-condition: initializes the instance variable
     *  dollars to value of dol. If value of dol is negative
     *  dollars is initialized to 0.
     */
    public Money(int dol){
        //checks if dol value is non-negative
        if(dol >= 0)
            this.dollars = dol;
        else {
            System.out.println("\nDollars has to be positive integer");
            System.out.println("Initialized dollars to 0.\n");
            this.dollars = 0;
        }
    }

    /**
     * Constructor 2
     * pre-condition: dol and cent have non - negative
     *  values. cent has a value of less than 100.
     * post-condition: initializes the instance variables to
     *  the value of dol and cents if preconditions are true.
     *  Otherwise, they are set to 0. 
     */
    public Money(int dol, int cent){

        //checks if dol value is non-negative
        //checks if cent value is between 0-99
        if(dol >= 0 && (cent >= 0 && cent < 100)){
            this.dollars = dol;
            this.cents = cent;

        } else {
            System.out.println("Values out of bound. Try again!");
            System.out.println("Resetting price to 0\n");
        }

    }

    /**
     * Constructor 3
     * pre-condition: the value of dollars and cents for 
     *  object of Money other are non-negative. The cents value is
     *  less than 100. The money object "other" is not null and is an
     *  instance of Money class.
     * post-condition: initializes the instance variables to
     *  the value of dol and cents if preconditions are true.
     *  Otherwise, they are set to 0. 
     *  (I tried calling the previous 
     *  constructor in this one. However, that can only be called
     *  in the first statement and i need to 
     *  check whether the money object is 
     *  null or non-null to proceed.)
     */
    public Money (Money other){
        this(other.dollars, other.cents);
    }

    /**
     * pre-condition: value of dollars is non-negative.
     * post-condition: returns the current value of
     *  dollars instance variable. 
     *  
     *  @return: int value from dollars instance variable
     */
    public int getDollars(){
        return this.dollars;
    }

    /**
     * pre-condition: value of dollars is non-negative and
     *  less than 100
     * post-condition: returns the current value of
     *  cents instance variable. 
     *  
     *  @return: int value from cents instance variable
     */
    public int getCents(){
        return this.cents;
    }

    /**
     * pre-condition: value of dollars is non-negative.
     * post-condition: updates the dollars instance variable
     *  with the value in dol, given the preconsitions are met.
     */
    public void setDollars(int dol){

        //updates value of dollars only if 
        // value of dol is non-negative
        if(dol >= 0) {
            this.dollars = dol;
        } else {
            System.out.println("Input has to be a positive int.");
            System.out.println("Dollars value not updated\n");
        }    
    }

    /**
     * pre-condition: value of dollars is non-negative.
     * post-condition: updates the dollars instance variable
     *  with the value in dol, given the preconsitions are met.
     */
    public void setCents(int cent){

        //updates value of cents only if 
        // value of cent is between 0-99.
        if(cent >= 0 && cent < 100){
            this.cents = cent;
        } else {
            System.out.println("Value has to be int value b/n 0-99.");
            System.out.println("Cents value not updated\n");
            //System.exit(0);
        }
    }

    /**
     * pre-condition: value of dollars and cents is non-negative.
     *  cents is also within the range of 0-99.
     * post-condition: if pre-conditions are true, 
     *  returns a double type
     *  value of the total money.
     *  
     *  @return: double value of total money
     */
    public double getMoney(){
        double totalMoney;

        //creating a copy of the value of instance variables
        //with correct types
        int dol = this.dollars;
        double cent = this.cents/(double)100;

        totalMoney = cent + dol;

        return totalMoney;
    }

    /**
     * pre-condition: value of dol and cent is non-negative.
     *  value of cent is within 0-99
     * post-condition: If preconditions met, the value of instance
     *  variables dollars and cents is set 
     *  to the value of dol and cent.
     */
    public void setMoney(int dol, int cent){

        //updates value of dollars and cents if 
        //dol and cent values are non-negative and
        //cent values are between 0-99
        if(dol >= 0 && (cent >= 0 && cent < 100)){
            setDollars(dol);
            setCents(cent);
        } else {
            System.out.println(
                "Parameters values do not fit requirement");
            System.out.println(
                "Dollar has to be positive integer and"); 
            System.out.println(
                "  cent has to be a positive integer between 0-99");
            System.out.println(
                "Try again! Dollars and cents was not updated\n");

        }
    }

    /**
     * pre-condition: dol is never less than 0.
     * post-condition: If pre-conditions are met, 
     *  the value of dol is added to the current value of
     *  the instance variable dollars.
     */
    public void add(int dol){

        //if value of dol is non-negative then it
        //adds it to the existing dollars value
        if(dol >= 0){
            this.dollars += dol;
        } else {
            System.out.println("Input has to be a positive int.");
            System.out.println("Dollars was not updated\n");
            //System.exit(0);
        }
    }

    /**
     * pre-condition: dol and cents are never less than 0.
     *  value of parameter cents is within 0 - 99
     * post-condition: If pre-conditions are met, 
     *  the value of dol is added to the current value of
     *  the instance variable dollars. the value of parameter
     *  cents is added to the instance variables cents. If
     *  this.cents exceeds 100, this.dollars is updated to keep
     *  cents within 0-99
     */
    public void add(int dol, int cents){

        //if dol and cents are non negative and cents 
        //is between 0-99.
        if(dol >= 0 && (cents >= 0 && cents < 100)){
            this.dollars += dol;
            this.cents += cents;

            //accounts for the case where the current value of
            //cents has exceeded 99
            if(this.cents > 99){
                this.cents -= 100;
                this.dollars += 1;
            }
        } else {
            System.out.println(
                "Parameters have values that do not fit requirement");
            System.out.println(
                "Dollar has to be positive integer and"); 
            System.out.println(
                "    cent has to be a positive integer between 0-99");
            System.out.println(
                "Try again! Dollars and cents was not added\n");

        }
    }

    /**
     * pre-condition: the object "other" is not null. the value of
     *  dollars and cents of the money object 
     *  "other" are non-negative and cents is within 0 - 99.
     * post-condition: If pre-conditions are met, the value of
     *  dollars and cents of the money object "other" is added to the
     *  currrent value of this.dollars and this.cents. If
     *  this.cents exceeds 100, this.dollars is updated to keep
     *  cents within 0-99
     */
    public void add(Money other){

        //checks if other parameter is non null
        if(other != null){

            //checks if the value of dollars and cents for Money  
            //other is non-negative and cents value is between 0-99
            if(other.dollars >= 0 && 
                    (other.cents >= 0 && other.cents < 100)){
                this.dollars += other.dollars;
                this.cents += other.cents;

                //accounts for the case where the current value of
                //cents has exceeded 99
                if(this.cents > 99){
                    this.cents -= 100;
                    this.dollars += 1;
                }

            }

        } else {
            System.out.println(
                "The Money parameter has a null value\n");
        }
    }

    /**
     * pre-condition: the Object other is an isntance of Money class
     *  and is not null.
     * post-condition: If pre-conditions are met, the method returns a 
     *  boolean value based on the comparison between the current 
     *  value of instance variables dollars and cents 
     *  with value of dollars and cents from the Money object "other"
     *  , respectively. If both are met, it returns true, else false.
     *  @return: boolean value based on the comaprison
     */
    public boolean equals(Object other){
        boolean comparisonStatus = false;

        //checks if Object other is non null and an 
        //instance of Money class
        if(other != null && other instanceof Money){
            Money obj = (Money) other;

            //compares individual dollars and cents value
            if(getDollars() == obj.getDollars() && 
                            getCents() == obj.getCents())
                comparisonStatus = true;

        } else {
            System.out.println(
                "Object variable is null or not a Money object\n");
            //System.exit(0);
        }

        return comparisonStatus;
    }

    /**
     * pre-condition: the method getMoney() is working and executing
     *  successfully.
     * post-condition: if pre-conditions are met, the 
     *  method returns a string impression of the total 
     *  money (dollars and cents combined).
     *  with the $ sign in front.
     *  @return: String impression of the MOney object
     */
    public String toString(){

        //ensures that the value is being stored in 2 decimal place
        String moneyValue = String.format("$%.2f", getMoney());

        return moneyValue;
    }
    
    /**
     * pre-condition: Comparable interface has been implemented
     * 
     * post-condition: compares the current date object with the 
     * one being passed in. Returns -2 if the object passed in is 
     *  not of Money class. 
     *  
     *  @param: Object other
     *  @return: int
     */
    @Override
    public int compareTo(Object other){
        
        //checks if the passed object is of current class.
        //if not returns -2
        if(other == null || getClass() != other.getClass()){
            System.out.print("Object passed in has to be of Money class.: ");
            return -2;
        }
        
        //declaring possible return ints. FInal cause these are the only
        //possible values that are expected to be returned
        final int neg = -1;
        final int zer = 0;
        final int pos = 1;
        
        //typecasting the passed argument to current class object
        Money obj = (Money) other;
        
        //checks for dollars aspect for being less
        if(this.dollars < obj.getDollars()){
            return neg;
        }
        //checks for dollars aspect for being equal
        else if(this.dollars == obj.getDollars()){
            //checks for cents aspect for being less
            if(this.cents < obj.getCents()){
                return neg;
            } 
            //checks for cents aspect for being equal
            else if(this.cents == obj.getCents()){
                return zer;
            }
            //checks for cents aspect for being more
            else
                return pos;
        } 
        //checks for dollars aspect for being more
        else
            return pos;

    }
    
    /**
     * pre-condition: cloneable interface has been implemented
     * 
     * post-condition: calls the clone from the inherited interface
     * 
     * @return: object of type Money
     * @param: none
     */
    @Override
    public Money clone() throws CloneNotSupportedException{
        
        //uses the clone from the inherited method and typecasts it
        //to current class object before returning it
        return (Money)super.clone();
    }
}
