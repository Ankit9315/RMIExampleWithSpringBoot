package RMISpringServer.Service;

import java.rmi.RemoteException;
import java.util.List;

import org.json.JSONObject;

import RMISpringServer.Entity.Products;

//import RMISpringClient.Entity.Products;


public interface ProductService {

    public List<Products> getProducts() throws RemoteException;
	
	public String getString(String msg) throws RemoteException;
	
	public String addProduct(String data) throws RemoteException;
	
	public Products getById(long id) throws RemoteException;
	
	public String deleteById(long id) throws RemoteException;
	
	public String updateById(long id,String data) throws RemoteException;
}
