

package testdraw;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
 


public class MyLine extends MyShape
{

    public MyLine()
    {
        super();
    }
    
    /**
     * Overloaded constructor that takes coordinates and color. It passes them to the constructor in MyShape

     */
    public MyLine( int x1, int y1, int x2, int y2, Color color1,  Color color2, 
                    boolean gradient, boolean dashed, float linewidth, float dashedwidth)
    {
        super(x1, y1, x2, y2, color1, color2, gradient, dashed, linewidth, dashedwidth);

        
    }
    
    /**
     * Overrides the draw method in Myshape. It sets the gets the color from Myshape
     * and the coordinates it needs to draw from MyShape as well.
     */
    @Override
    public void draw( Graphics g )
    {
        color1 = getColor1();
        color2 = getColor2();
        
        
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        
        if (getGradient()){
            g2d.setPaint(new GradientPaint(getX1(), getY1(), color1,
                    getX2(), getY2(), color2, true));   
        }
        else{
            g2d.setPaint(new GradientPaint(getX1(), getY1(), color1,
                    getX2(), getY2(), color1, true));
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
        
        
        g2d.draw(new Line2D.Double(getX1(), getY1(),
                    getX2(), getY2()));
        
        
    }
} // end class MyLine