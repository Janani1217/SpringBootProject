package com.janani.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.janani.spring.data.entities.Product;
import com.janani.spring.data.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void saveProduct() {
		ProductRepository repository = context.getBean(ProductRepository.class);

		Product product = new Product();
		product.setId(1L);
		product.setName("Laptop");
		product.setDescription("ThinkPad");
		product.setPrice(86512d);

		// create
		repository.save(product);
		// update
		product.setPrice(122200);
		// read one product
		Optional<Product> result = repository.findById(1L);
		System.out.println(result);

		// read all and display its price
		repository.findAll().forEach(p -> {
			System.out.println(p.getPrice());
		});
	}

}
