package com.sport.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sport.entity.ProductEntity;

	@Repository
	public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
         // method for find by name
		 @Query(value = "SELECT * FROM products p WHERE p.product_name = ?1",nativeQuery = true)
		 List<ProductEntity> findByName(String name);
		 
		 //method for find by size
		 @Query(value = "SELECT * FROM products p WHERE p.product_size = ?1",nativeQuery = true)
		 List<ProductEntity> findBySize(String size);
         
		//method for find by price
		 @Query(value = "SELECT * FROM products p WHERE p.product_mrp = ?1",nativeQuery = true)
		 List<ProductEntity> findByPrice(double price);
		 
		//method for find by color
		 @Query(value = "SELECT * FROM products p WHERE p.product_colour = ?1",nativeQuery = true)
		 List<ProductEntity> findByColor(String color);
		 
		 
	}



