package RMISpringClient.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import RMISpringServer.Service.ProductService;


@Configuration
public class Configure {

	@Bean
	RmiProxyFactoryBean rmiProxyBean() {
		
		RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
		bean.setServiceInterface(ProductService.class);
		bean.setServiceUrl("rmi://localhost:1099/products");
		System.out.println("Client is running");
		return bean;
		
	}
}
