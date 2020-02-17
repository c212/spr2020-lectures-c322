import java.rmi.*;
public interface ServerExports extends Remote {
  public int register(ClientExports client) throws RemoteException ;
  public void broadcast(Update event) throws RemoteException ;
} 