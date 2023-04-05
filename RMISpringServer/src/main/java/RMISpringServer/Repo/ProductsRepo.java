package RMISpringServer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import RMISpringServer.Entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long>{

}
