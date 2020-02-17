import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class DrawPad extends Canvas implements MouseMotionListener, MouseListener {
  Vector lines = new Vector(); 
  ChatApplet applet; 
  public DrawPad(ChatApplet applet) {
    this.applet = applet;     
    addMouseMotionListener(this); 
    addMouseListener(this); 
  }
  int startX, startY; 
  public void mouseDragged(MouseEvent event) { 
    Line line = new Line(startX, startY, event.getX(), event.getY()); 
    startX = event.getX(); startY = event.getY(); 
    Update update = new Update(applet.owner.client.name, null, line); 
    try { 
      applet.owner.client.server.broadcast(update); 
      // this.receive(line); 
      // System.out.println(applet.owner.client.name + ": I am trying."); 
    } catch (Exception exception) { } 
    // System.out.println(applet.owner.client.name + " is dragging the mouse.");    
  } 
  public synchronized void receive(Line line) {
    lines.addElement(line); 
    this.render(line); 
  }
  public synchronized void clearScreen() {
    // System.out.println(applet.owner.client.name + "I am to clear the screen now."); 
    this.lines = new Vector(); 
    Graphics g = this.getGraphics(); 
    // g.setColor(
    this.repaint(); 
  }
  public synchronized void render(Line line) {
    this.getGraphics().drawLine(line.x0, line.y0, line.x1, line.y1); 
  }
  public void mouseMoved(MouseEvent e) { } 
  public void mousePressed(MouseEvent e) {  
    startX = e.getX(); 
    startY = e.getY(); 
  } 
  public void mouseReleased(MouseEvent e) { } 
  public void mouseClicked(MouseEvent e) { } 
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { } 
  public synchronized void paint(Graphics g) {
    if (lines != null) { 
      for (int i = 0; i < lines.size(); i++) {
        this.render((Line)lines.elementAt(i));    
      }
    }   
  }
}