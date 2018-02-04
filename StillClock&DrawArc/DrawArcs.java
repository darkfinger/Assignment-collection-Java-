import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class DrawArcs extends JFrame{
	
	private ArcsPanel van;
	private Thread t1,t2,t3;
	private ArcsPanel van2;
	private ArcsPanel van3;
	private JButton startAll;
	private JButton stopall;
	private JButton startV1;
	private JButton startV2;
	private JButton startV3;
	private JButton stop1,stop2,stop3;
	public static boolean stoped=true,stoped1=true,stoped2=true,stoped3=true;
	
	public DrawArcs() {
		
		van=new ArcsPanel();
		van2=new ArcsPanel();
		van3=new ArcsPanel();
		
		startAll=new JButton("Start All");
		startV1=new JButton("Start Van 1");
		startV2=new JButton("Start Van 2");
		startV3=new JButton("Start Van 3");
		
		stopall=new JButton("stop All");
		stop1=new JButton("stop van 1");
		stop2=new JButton("stop van 2");
		stop3=new JButton("stop van 3");
		
		t1=new Thread(new Runnable(){public void run(){DrawArcs.anim(van);}});
		t2=new Thread(new Runnable(){public void run(){DrawArcs.anim(van2);}});
		t3=new Thread(new Runnable(){public void run(){DrawArcs.anim(van3);}});
		setTitle("DrawArcs");
		
		startAll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
					if(!t1.isAlive() && !t2.isAlive() && !t3.isAlive() )
					{
						if(stoped1 && stoped2 && stoped3)
						{
						t1.start();
						t2.start();
						t3.start();
						}
						else
						{
							t1=new Thread(new Runnable(){public void run(){DrawArcs.anim(van);}});
							t1.start();
							t2=new Thread(new Runnable(){public void run(){DrawArcs.anim(van2);}});
							t2.start();
							t3=new Thread(new Runnable(){public void run(){DrawArcs.anim(van3);}});
							t3.start();
						}
					}
					
					if(t1.isAlive() && !t2.isAlive() && !t3.isAlive() )
					{
						if(stoped2 && stoped3)
						{
						t2.start();
						t3.start();
						}
						else
						{
							t2=new Thread(new Runnable(){public void run(){DrawArcs.anim(van2);}});
							t2.start();
							t3=new Thread(new Runnable(){public void run(){DrawArcs.anim(van3);}});
							t3.start();
						}
					}
					
					
					if(!t1.isAlive() && t2.isAlive() && !t3.isAlive() )
					{
						if(stoped1 && stoped3)
						{
						t1.start();
						t3.start();
						}
						else
						{
							t1=new Thread(new Runnable(){public void run(){DrawArcs.anim(van);}});
							t1.start();
							t3=new Thread(new Runnable(){public void run(){DrawArcs.anim(van3);}});
							t3.start();
						}
					}
					
					
					if(!t1.isAlive() && !t2.isAlive() && t3.isAlive() )
					{
						if(stoped1 && stoped2)
						{
						t1.start();
						t2.start();
						}
						else
						{
							t1=new Thread(new Runnable(){public void run(){DrawArcs.anim(van);}});
							t1.start();
							t2=new Thread(new Runnable(){public void run(){DrawArcs.anim(van2);}});
							t2.start();
						}
					}
				
				
			}
		});
		startV1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{if(!t1.isAlive())
				{
					if(stoped1)
					{
						
							t1.start();
						
					}
					else
					{
						t1=new Thread(new Runnable(){public void run(){DrawArcs.anim(van);}});
						t1.start();					
					}
				}
				
			}
		});
		startV2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{if(!t2.isAlive())
				{
					if(stoped2)
						{
						
						t2.start();
						}
						
					else
					{
						t2=new Thread(new Runnable(){public void run(){DrawArcs.anim(van2);}});
						t2.start();					
					}
				}
			}
		});
		startV3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!t3.isAlive())
				{
					if(stoped3)
					{
						t3.start();
						
					}
					else
					{
						t3=new Thread(new Runnable(){public void run(){DrawArcs.anim(van3);}});
						t3.start();					
					}
				}
			}
		});
		stopall.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t1.interrupt();t3.interrupt();t2.interrupt();
				stoped=false;stoped1=false;stoped2=false;stoped3=false;
			}
		});		
		stop1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(t1.isAlive())
				{
				t1.interrupt();
				stoped1=false;
				}
			}
		});
		stop2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(t2.isAlive())
				{
				t2.interrupt();
				stoped2=false;
				}
			}
		});
		stop3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(t3.isAlive())
				{
				t3.interrupt();
				stoped3=false;
				}
			}
		});
		
        //this.setLayout(new GridLayout(2,4));
		JPanel vanContainer=new JPanel();
		vanContainer.setLayout(new GridLayout(1,3));
		vanContainer.add(van);
		vanContainer.add(van2);
		vanContainer.add(van3);
		
		JPanel Controler1=new JPanel();
		Controler1.setLayout(new GridLayout(1,4));
		Controler1.add(startAll);
		Controler1.add(startV1);
		Controler1.add(startV2);
		Controler1.add(startV3);
		
		JPanel Controler2=new JPanel();
		Controler2.setLayout(new GridLayout(1,4));
		Controler2.add(stopall);
		Controler2.add(stop1);
		Controler2.add(stop2);
		Controler2.add(stop3);
		
		JPanel Controler=new JPanel();
		Controler.setLayout(new GridLayout(2,1));
		Controler.add(Controler1);
		Controler.add(Controler2);
		
		this.setLayout(new BorderLayout());
		this.add(vanContainer,BorderLayout.CENTER);
        this.add(Controler,BorderLayout.SOUTH);
	  }

  /** Main method */
  public static void main(String[] args) {
    DrawArcs frame = new DrawArcs();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 300);
    frame.setVisible(true);
  }
  
	
  public static void anim(ArcsPanel a)
  { 
	try{	
		while(!Thread.interrupted()){  
		  for(int i=0;;i++)
		  {
			 
				a.draw(i);
				Thread.sleep(20);
				}
					
		  }
	  }
	  catch (Exception ex){}
  }
}

// The class for drawing arcs on a panel
class ArcsPanel extends JPanel {
	public static int i = 0;
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

    int x = xCenter - radius;
    int y = yCenter - radius;

    g.fillArc(x, y, 2 * radius, 2 * radius, 0+(i), 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, 90+i, 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, 180+i, 30);
    g.fillArc(x, y, 2 * radius, 2 * radius, 270+i, 30);
  }
  public void draw(int i)
	{
		this.i = i;
		repaint();
	}
}

