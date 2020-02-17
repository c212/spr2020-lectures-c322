import java.rmi.*;
public interface ClientExports extends Remote
{
  public void update(Update event) throws RemoteException ;
}
