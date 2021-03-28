package pe.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.backend.model.Product;
import pe.com.backend.service.ProductService;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@GetMapping("/products")
	public List<Product> products(){
		return productService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product toShow(@PathVariable Integer id) {
		return productService.findById(id);
	}
	
	@PutMapping("/products/{id}")
	public Product upDate(@RequestBody Product product,@PathVariable Integer id) {
		Product productCurrent =  productService.findById(id);
		productCurrent.setName(product.getName());
		productCurrent.setDecription(product.getDecription());
		productCurrent.setPrice(product.getPrice());
		productCurrent.setStock(product.getStock());
		
		return productService.save(productCurrent);
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		productService.delete(id);
	}

}
