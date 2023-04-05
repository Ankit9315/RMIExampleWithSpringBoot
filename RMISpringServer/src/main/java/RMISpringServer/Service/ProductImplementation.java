package RMISpringServer.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import RMISpringServer.Entity.Products;
import RMISpringServer.Repo.ProductsRepo;

@Service
public class ProductImplementation implements ProductService{
	
	public ProductImplementation() throws RemoteException {
		super();
	}

	@Autowired
	private ProductsRepo productsRepo;

	@Override
	public List<Products> getProducts() throws RemoteException {
		// TODO Auto-generated method stub
//		System.out.println(productsRepo.findAll());
//		List<Products> products = productsRepo.findAll();
		return productsRepo.findAll();
	}

	@Override
	public String getString(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		return msg +" server client";
	}

	@Override
	public String addProduct(String data) throws RemoteException {
		JSONObject object = new JSONObject(data);
		Products product =new Products();
		System.out.println(object.getString("name"));
		product.setName(object.getString("name"));
		product.setPrice(object.getInt("price"));
		product.setQuantity(object.getInt("quantity"));
		productsRepo.save(product);
		return "Successfully Added";
	}

	@Override
	public Products getById(long id) throws RemoteException {
		
		return productsRepo.findById(id).orElse(null);
	}

	@Override
	public String deleteById(long id) throws RemoteException {
		// TODO Auto-generated method stub
		Products product =  productsRepo.findById(id).orElse(null);
		if(product != null) {
			productsRepo.deleteById(id);
			return "Successfully deleted";
		}
		else {
			return "Not Found";
		}
	}

	@Override
	public String updateById(long id, String data) throws RemoteException {
		Products product =  productsRepo.findById(id).orElse(null);
		if(product !=null) {
			JSONObject object = new JSONObject(data);
			product.setName(object.getString("name"));
			product.setPrice(object.getInt("price"));
			product.setQuantity(object.getInt("quantity"));
			productsRepo.save(product);
			return "Successfully updated";
		}
		return "Not Found";
	}
 
	
}
