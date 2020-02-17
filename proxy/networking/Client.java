import java.rmi.*;
import java.rmi.server.*;
public class Client extends Thread implements ClientExports
{
  String name;
  int id;
  ServerExports server;
  public Client(String name) { this.name = name; }
  public void update(Update event) throws RemoteException {
    System.out.println(this.name +
                       " receives: ***(" + event + ")*** ");
  }
  public void run() {
    while (true) {
      try {
        sleep((int)(Math.random() * 6000 + 10000));
        server.broadcast(
                         new Update(this.name + " says: Howdy!"));
      } catch (Exception e) { }
    }
  }
  public static void main(String[] args) {
    try {
      ServerExports far =
        (ServerExports)Naming.lookup(
                                     "rmi://" + args[0] + ":" + args[1] + "/Dirac");
      Client here = new Client( args[2] );
      UnicastRemoteObject.exportObject(here);
      here.id = far.register(here);
      here.server = far;
      here.start();
    } catch (Exception e) {
      System.out.println("Error in client... " + e);
      e.printStackTrace();
    }
  } 
}