
package testdraw;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextField;


public class DrawFrame extends JFrame
{
    private JLabel stausLabel; //label display mouse coordinates
    private DrawPanel panel; //draw panel for the shapes
    
    private JButton undo; // button to undo last drawn shape
    private JButton clear; // button to clear panel
    private JButton color_1st;
    private JButton color_2nd;
    
    
    
    
    private final JLabel shapeLabel;
    private JComboBox shapes; //combobox with shape options
    //array of strings containing shape options for JComboBox shapes
    private String shapeOptions[]=
    {"Line","Rectangle","Oval"};
    
    
    final private JCheckBox filled; //checkbox to select whether shape is filled or not
    final private JCheckBox dashed;
    final private JCheckBox gradient;
    
    private Color color1 = Color.LIGHT_GRAY;
    private Color color2 = Color.LIGHT_GRAY;
    
    
    private final JTextField lineWidth; // text field with set size
    private final JTextField dashWidth; // text field with set size
    private final JLabel lineWidthLabel;
    private final JLabel dashWidthLabel;
    
    final private JPanel widgetJPanel1; //holds the widgets: buttons, comboboxes and checkbox
    final private JPanel widgetJPanel2;
    final private JPanel widgetPadder; //encapsulates widgetJPanel and adds padding around the edges
    

    public DrawFrame()
    {
        super("SuperPaint Application v2.0!"); //sets the name of DrawFrame
        
        JLabel statusLabel = new JLabel( "" ); //create JLabel object to pass into DrawPanel
        
        panel = new DrawPanel(statusLabel); //create draw panel and pass in JLabel
        
        //create buttons
        undo = new JButton( "Undo" );
        clear = new JButton( "Clear" );
        color_1st = new JButton( "1st Color..." );
        color_2nd = new JButton( "2nd Color..." );
        
        
        //create comboboxes
        shapes = new JComboBox( shapeOptions );
        
        shapeLabel = new JLabel("Shapes:");
        
        //create checkbox
        filled = new JCheckBox( "Filled" );
        dashed = new JCheckBox("Dashed");
        gradient = new JCheckBox("Use Gradient");
        
        
        lineWidth = new JTextField(2);
        lineWidthLabel = new JLabel("Line Width:");
        dashWidth = new JTextField(2);
        dashWidthLabel = new JLabel("Dash Width:");
        
        
        //JPanel object, widgetJPanel, with grid layout for widgets
        widgetJPanel1 = new JPanel();
        widgetJPanel1.setLayout( new FlowLayout() ); //sets padding between widgets in gridlayout
        widgetJPanel1.add( undo );
        widgetJPanel1.add( clear );
        widgetJPanel1.add( shapeLabel );      
        widgetJPanel1.add( shapes );
        widgetJPanel1.add( filled );
        
        widgetJPanel2 = new JPanel();
        widgetJPanel2.setLayout( new FlowLayout() );
        widgetJPanel2.add( gradient );
        widgetJPanel2.add( color_1st );
        widgetJPanel2.add( color_2nd );
        widgetJPanel2.add( lineWidthLabel );
        widgetJPanel2.add( lineWidth );
        widgetJPanel2.add( dashWidthLabel );
        widgetJPanel2.add( dashWidth );
        widgetJPanel2.add( dashed );
        
        //JPanel object, widgetPadder, with flowlayout to encapsulate and pad the widgetJPanel
        widgetPadder = new JPanel();
        widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 15)); //sets padding around the edges
        
        // add widgets to widgetJPanel
        
        
        
        // add widgetJPanel to widgetPadder
        widgetPadder.add( widgetJPanel1 );
        widgetPadder.add( widgetJPanel2 );
        
        //add widgetPadder and panel to JFrame
        add( widgetPadder, BorderLayout.NORTH);
        add( panel, BorderLayout.CENTER);
        
        // create new ButtonHandler for button event handling
        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener( buttonHandler );
        clear.addActionListener( buttonHandler );
        color_1st.addActionListener( buttonHandler );
        color_2nd.addActionListener( buttonHandler );
        
        
//        color_1st.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent event) {
//                color1 = JColorChooser.showDialog(
//                        null, "Pick your color", Color.LIGHT_GRAY);
//                panel.setCurrentShapeColor(color1, color2);
//            }
//            
//            
//        });
//        color_2nd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent event) {
//                color2 = JColorChooser.showDialog(
//                        null, "Pick your color", Color.LIGHT_GRAY);
//                panel.setCurrentShapeColor(color1, color2);
//            }
//        });
        
        
        
        ItemListenerHandler handler = new ItemListenerHandler();
        shapes.addItemListener( handler );
        filled.addItemListener( handler );
        dashed.addItemListener( handler );
        gradient.addItemListener( handler );
        
        
        
        TextFieldHandler texthandler = new TextFieldHandler();
        lineWidth.addActionListener(texthandler);
        dashWidth.addActionListener(texthandler);
        
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize( 2000, 2000 );
        setVisible( true );
        
    } // end DrawFrame constructor
    
    /**
     * private inner class for button event handling
     */
    private class ButtonHandler implements ActionListener
    {
        // handles button events
        public void actionPerformed( ActionEvent event )
        {
            if (event.getActionCommand().equals("Undo")){
                panel.clearLastShape();
            }
            else if (event.getActionCommand().equals("Clear")){
                panel.clearDrawing();
            }
            else if(event.getActionCommand().equals("1st Color...")){
                color1 = JColorChooser.showDialog(
                        null, "Pick your color", Color.LIGHT_GRAY);
                panel.setCurrentShapeColor(color1, color2);
            }
            else if(event.getActionCommand().equals("2nd Color...")){
                color2 = JColorChooser.showDialog(
                        null, "Pick your color", Color.LIGHT_GRAY);
                panel.setCurrentShapeColor(color1, color2);
            }
            
        } // end method actionPerformed
    } // end private inner class ButtonHandler
    
    /**
     * private inner class for checkbox and combobox event handling
     */
    private class ItemListenerHandler implements ItemListener
    {
        public void itemStateChanged( ItemEvent event )
        {
            // process filled checkbox events
            if ( event.getSource() == filled )
            {
                boolean checkFill=filled.isSelected() ? true : false; //
                panel.setCurrentShapeFilled(checkFill);
            }
            if ( event.getSource() == gradient )
            {
                boolean checkGradient=gradient.isSelected() ? true : false; //
                panel.setCurrentShapeGradient(checkGradient);
            }
            
            if ( event.getSource() == dashed )
            {
                boolean checkDashed=dashed.isSelected() ? true : false; //
                panel.setCurrentShapeDashed(checkDashed);
            }
            
            // determine whether combo box selected
            if ( event.getStateChange() == ItemEvent.SELECTED )
            {
                //else if event source is combo box shapes pass in index selected
                if ( event.getSource() == shapes)
                {
                    panel.setCurrentShapeType(shapes.getSelectedIndex());
                } 
            }
            
        } // end method itemStateChanged
        
    }
    
    private class TextFieldHandler implements ActionListener{
        // process textfield events
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == dashWidth)
                panel.setCurrentDashedWidth(Float.parseFloat(event.getActionCommand()));
            else if(event.getSource() == lineWidth)
                panel.setCurrentLineWidth(Float.parseFloat(event.getActionCommand()));
        }
        
    } // end private inner class TextFieldHandler
    
} // end class DrawFrame