import java.rmi.*; 

public interface Client extends Remote { 
  public void update(Update event) throws RemoteException; 
  public String name() throws RemoteException; 
}