package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] aargs) {
		try {
			Remote r = new ShopImpl();
			Shop stub =(Shop) UnicastRemoteObject.exportObject(r, 0);
			Registry registry=LocateRegistry.createRegistry(2001);
			registry.rebind("products", stub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
