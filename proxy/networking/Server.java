import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class Server extends UnicastRemoteObject
  implements ServerExports
{
  ClientExports clients[] = new ClientExports[100];
  int index = -1;
  synchronized public int register(ClientExports client)
    throws RemoteException
  {
    clients[++index] = client;
    return index;
  }
  synchronized public void broadcast(Update event)
    throws RemoteException
  {
    for (int i = 0; i <= index; i++)
      clients[i].update(event);
  }
  public Server() throws RemoteException
  {
    System.out.println("Server being initialized... ");
  }
  public static void main(String[] args) {
    System.setSecurityManager(new RMISecurityManager());
    try
    {
      Server pam = new Server();
      Registry cat =
        LocateRegistry.createRegistry(Integer.parseInt( args[0] ));
      cat.bind("Dirac", pam);
      System.out.println("Server is ready... ");
    } catch (Exception e) {
      System.out.println("Server error: " + e + "... ");
    }
  }
} 