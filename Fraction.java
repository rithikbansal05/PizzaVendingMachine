
/**
 * Write a description of class Fraction here.
 * The class initializes the istance variables
 * based on the constructor called.
 * It also has the accesser and mutator methods
 * for the variables.
 * Plus it also has the equals method Override 
 * that checks if the numerator is equal to
 * the numerator of the other fraction.
 * (same goes for the denominator).
 * It also stores the data in the reduced form.
 *
 * Rithik Bansal
 * 1/14/2018
 */
public class Fraction implements Comparable
{
    // instance variables for the numerator and denominator
    private int numerator;
    private int denominator;

    /**
     * pre-conditon: declared the instance variables
     * 
     * post-condition: constructor initializes instance
     *  variable values
     * 
     * @param: none
     * @return: none
     */
    public Fraction()
    {
        numerator = 1;
        denominator = 1;
    }

    /**
     * pre-conditon: declared the instance variables
     * 
     * post-condition: constructor that initializes 
     *  the instance variable
     * 
     * @param: none
     * @return none
     */
    public Fraction(int num, int den){

        //method called which simplifies the 
        //numerator and denominator before updating the 
        //fraction instance varibale values
        reduce(num,den);
    }

    /**
     * pre-condition: obj is non null and an instance
     *  of ArrayList object
     *  
     * post-condition: returns a boolean value based on the 
     * comparison between the arraylist obj in terms of size and 
     * obj at each index
     * @return: boolean
     */
    @Override
    public boolean equals(Object o){
        boolean exist = false;
        if(o!=null && this.getClass() == o.getClass()){
            Fraction user = (Fraction) o;
            if(this.numerator == user.numerator && this.denominator == user.denominator)
                exist = true;
            else
                exist = false;
        }
        return exist;
    }

    /**
     * pre-conditon: isntance variables have been initialized
     * 
     * post-condition: method reduces the numerator and 
     *  denominator to the most simplified value. 
     *  It also considers the negative int cases
     *  and the cases where the numerator is 0
     * 
     * @param: none
     * @return: none
     */
    public void reduce(int num, int den) {
        int number = num;
        int divisor = 1;
        int numerat, denominat;

        //updates num if den bigger than num
        if (den > num) {
            number = den; 
        }

        //for loop to find out the Greatest Common divisor
        //of the num and den
        for (int i = 1; i <= Math.abs(number); i++) {
            if (num % i == 0 && den % i == 0) {
                divisor = i;
            }
        } 

        //simplifies the numerator and denominator
        numerat = num / divisor;
        denominat = den / divisor;       

        //considers the num zero and den non-zero case
        if(num == 0 && den != 0){
            numerat = 0;
            denominat = 1;
        }

        //accounts for both num and den being negative
        if (num < 0 && den < 0) {
            numerat = (Math.abs(num))/divisor;
            denominat = (Math.abs(den))/divisor;
        }

        //accounts for den being negative & num being positive
        if(num > 0 && den < 0){
            numerat = -num/divisor;
            denominat = (Math.abs(den))/divisor;
        }

        //updates the numerator and denominator values
        this.numerator = numerat;
        this.denominator = denominat;
    }

    /**
     * pre-conditon: instance variable initialized
     * 
     * post-condition: returns the int value of 
     *  the numerator
     * 
     * @param: none
     * @return: int value
     */
    public int getNumerator(){
        return this.numerator;
    }

    /**
     * pre-conditon: instance variable initialized
     * 
     * post-condition: returns the int value of 
     *  the denominator
     * 
     * @param: none
     * @return: int 
     */
    public int getDenominator(){
        return this.denominator;
    }

    /**
     * pre-conditon: instance variable initialized
     * 
     * post-condition: sets the numerator value
     * 
     * @param: int
     * @return: none
     */
    public void setNumerator(int num){
        this.numerator = num;
    }

    /**
     * pre-conditon: instance variable declared and initialized
     * 
     * post-condition: returns a double value of the fraction
     * 
     * @param: none
     * @return: double
     */
    public double getFraction(){
        return (double)getNumerator()/(double)getDenominator();
    }

    /**
     * pre-conditon: instance variable initialized
     * 
     * post-condition: sets the denominator value
     * 
     * @param: int
     * @return: none
     */
    public void setDenominator(int num){
        this.denominator = num;
    }

    /**
     * pre-conditon: instance variables declared and 
     *  initialized
     * 
     * post-condition: returns a string impression of the
     *  fraction in format "A/B"
     * 
     * @param: none
     * @return: String
     */
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    /**
     * pre-conditon: implements the Comparable
     * 
     * post-condition: returns an int value based on
     *  the comparison
     * 
     * @param: Object
     * @return: int
     */
    @Override
    public int compareTo(Object o){
        if(o == null || getClass() != o.getClass()){
            System.out.println("Illegal parameters passed.");
            System.out.println("Returning -2: ");
            return -2;
        } else {
            Fraction obj = (Fraction) o;

            double thisFrac = (double) getFraction();
            double thatFrac = (double) obj.getFraction();

            if( thisFrac < thatFrac ) return -1;
            else if(thisFrac > thatFrac) return 1;
            else return 0;
        }
    }
}
