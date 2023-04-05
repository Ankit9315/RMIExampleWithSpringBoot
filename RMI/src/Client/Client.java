package Client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import Server.Product;
import Server.Shop;

public class Client {

	public static void main(String[] aargs) {
		
		try {
			Registry registry = LocateRegistry.getRegistry(2001);
			
			Shop shop =(Shop) registry.lookup("products");
			
			List<Product> products = shop.getProducts();
			
			for(Product p : products) {
				System.out.println(p.getId() +" "+ p.getName()+" " + p.getPrice()+" " + p.getQuantity());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
