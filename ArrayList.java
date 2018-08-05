
/**
 * Write a description of class ObjectList here.
 * A class is created to act as the ArrayList
 * It contains methods to add, remove and other
 * related methods from arraylist object.
 *
 * Rithik Bansal
 * 3/1/18
 */
public class ArrayList<TBA extends Comparable> 
{
    //instance variables being used class wide
    private Object[] ArrayList = new Object[1];
    private int numOfElem = 0;

    /**
     * pre-condition: constructor. instance vriables declared
     * 
     * post-condition: initializes the instance variables
     * 
     * @return: none
     * @param: none
     */
    public ArrayList(){
        ArrayList = new Object[1];
        numOfElem = 0;
    }

    /**
     * pre-condition: the parameters need to be passed in the 
     * order i.e. Object first and index after that. 
     * 
     * post-condition: updates the Object type array with the
     * obj at the index passed in. If the index was not empty,
     * the data is moved down the arraylist and then added.
     * It also accounts for the cases where index is more than
     * array length and the cases where the array is empty.
     * 
     * @param: 1 Object param; 1 int param. (obj, index)
     * @return: none
     */
    public void insert(TBA obj, int index) throws PizzaException{

        //if the index is negative or the obj is a null value
        //then it doesnt add it.
        if (index < 0 || obj == null) { 
            throw new PizzaException("Error. Invalid parameters.");
        }

        //updating arraySize value
        int ArraySize = ArrayList.length;
        TBA o = obj;
        //case 1: where index is >= array length
        if(index >= ArraySize){
            Object[] newArrayList = new Object[index + 1];

            //loop to iterate through the array and update 
            //the values in the new array
            for(int i =0; i < ArrayList.length; i++){
                newArrayList[i] = ArrayList[i];
            }

            newArrayList[index] = o;

            //updating the original array
            ArrayList = newArrayList;

            //updating the number of non-null elements
            //in the array
            numOfElem++;
        } 

        //case 2: where index is 1 less than array length and is
        //not null
        if(ArrayList[index] != null && index == ArraySize -1){
            Object[] newArrayList = new Object[ArrayList.length + 1];

            ///loop to iterate through the array and update 
            //the values in the new array
            for(int i =0; i < ArrayList.length ; i++){
                newArrayList[i] = ArrayList[i];
            }

            //adding the object to the array
            newArrayList[index] = o;

            for(int i = index; i < ArrayList.length; i++){
                newArrayList[i+1] = ArrayList[i];
            }

            //updating the original array
            ArrayList = newArrayList;

            //updating the number of non-null elements
            //in the array
            numOfElem++;
        }

        //Case 3: where index is less than array length and is
        //not null 
        if(ArrayList[index] != null && index < ArraySize - 1){
            Object[] newArrayList = new Object[ArrayList.length+1];

            ///loop to iterate through the array and update 
            //the values in the new array
            for(int i =0; i < ArrayList.length; i++){
                newArrayList[i] = ArrayList[i];
            }

            //adding the object to the array
            newArrayList[index] = o;

            for(int i = index; i < ArrayList.length; i++){
                newArrayList[i+1] = ArrayList[i];
            }

            //updating the original array
            ArrayList=newArrayList;

            //updating the number of non-null elements
            //in the array
            numOfElem++;
        }

        //Case 4: where the index location is null  
        if(ArrayList[index] == null ){
            ArrayList[index] = o;
            numOfElem++;
        }   

    }    

    /**
     * pre-condition: the parameters need to be passed in the 
     * order i.e. Object first and index after that. 
     * 
     * post-condition: updates the Object type array with the
     * obj at the index passed in. If the index was not empty,
     * the data is moved down the arraylist and then added.
     * It also accounts for the cases where index is more than
     * array length and the cases where the array is empty.
     * 
     * @param: 1 int param. (index)
     * @return: Object removed
     */
    public TBA remove(int index) throws PizzaException{
        //if the index is negative or the obj is a null value
        //then it doesnt add it.
        if (index < 0 || ArrayList[index] == null){ 
            throw new PizzaException("Object is null OR index is OutOfBound.: ");
        }

        TBA retVal = null;
        int ArraySize = ArrayList.length;

        //Case: where index is less than or equal to ArraySize
        if(index <= ArraySize){
            Object[] newArrayList = new Object[ArrayList.length - 1];
            retVal = (TBA)ArrayList[index];

            ///loop to iterate through the array and update 
            //the values in the new array
            for(int i = 0; i < index; i++){
                newArrayList[i] = ArrayList[i];
            }

            for(int i = index; i < ArrayList.length - 1; i++){
                newArrayList[i] = ArrayList[i+1];
            }

            //updating the original array
            ArrayList = newArrayList;  

            //updating the number of non-null elements
            //in the array
            numOfElem--;
        }

        return retVal;
    }

