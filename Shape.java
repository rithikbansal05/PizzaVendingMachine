import java.awt.*;
import java.awt.Graphics;
/**
 * Class Shape:
 *  This is a really basic parent class which will be
 *  used by subclasses for creating unique shapes.
 *  It includes methods like getArea() and draw(Graphics g);
 *  
 *  Rithik Bansal
 *  2/3/2018
 */
public abstract class Shape extends Object implements Cloneable {

    //declaring basic instance variables
    private int x = 0;
    private int y = 0;
    private Color col = new Color(50, 50, 50);

    /**
     * Constructor
     * pre-condition: 2 int, 1 color instance variables
     *  have been declared.
     * 
     * post-condition: 2 instance variables are
     *  initialized to the value passed via 
     *  parameters. the color variable is initialized too
     *  
     * @return: none 
     */
    public Shape( int a, int b, Color c ) {
        this.x=a;
        this.y=b;
        this.col = c;
    }

    /**
     * Constructor
     * pre-condition: constructor has been delared
     * 
     * post-condition: uses the previous consturctor
     *  to initializa the instance varibales.
     *  
     * @return: none 
     */
    public Shape(Shape other) {
        this(other.getX(), other.getY(), other.getCol());
    }

    /**
     * getArea() method
     * pre-condition: abstract class
     *  
     * post-condition: returns the area of the shape 
     *  being created. Returns a double value.
     *  
     * @return: double value equivalent to shape's area 
     */
    public abstract double getArea(); 

    /** NOT USED IN THIS ASSIGNMENT
     * draw() method
     * pre-condition: abstract class
     *  
     * post-condition: executes the method body. In 
     *  subclasses, it will likely draw shapes to the 
     *  output screen.  
     * 
     */
    public abstract void draw( Graphics g );

    /**
     * pre-consition: abstract class
     * 
     * post-condition: child class will have to override it 
     * 
     * @param: none;
     * @return: Object;
     */
    @Override
    public abstract Object clone();

    /**
     * pre-condition: instance variable X has been 
     *  initialized.
     *  
     * postcondition: returns the value stored in the
     *  instance variable X as an int value.
     *  
     *  @return: int value of X
     */
    public int getX() { 
        return this.x; 
    }

    /**
     * pre-condition: instance variable Y has been 
     *  initialized.
     *  
     * postcondition: returns the value stored in the
     *  instance variable Y as an int value.
     *  
     *  @return: int value of Y
     */
    public int getY() { 
        return this.y; 
    }

    /**
     * pre-condition: instance variable Col has been 
     *  initialized.
     *  
     * postcondition: returns the value stored in the
     *  instance variable col as a color obj.
     *  
     *  @return: int value of Y
     */
    public Color getCol() { 
        return this.col; 
    }
}