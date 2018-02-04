import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;

public class PolyDraw extends JFrame {
	public static JTextField numOfside=new JTextField(5);
	public static JPanel p2=new JPanel();
	public static JPanel p3=new JPanel();
  public PolyDraw() {
    setLayout(new GridLayout(4,1,5,1)); 
	JPanel p1=new JPanel();
	p1.setLayout(new GridLayout(1, 6));
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.PENTAGON));	
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.HEXAGON));
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.HEPTAGON));
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.OCTAGON));
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.NONAGON));
    p1.add(new RegularPolygonPanel(RegularPolygonPanel.DECAGON));
	
	p2.setLayout(new FlowLayout());	
	p2.add(numOfside);
	p2.add(new JLabel("Tape the number of plygone's side and press Enter"));
		
	p3.setLayout(new FlowLayout());
	RegularPolygonPanel drawp=new RegularPolygonPanel(3,true);
	p3.add(drawp);
	numOfside.addKeyListener(new KeyAdapter() 
    {
        public void keyPressed(KeyEvent evt)
        {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            {				
				int n=Integer.parseInt(numOfside.getText());
				drawp.setNumberOfSides(n);
                numOfside.setText("");
				repaint();
            }
        }
    });
	add(p1);
	add(p2);
	add(p3);
  }

  public static void main(String[] args) {
    PolyDraw frame = new PolyDraw();
    frame.setSize(500, 360);
    frame.setTitle("PolyDraw");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
	frame.setResizable(false);
	

	
  }
  
}