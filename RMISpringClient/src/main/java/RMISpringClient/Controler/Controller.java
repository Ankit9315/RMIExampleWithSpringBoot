package RMISpringClient.Controler;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RMISpringServer.Entity.Products;
import RMISpringServer.Service.ProductService;

@RestController
public class Controller {

	 @Autowired
	 private ApplicationContext context;
	 
	 @Autowired
	 private ProductService productService;
	 
	@GetMapping("/products")
	public List<Products> getAllProducts() {
	//	ProductService productService = context.getBean(ProductService.class);
		List<Products> products= new ArrayList<>();
		try {
			products = productService.getProducts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	@GetMapping("/product/{id}")
	public Products getProduct(@PathVariable long id) throws RemoteException {
		return productService.getById(id);
	}
	
	@PostMapping("/product")
	public String addNewProduct(@RequestBody Object object) throws RemoteException {
		System.out.println(object.toString());
		System.out.println(JSONObject.valueToString(object));
		String data =JSONObject.valueToString(object);
//		System.out.println(json);
		return productService.addProduct(data);
		
	}
	
	@PutMapping("/product/{id}")
	public String editProduct(@PathVariable long id,@RequestBody Object object) throws RemoteException {
		String data =JSONObject.valueToString(object);
		return productService.updateById(id, data);
		
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable long id) throws RemoteException {
		return productService.deleteById(id);
		
	}
}
