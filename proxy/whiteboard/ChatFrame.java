import java.awt.*;
import java.rmi.*; 

public class ChatFrame extends Frame {
  ClientImplementation client; 
  ChatApplet chatApplet; 
  public ChatFrame(ClientImplementation client) {
    super(); 
    this.client = client; 
    // System.out.println("Starting up the chatter for " + client.name); 
    this.chatApplet = new ChatApplet(); 
    this.chatApplet.owner = this; 
    this.chatApplet.init(); 
    this.add(this.chatApplet, "Center"); 
  }
}