

package testdraw;

import java.awt.Color;
import java.awt.Graphics;


abstract class MyShape
{
    private int x1,y1,x2,y2; //coordinates of shape
    Color color1; // color of shape
    Color color2; 
    boolean gradient;
    boolean dashed;
    float linewidth;
    float dashedwidth;
    
    /**
    * public constructor which takes no variables and
    * sets coordinates to zero and color to black
    */
    public MyShape()
    {
        x1=0;
        y1=0;
        x2=0;
        y2=0;
        color1=Color.LIGHT_GRAY;
        color2=Color.LIGHT_GRAY;
        gradient = false;
        dashed = false;
        
        linewidth = 5;
        dashedwidth = 1;

    }
    
    /**
    * overloaded constructor which takes variables for coordinates and 
    * color assigning them to the instance variables in the class
    */
    public MyShape(int x1, int y1, int x2, int y2, Color color1, Color color2, 
            boolean gradient,boolean dashed, float linewidth, float dashedwidth)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.color1=color1;
        this.color2=color2;
        this.gradient = gradient;
        this.dashed = dashed;
        this.linewidth = linewidth;
        this.dashedwidth = dashedwidth;
    }
    
    //Mutator methods
    
    /**
     * Mutator method for x1
     */
    public void setX1(int x1)
    {
        this.x1=x1;
    }   
    
    /**
     * Mutator method for y1
     */
    public void setY1(int y1)
    {
        this.y1=y1;
    }   
    
    /**
     * Mutator method for x2
     */
    public void setX2(int x2)
    {
        this.x2=x2;
    }   
    
    /**
     * Mutator method for y2
     */
    public void setY2(int y2)
    {
        this.y2=y2;
    }   
    
    /**
     * Mutator method for color
     */
    public void setColor(Color color1, Color color2)
    {
        this.color1=color1;
        this.color2=color2;
    }
    public void setGradient(boolean gradient){
        this.gradient = gradient;
        
    }
    public void setDashed(boolean dashed){
        this.dashed = dashed;
        
    }
    public void setLineWidth(float linewidth){
        this.linewidth = linewidth;
        
    }
    public void setDashedWidth(float dashedwidth){
        this.dashedwidth = dashedwidth;
    }
    
    //Accessor methods
    
    /**
     * Accessor method for x1
     */
    public int getX1()
    {
        return x1;
    }
    
    /**
     * Accessor method for y1
     */
    public int getY1()
    {
        return y1;
    }
    
    /**
     * Accessor method for x2
     */
    public int getX2()
    {
        return x2;
    }
    
    /**
     * Accessor method for y2
     */
    public int getY2()
    {
        return y2;
    }
    
    /**
     * Accessor method for color
     */
    public Color getColor1()
    {
        return color1;
    }
    public Color getColor2()
    {
        return color2;
    }
    
    public boolean getGradient()
    {
        return gradient;
    }
    
    public boolean getDashed()
    {
        return dashed;
    }
    
    public float getLineWidth()
    {
        return linewidth;
    }
    
    public float getDashedWidth()
    {
        return dashedwidth;
    }
    
    /**
     * Abstract method for drawing the shape that must be overriden
     */
    abstract public void draw( Graphics g );

}