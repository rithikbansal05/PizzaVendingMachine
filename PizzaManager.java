import java.util.Scanner;

/**
 * Main file. THis will control the user input and 
 * produce the relevant output.
 *
 * @author (Rithik Bansal)
 * @version (3/4/18)
public class PizzaManager {
    //declaring instance variables
    private ArrayList<Pizza> pizzaHolder = new ArrayList<Pizza>();

    //not required for assignment, but it improves efficiency
    //private int indexCount = 0;

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     * 
     * pre-condition: the relveant classes and instance variables have
     *  been declared as required
     *  
     *  post-condition: tests the methods to add pizzas, eat from it and 
     *   sort it.
     *   
     * @param: none
     * @return: none
     */
    public void start() {
        char selection='d';

        A: while(selection != 'q' || selection != 'Q') {
            Scanner foo = new Scanner(System.in);
            System.out.println("Make your choice");
            String choice = foo.nextLine();
            selection = choice.charAt(0);

            //foo.nextChar() doesn't exist, so now what?
            switch(selection) {
                case 'A':    
                case 'a':    
                System.out.println(
                    "Adding a random pizza to the ArrayList<Pizza>.");
                try{
                    //Pizza ranPizza = new Pizza();
                    //pizzaHolder.insert(ranPizza,0);
                    addRandomPizza();
                } catch(PizzaException e){
                    System.out.println(e.getMessage());
                }
                displayAllPizzas();
                displayInstructions();
                break;

                case 'H':    
                case 'h':    
                System.out.println(
                    "Adding one hundred random pizzas to the ArrayList<Pizza>.");
                try{
                    for(int i=1; i <= 100; i++){
                        //Pizza ranPizza = new Pizza();
                        //pizzaHolder.insert(ranPizza,indexCount++);
                        addRandomPizza();
                    }
                } catch(PizzaException e){
                    System.out.println(e.getMessage());
                }
                displayAllPizzas();
                displayInstructions();
                break;                    

                case 'E':    
                case 'e':    
                System.out.println(
                    "Eating a fraction of a pizza. How much? (a/b)");
                eatSomePizza(foo);
                displayAllPizzas();
                displayInstructions();
                break;            

                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                sortByPrice();
                displayAllPizzas();
                displayInstructions();
                break;    

                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                sortBySize();
                displayAllPizzas();
                displayInstructions();
                break;          

                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                sortByCalories();
                displayAllPizzas();
                displayInstructions();
                break;

                case 'B':
                case 'b':    
                System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.");

                sortByCalories();
                displayAllPizzas();

                System.out.println("What calorie count are you looking for?");

                int cal = foo.nextInt();
                int index = binarySearchByCalories(cal);

                if(index != -1) 
                    System.out.println("Pizza with calorie count " +cal+ 
                        " was found at index " +index);
                else
                    System.out.println("Pizza with calorie count " +cal+ 
                        " not found in the list.");

                displayInstructions();        
                break;
                
                case 'D':
                case 'd': sortByBubble();
                displayAllPizzas();
                break;

                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                break A;

                default:    System.out.println("Unrecognized input - try again");
                break;
            }
        }

    } 

    /**
     * 
     * DISCLAIMER: If you try to eat pizza with fraction which is 
     *  super close to 1, the price of pizza will indicate 0$ because 
     *   the output has to be within 2dp (although there is still a fraction
     *    of pizza left). So do not try something like 99/100.
     *    
     * pre-condition: pizza class has been declared properly
     *  and its methods work
     * 
     * post-condition: eats a fraction of the pizza. Removes it if
     *  reached 0, throws error if size goes below 0.
     * 
     * @return:  none
     * @param:  Scanner
     */
    private void eatSomePizza(Scanner keys) {

        try{

            //System.out.println("What Fraction of pizza do you want to eat?");
            String fraction = keys.nextLine();
            String[] splitFrac = fraction.split("/");

            int num = Integer.parseInt(splitFrac[0]);
            int den = Integer.parseInt(splitFrac[1]);

            System.out.println("The index of pizza you want to eat: ");
            int index = keys.nextInt();
            String junk = keys.nextLine();        

            Fraction eatFrac = new Fraction(num,den);
            Pizza eatPizza = pizzaHolder.get(index);

            Fraction remFrac = eatPizza.getRemaining();
            eatPizza.eatSomePizza(eatFrac);

            if(eatPizza.getRemaining().getNumerator() == 0 ){
                pizzaHolder.remove(index);
                //indexCount--;
                System.out.println("Pizza finished and removed from list.");
                System.out.println(eatPizza.toString());
            } else
                System.out.println(eatPizza.toString());

        } catch(IllegalArgumentException e){
            System.out.println("No pizza at that index.");
            System.out.println("Possible error: Fraction has to have int values.");
        } catch(PizzaException e){
            System.out.println(e.getMessage());
        } 
    }

    /**
     * pre-condition: arraylist class works 
     * 
     * post-condition: add a ranom pizza to the arraylist
     *  instance variable
     * 
     * @return: none
     * @param: none
     */
    private void addRandomPizza() throws PizzaException{
        Pizza newPizza = new Pizza();
        pizzaHolder.insert(newPizza,0);    
        //indexCount++;
    }

    /**
     * pre-condition: the tostring in arraylist works
     * 
     * post-condition: prints all the pizzas in the list
     *  onto the output screen
     * 
     * @return: none
     * @param: none
     */
    private void displayAllPizzas() {
        System.out.println(pizzaHolder.toString());
    }

    /**
     * pre-condition: compareTo() has been declared and
     *  works
     * 
     * post-condition: sorts pizza in the arraylist based on price
     * 
     * @return: none
     * @param: none
     */
    private void sortByPrice() {  

        for(int i=0; i < pizzaHolder.size()-1; i++){            
            Pizza maxPricePiz = (Pizza) pizzaHolder.get(i);
            int index = -1;
            for(int j=i+1;j<pizzaHolder.size();j++){
                if(maxPricePiz.compareTo(pizzaHolder.get(j)) 
                > 0){
                    maxPricePiz = (Pizza) pizzaHolder.get(j);
                    index = j;
                }
            }

            if(index!=-1)
                pizzaHolder.swap(i,index);
        }
    }
    
    public void sortByBubble(){
        int l = pizzaHolder.size();
        for(int i =0; i<l-1; i++){
            
            for(int j=0; j<l-i-1;j++){
                if(pizzaHolder.get(j).compareTo(pizzaHolder.get(j+1)) > 0)
                    pizzaHolder.swap(j,j+1);

            }
        }
    }

    /**
     * pre-condition: compareToBySize() has been declared and
     *  works
     * 
     * post-condition: sorts pizza in the arraylist based on size
     * 
     * @return: none
     * @param: none
     */
    private void sortBySize() {
        for(int i=1; i < pizzaHolder.size(); i++){            
            Pizza maxSizPiz = (Pizza) pizzaHolder.get(i);
            int index = i;

            while(index > 0 
            && pizzaHolder.get(index-1).compareToBySize(maxSizPiz) < 0){
                //pizzaHolder.insert(pizzaHolder.get(index),index+1);
                pizzaHolder.swap(index,index-1);
                index -= 1;
            }

        }
    }

    /**
     * pre-condition: compareToByCalories has been decalred and works
     *  
     * post-condition: sorts the pizza in this arrylist based on calories
     * 
     * @return: none
     * @param: none
     */
    private void sortByCalories() {

        for(int i=0; i < pizzaHolder.size()-1; i++){            
            Pizza maxCalPiz = (Pizza) pizzaHolder.get(i);
            int index = -1;
            for(int j=i+1;j<pizzaHolder.size();j++){
                if(maxCalPiz.compareToByCalories(pizzaHolder.get(j)) 
                < 0){
                    maxCalPiz = (Pizza) pizzaHolder.get(j);
                    index = j;
                }
            }

            if(index!=-1)
                pizzaHolder.swap(i,index);
        }
    }

    /**
     * pre-condition: the helper method has been decalred
     *  and works
     * 
     * post-condition: returns the index at which the target pizza
     *  is found. 
     * 
     * @return: int
     * @param: int
     */
    private int binarySearchByCalories(int cals) {
        //sortByCalories();
        int start = 0;
        int end = pizzaHolder.size()-1;
        if(pizzaHolder.get(start).getCalories() == cals) return start;
        else if (pizzaHolder.get(end).getCalories() == cals) return end;
        else
            return binSrchByCalHelper(cals,start,end);

    }

    /**
     * pre-condition: nothing specific. 
     * 
     * post-condition: uses recursion to find the target value
     *  using binary search
     * 
     * @return: int
     * @param: int, int , int
     */
    private int binSrchByCalHelper(int cals,int start, int end){
        if(start == end && pizzaHolder.get(start).getCalories() == cals) return start;
        else if(start>end) return -1;
        else{
            int mid = (start + end) /2;
            if(cals == pizzaHolder.get(mid).getCalories()) return mid;
            else if(cals > pizzaHolder.get(mid).getCalories())  
                return binSrchByCalHelper(cals,start,mid-1);
            else if(cals < pizzaHolder.get(mid).getCalories() )    
                return binSrchByCalHelper(cals,mid+1,end);

        }

        return -1;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    /**
     * pre-condition: the instructions string has been declared
     * 
     * post-condition: prints it to the screen everytime its called
     * 
     * @return: none
     * @param: none
     */
    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /**
     * pre-condition: all the relevant methods have been decalred
     *  and work.
     * 
     * post-condition: main method which calls on other method
     *  which indirectly tests everything.
     * 
     * @return: none
     * @param: String[]
     */
    public static void main(String[] args) {
        System.out.println(instructions);
        new PizzaManager().start();
    }

    /** I MADE THIS testDriver() method if Driver is being graded separately than
     *  the pizza manager (since the pizza manager and driver are graded separately)
     *  I am not adding this in the main method. Run it separtely if you want to 
     *   test it. 
     *  
     * pre-condition: other methods have been declared and work
     * 
     * post-condition: tests the methods from other classes.
     *  Acts as the a secondary driver. 
     *  
     *  @param: none
     *  @return: none
     */
    public static void testDriver(){
        try{
            PizzaManager tmp = new PizzaManager();
            
            Pizza tempPizza = new Pizza();
            Pizza tempPizza2 = new Pizza();
            
            System.out.println(tempPizza.toString());
            System.out.println(tempPizza2.toString());
            
            tmp.pizzaHolder.insert(tempPizza, 0);
            tmp.pizzaHolder.insert(tempPizza2, 0);
            
            //only try proper integer fraction
            System.out.println("What fraction do you want to eat? a/b");
            Scanner keys = new Scanner(System.in);
            tmp.eatSomePizza(keys);
            
            System.out.println(
                "On comparing based on price: " +
                    tempPizza.compareTo(tempPizza2));
                
            System.out.println(
                "On comparing based on Size: " +
                    tempPizza.compareToBySize(tempPizza2));  
            
            System.out.println(
                "On comparing based on Calories: " +
                    tempPizza.compareToByCalories(tempPizza2));    
            
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
