import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Square here.
 * Creates a Triangle shape onto the drawing panel
 * in blue color
 *
 * Rithik Bansal
 * 2/2/18
 */
public class Square extends Shape implements Cloneable
{
    //declaring isntance variable
    private int length;
    //private Color squColor;
    
    /**
     * pre-conditon: no-arg constructor
     * 
     * post-condition: calls parent constructor
     *  to update the isntance variables
     * 
     * @param: none
     * @return: none
     */
    public Square(){
        super(20,20, new Color(20, 50, 100));
        length = 5;
        //squColor = Color.black;
    }
    
    /**
     * pre-conditon: Constructor: takes 4 arguments.
     *  Shapes inherited
     * 
     * post-condition: calls parent constructor and 
     *  updates the instnace variable
     * 
     * @param: int, int, int , Color
     * @return: none
     */
    public Square(int x, int y, int len, Color c){
        super(x,y,c);
        length = len;
    } 

    /**
     * pre-conditon: instance variables have been initialized
     * 
     * post-condition: returns the double value of the area of 
     *  the shape.
     * 
     * @param: none
     * @return: double
     */
    @Override
    public double getArea(){
        String val = String.format("%.2f", ((double)this.length *this.length));
        double retVal = Double.parseDouble(val);
        return retVal;
    }

    /** NOT USED IN THIS ASSIGNMENT. Here because assignment asked us to copy 
     *      from our previous assignments
     * pre-conditon: Method not required. But still added
     * 
     * post-condition: draws the shape to the jpanel
     *  if a drawing panel is made.
     * 
     * @param: Graphics
     * @return: none
     */
    @Override
    public void draw(Graphics g){
        Graphics g2d = (Graphics) g;

        final int x = getX();
        final int y = getY();
        int l = this.length;

        g2d.setColor(Color.blue);
        g2d.drawRect(x,y, l, l);
    }

    /**
     * pre-conditon: instance varaible is declared
     * 
     * post-condition: returns the double value of the 
     *  variable radius
     * 
     * @param: none
     * @return: double
     */
    public int getLength(){
        return this.length;
    }

    /**
     * pre-conditon: instance varaible is declared
     * 
     * post-condition: sets the value of the radius.
     *  Assumes the setting value is non-negative.
     *  Doesnt assign anything if rad val passed in is
     *   negative
     * 
     * @param: double
     * @return: none
     */
    public void setLength(int l){
        this.length = l;
    }

    /*
     * pre-condition: instance variable Col has been 
     *  initialized.
     *  
     * postcondition: returns the value stored in the
     *  instance variable col as a color obj.
     *  
     *  @return: int value of Y
     *
    public Color getSquColor() { 
        return this.squColor; 
    }*/
    
    /**
     * pre-conditon: the shape class has been inherited 
     * 
     * post-condition: Overrides the clone method and throws 
     *  exception if it is not the circle object
     * 
     * @param: none
     * @return: Square
     */
    @Override
    public Square clone(){
        try{
            return (Square)new Square(getX(), getY(), getLength(), getCol());
        }
        catch(Exception e){
            throw new RuntimeException("Unable to clone Square error.");
        }
    }
    
    /**
     * pre-conditon: The class inherits from Shape class
     * 
     * post-condition: returns a string impression od the shape
     * 
     * @param: none
     * @return: String
     */
    public  String toString(){
        return "Square";
    }
}
