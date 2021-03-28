package pe.com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.backend.model.Product;
import pe.com.backend.repository.ProductRepository;
import pe.com.backend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override	
	@Transactional(readOnly=false)
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Product findById(Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

}
