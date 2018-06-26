
package testdraw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class MyRectangle extends MyBoundedShape
{ 

    public MyRectangle()
    {
        super();
    }
    
    /** 
     * Overloaded constructor that takes coordinates, color and fill. 
     * It passes them into MyBoundedShape's constructor
     */
    public MyRectangle( int x1, int y1, int x2, int y2, Color color1, Color color2, 
            boolean gradient, boolean dashed, float linewidth, float dashedwidth, boolean fill )
    {
        super(x1, y1, x2, y2, color1, color2, gradient, dashed, linewidth, dashedwidth, fill);
    } 
    
    /**
     * Overrides the draw method in MyBoundedShape. It sets the gets the color from MyBoundedShape
     * to set the color and the values it needs to draw from MyBoundedShape as well.
     */
    @Override
    public void draw( Graphics g )
    {
        
        color1 = getColor1();
        color2 = getColor2();
        Graphics2D g2d = (Graphics2D) g;
        
        
        if (getGradient()){  
            g2d.setPaint(new GradientPaint(getUpperLeftX(), getUpperLeftY(), color1,
                    getWidth(), getHeight(), color2, true));
        }   
        else{     
            g2d.setPaint(new GradientPaint(getUpperLeftX(), getUpperLeftY(), color1,
                    getWidth(), getHeight(), color1, true));
        }
        
        
        
        if(getDashed()){
            float[] dashes = {getDashedWidth()};
            g2d.setStroke(new BasicStroke(getLineWidth(), BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 10, dashes, 0));
        }
        else{
            float[] dashes = {1};
            g2d.setStroke(new BasicStroke(getLineWidth(), BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND, 10, dashes, 0)); 
        }
        
        
        
        
        if (getFill()) //determines whether fill is true or false
                g2d.fill(new Rectangle2D.Double(getUpperLeftX(), getUpperLeftY(),
                        getWidth(), getHeight()));
            else
                g2d.draw(new Rectangle2D.Double(getUpperLeftX(), getUpperLeftY(),
                        getWidth(), getHeight()));
        
        
        

        
    } 
    
}