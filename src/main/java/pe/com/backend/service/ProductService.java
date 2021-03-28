package pe.com.backend.service;

import java.util.List;

import pe.com.backend.model.Product;

public interface ProductService {

	public Product save(Product product);

	public void delete(Integer id);

	public Product findById(Integer id);

	public List<Product> findAll();

}
