import java.applet.*; 
import java.awt.*; 
import java.awt.event.*; 

public class ChatApplet extends Applet implements ActionListener {
  ChatFrame owner; 
  TextArea textArea;
  TextField textField; 
  DrawPad drawPad; 
  Button list, clearDraw, clearText; 
  public void init() {
    this.setLayout(new BorderLayout()); 
    Panel panel = new Panel(); 
    panel.setLayout(new FlowLayout()); 
    panel.add(list = new Button("List")); 
    panel.add(clearDraw = new Button("ClearDraw")); 
    panel.add(clearText = new Button("ClearText")); 
    Button disconnect = new Button("Disconnect"); 
    disconnect.setBackground(Color.pink); 
    panel.add(disconnect); 
    textArea = new TextArea(4, 40); 
    textArea.setEditable(false); 
    textField = new TextField(40); 
    drawPad = new DrawPad(this); 
    drawPad.setSize(400, 400); 
    add(drawPad, "East"); 
    add(textArea, "Center"); 
    add(textField, "South"); 
    add(panel, "North"); 
    textField.addActionListener(this); 
    list.addActionListener(this); 
    clearDraw.addActionListener(this); 
    clearText.addActionListener(this); 
    disconnect.addActionListener(this); 
    // System.out.println("Applet for " + owner.client.name + " initialized."); 
  }
  public synchronized void showText(String sender, String message) {
    this.textArea.append(sender + message + "\n"); 
    this.textField.setText(""); 
  }
  public synchronized void clearText() {
    this.textArea.setText(""); 
    this.textField.setText(""); 
  }
  public void paint(Graphics g) {
    // System.out.println("This is the applet painting..."); 
  }
  public void actionPerformed(ActionEvent event) {
    try { 
      String cmd = event.getActionCommand(); 
      owner.client.server.broadcast(new Update(owner.client.name, cmd, null)); 
    } catch (Exception exception) { 
      System.out.println("Something went wrong during broadcast: " + exception);   
    } 
  }
}