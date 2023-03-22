package com.padmanabhasmac.springdatajpacourse.repository;

import com.padmanabhasmac.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class IProductRepositoryTest {

	@Autowired
	private IProductRepository productRepository;

	@Test
	void saveMethod() {
		// create product
		Product product = new Product ( );
		product.setName ( "Product 1" );
		product.setDescription ( "Product 1 Description" );
		product.setSku ( "100ABC" );
		product.setPrice ( new BigDecimal ( 100 ) );
		product.setActive ( true );
		product.setImageUrl ( "product1.png" );

		// save product
		Product productToBeSaved = productRepository.save ( product );

		// display product info
		System.out.println ( productToBeSaved.getId ( ) );
		System.out.println ( productToBeSaved );
	}

	@Test
	void updateUsingSaveMethod() {
		//  find or retrieve an entity by id
		long id = 1L;
		Product productToBeUpdated = productRepository.findById ( id ).get ( );

		// update entity information
		productToBeUpdated.setName ( "updated product 1" );
		productToBeUpdated.setDescription ( "updated product 1 description" );

		// save updated entity
		productRepository.save ( productToBeUpdated );

		System.out.println ( productToBeUpdated );
	}

	@Test
	void findByIdMethod() {
		long id = 1L;

		Product product = productRepository.findById ( id ).get ( );

		System.out.println ( product );
	}

	@Test
	void saveAllMethod() {
		// create product
		Product product2 = new Product ( );
		product2.setName ( "Product 2" );
		product2.setDescription ( "Product 2 Description" );
		product2.setSku ( "100ABCD" );
		product2.setPrice ( new BigDecimal ( 200 ) );
		product2.setActive ( true );
		product2.setImageUrl ( "product2.png" );

		// create product
		Product product3 = new Product ( );
		product3.setName ( "Product 3" );
		product3.setDescription ( "Product 3 Description" );
		product3.setSku ( "100ABCE" );
		product3.setPrice ( new BigDecimal ( 300 ) );
		product3.setActive ( true );
		product3.setImageUrl ( "product3.png" );

		productRepository.saveAll ( List.of ( product2, product3 ) );
	}

	@Test
	void findAllMethod() {
		List<Product> products = productRepository.findAll ( );
		for (Product product : products) System.out.println ( product );
	}

	@Test
	void deleteByIdMethod() {
		long productIdToBeDeleted = 1;
		Product productToBeDeleted = productRepository.findById ( productIdToBeDeleted ).get ( );
		productRepository.deleteById ( productIdToBeDeleted );
		System.out.println ( productToBeDeleted.getName ( ) + " product with id " + productIdToBeDeleted + " has been deleted successfully" );
	}

	@Test
	void deleteMethod() {
		// find an entity by id
		long productIdToBeDeleted = 3L;
		Product productToBeDeleted = productRepository.findById ( productIdToBeDeleted ).get ( );

		// delete (entity)
		productRepository.delete ( productToBeDeleted );
		System.out.println ( productToBeDeleted.getName ( ) + " product with id " + productIdToBeDeleted + " has been deleted successfully" );
	}
}