    /**
     * pre-condition: nothing specific. The other methods work.
     * post-condition: returns the size of the Arraylst object
     *  by counting the non-null index objects
     * 
     * @param: none
     * @return: int value of list size
     */
    public int size(){
        int count = 0;

        for(int i =0; i<ArrayList.length; i++){
            if((TBA)ArrayList[i] != null) count ++;
        }

        return count;
    }

    /**
     * pre-condition: arraylist has more than 1 element
     * 
     * post-condition: swaps the objects at the 2 index
     *  with each other
     * 
     * @param: int, int
     * @return: none
     */
    public void swap(int idx1, int idx2){
        TBA value = (TBA)ArrayList[idx1];
        ArrayList[idx1] = (TBA)ArrayList[idx2];
        ArrayList[idx2] = value;
    }

    /**
     * pre-condition: arraylist has more than 1 element
     * 
     * post-condition: returns the type item at a particular
     *  passed index
     * 
     * @param: int
     * @return: TBA
     */
    public TBA get(int idx){
        if(idx > ArrayList.length)
            throw new IllegalArgumentException();
        else 
            return (TBA)ArrayList[idx];
    }

    /**
     * pre-condition: number of non-null elements
     * more than 0.
     * 
     * post-condition: returns the current number of
     * non-null obj in the array 
     * 
     * @return: int
     * @param: none
     */
    public int getNumOfElem(){
        return this.numOfElem;
    }

    /**
     * pre-condition: assumes not all values in the array are null
     * 
     * post-condition: returns the string impression of the non-null
     * items in the ArrayList objects
     * 
     * @return: string impression of the list
     */
    public String toString(){
        String values = "";

        //loop iterates through the array
        //only adds the non-null obj to the string
        for(int i =0; i< ArrayList.length;i++){
            if((TBA)ArrayList[i] != null)
                values += "\n" + (TBA)ArrayList[i];
        }

        return values;
    }

    /**
     * pre-condition: assumes not all values in the array are null
     * 
     * post condition: checks through the Arraylist object for non-null
     * values. Returns a boolean value accordingly
     * 
     * @return: boolean 
     * @param: none
     */
    public boolean isEmpty(){
        boolean value = true;

        //iterates through the array
        //updates boolean value based on whats found
        for(int j = 0; j < ArrayList.length; j++){
            if((TBA)ArrayList[j] == null){                
            }
            else{
                value = false;
            }
        }

        return value;        
    }

    /**
     * pre-condition: the obj is non null
     * 
     * post condition: returns the first found index of 
     * the obj. Returns -1 if not found in the array
     * 
     * @return: int value of index
     * @param: TBA
     */
    public int indexOf(TBA obj) throws PizzaException{
        int position = -1;

        if((TBA) obj == null) throw new PizzaException("Null value passed in.");

        //iterates through the array to find the
        //first index of the obj
        for(int i =0; i<ArrayList.length;i++){
            if((TBA)ArrayList[i] == obj){
                position = i;
            } else if(i == ArrayList.length){
                position = -1;
            }
        }

        return position;
    }

    /**
     * pre-condition: obj is non null and an instance
     * of ArrayList object
     * post-condition: returns a boolean value based on the 
     * comparison between the arraylist obj in terms of size and 
     * obj at each index
     * @return: boolean
     */
    public boolean equals(Object obj){
        boolean value = false;

        //only continues if obj is related
        if((TBA)obj != null && obj instanceof ArrayList == true){
            ArrayList newObj = (ArrayList) (TBA)obj;

            //only checks futher if the size is same
            if(size() == newObj.ArrayList.length ){

                //loop to go through the array
                for(int i = 0; i < ArrayList.length; i++){
                    if((TBA)ArrayList[i] == (TBA)newObj.ArrayList[i]){
                        value = true;
                    } else {
                        value = false;
                        break;
                    }

                }
            }
        }

        return value;
    }
}
