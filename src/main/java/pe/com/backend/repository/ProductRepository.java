package pe.com.backend.repository;

import org.springframework.data.repository.CrudRepository;

import pe.com.backend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
