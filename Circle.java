import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Write a description of class Circle here.
 * Creates a Circle shape onto the drawing panel
 * in black color
 *
 * Rithik Bansal
 * 2/2/18
 */
public class Circle extends Shape implements Cloneable
{
    //decalring instance variables
    private double radius;
    //private Color cirCol;
    
    /**
     * pre-conditon: no-arg constructor
     * 
     * post-condition: calls parent constructor
     *  to update the isntance variables
     * 
     * @param: none
     * @return: none
     */
    public Circle(){
        super(20,20, new Color(20, 50, 100));
        radius = 5;
        //cirCol = Color.black;
    }
    
    /**
     * pre-conditon: Constructor: takes 4 arguments.
     *  Shapes inherited
     * 
     * post-condition: calls parent constructor and 
     *  updates the instnace variable
     * 
     * @param:
     * @return
     */
    public Circle(int x, int y, double rad, Color c){
        super(x,y,c);
        radius = rad;
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
        double rad = radius;
        String val = String.format("%.2f", ((double)Math.PI * rad * rad));
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
        Graphics2D gd = (Graphics2D) g;
        
        final int x = getX();
        final int y = getY();
        
        gd.setColor(Color.black);
        gd.drawOval(x, y, (int)radius * 2, (int)radius * 2);       
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
    public double getRadius(){
        return this.radius;
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
    public void setRadius(double rad){
        if(rad >= 0)
            this.radius = rad;
        else
            System.out.println("Radius only takes non-negative value.");
    }
    
    /**
     * pre-condition: instance variable Col has been 
     *  initialized.
     *  
     * postcondition: returns the value stored in the
     *  instance variable col as a color obj.
     *  
     *  @return: int value of Y
     *
    public Color getCirColor() { 
        return this.cirCol; 
    }*/
    
    /**
     * pre-conditon: the shape class has been inherited 
     * 
     * post-condition: Overrides the clone method and throws 
     *  exception if it is not the circle object
     * 
     * @param: none
     * @return: Circle
     */
    @Override
    public Circle clone(){
        try{
            return (Circle)new Circle(getX(), getY(), getRadius(), getCol());
        }
        catch(Exception e){
            throw new RuntimeException("Unable to clone Circle error.");
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
        return "Circular";
    }
}
