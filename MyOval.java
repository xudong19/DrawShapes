
package testdraw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.GradientPaint;



public class MyOval extends MyBoundedShape
{

    public MyOval()
    {
        super();
    }
    

    public MyOval( int x1, int y1, int x2, int y2, Color color1, Color color2, 
                    boolean gradient, boolean dashed, float linewidth, float dashedwidth, boolean fill )
    {
        super(x1, y1, x2, y2, color1, color2, gradient, dashed, linewidth, dashedwidth, fill);
    }
    

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
                g2d.fill(new Ellipse2D.Double(getUpperLeftX(), getUpperLeftY(),
                        getWidth(), getHeight()));
            else
                g2d.draw(new Ellipse2D.Double(getUpperLeftX(), getUpperLeftY(),
                        getWidth(), getHeight()));
        
    }
    
} // end class MyOval