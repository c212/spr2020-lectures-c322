import java.rmi.*; 
import java.awt.event.*; 

public class ClientImplementation extends Thread implements Client {
  String name; 
  int id;  
  Server server; 
  ChatFrame chatFrame; 
  public ClientImplementation(String name) {
    this.name = name; 
    this.chatFrame = new ChatFrame(this); 
    chatFrame.setSize(820, 600); 
    chatFrame.show();
    chatFrame.addWindowListener(
      new WindowAdapter() { 
        public void windowClosing(WindowEvent e) { System.exit(0);}    
      }
    ); 
  }
  public void update(Update event) throws RemoteException {
    // System.out.println(this.name + " receives: ***(" + event + ")*** "); 
    if (event.line != null) chatFrame.chatApplet.drawPad.receive(event.line); 
    if (event.message != null) {
      // System.out.println("***(" + event.message + ")***");
      if (event.message.equals("ClearDraw")) {
        chatFrame.chatApplet.drawPad.clearScreen(); 
        this.chatFrame.chatApplet.textField.setText(""); 
      } else if (event.message.equals("ClearText")) { 
        chatFrame.chatApplet.clearText(); 
      } else if (event.message.equals("List")) {
        chatFrame.chatApplet.showText(event.sender + " is listing: \n", server.list());       
      } else { // basic message 
        chatFrame.chatApplet.showText(event.sender + ": ", event.message); 
      }
    }
  }
  public String name() throws RemoteException {
    return this.name;    
  }
}