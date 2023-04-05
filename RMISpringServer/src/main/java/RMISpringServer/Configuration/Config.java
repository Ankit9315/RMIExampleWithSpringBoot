package RMISpringServer.Configuration;

import java.rmi.RemoteException;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import RMISpringServer.Service.ProductImplementation;
import RMISpringServer.Service.ProductService;

@Configuration
public class Config {
	
	

	@Bean
	RemoteExporter registerRMIExporter(ProductImplementation productImplementation) {
		
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceName("products");
		exporter.setServiceInterface(ProductService.class);
		exporter.setService(productImplementation);
		return exporter;
	}
	
	@Bean
	public ProductService productService() throws RemoteException{
		return new ProductImplementation();
	}
	
}
