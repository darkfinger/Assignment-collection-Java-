
import java.awt.*;
import javax.swing.*;

public class RegularPolygonPanel extends JPanel {
  // Define constants
  public static final int PENTAGON = -1;
  public static final int HEXAGON = -2;
  public static final int HEPTAGON = -3;
  public static final int OCTAGON = -4;
  public static final int NONAGON = -5;
  public static final int DECAGON = -6;

  private int type = 1;
  private int numberOfSides;

   /** Construct a RegularPolygonPanel with the specified type */
  public RegularPolygonPanel(int type) {
    this.type = type;
  }
  public RegularPolygonPanel(int numberOfSides,boolean a) {
    this.numberOfSides = numberOfSides;
  }


  @Override // Draw a figure on the panel
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
	
	if(this.numberOfSides>2)
	{
		Polygon p = new Polygon();
		for (int i = 0; i < this.numberOfSides; i++)
		p.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / this.numberOfSides)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / this.numberOfSides)));

		g.drawPolygon(p);
	}

    switch (type) {
      case PENTAGON: // Display two cross lines);
		Polygon pPen = new Polygon();
		for (int i = 0; i < 5; i++)
		pPen.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 5)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 5)));

		g.drawPolygon(pPen);
		
        break;
		
		
      case HEXAGON: // Display a HEXAGON
        Polygon pHex = new Polygon();
		for (int i = 0; i < 6; i++)
		pHex.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 6)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 6)));

		g.drawPolygon(pHex);
        break;
		
      case HEPTAGON: // Display a HEPTAGON
        Polygon pHep = new Polygon();
		for (int i = 0; i < 7; i++)
		pHep.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 7)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 7)));

		g.drawPolygon(pHep);
        break;
		
      case OCTAGON: // Display an OCTAGON
		Polygon pOct = new Polygon();
		for (int i = 0; i < 8; i++)
		pOct.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 8)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 8)));

		g.drawPolygon(pOct);
        break;
	case NONAGON: // Display an OCTAGON
		Polygon pNan = new Polygon();
		for (int i = 0; i < 9; i++)
		pNan.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 9)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 9)));

		g.drawPolygon(pNan);
        break;
	case DECAGON: // Display an OCTAGON
		Polygon pDec = new Polygon();
		for (int i = 0; i < 10; i++)
		pDec.addPoint((int) (50 + 25 * Math.cos(i * 2 * Math.PI / 10)),
          (int) (50 + 25 * Math.sin(i * 2 * Math.PI / 10)));

		g.drawPolygon(pDec);
        break;
    }
  }
	
	

  public void setType(int type) {
    this.type = type;
    repaint();
  }
  public int getType() {
    return type;
  }
  public void setNumberOfSides(int numberOfSides) {
    this.numberOfSides = numberOfSides;
    repaint();
  }
  public int getNumberOfSides() {
    return numberOfSides;
  }
  
  @Override // Specify preferred size
  public Dimension getPreferredSize() {
    return new Dimension(80, 80);
  }
}