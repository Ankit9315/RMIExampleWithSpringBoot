package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Shop extends Remote{

	List<Product> getProducts() throws RemoteException;
}
