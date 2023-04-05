package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopImpl implements Shop{

	public ShopImpl() throws RemoteException {}

	@Override
	public List<Product> getProducts() throws RemoteException {
		
		List<Product> products=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234@Global");
			PreparedStatement preparedStatement=con.prepareStatement("Select * from Products");
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
			Product p=new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setQuantity(rs.getInt(3));
			p.setPrice(rs.getInt(4));
			products.add(p);
			} 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

}
