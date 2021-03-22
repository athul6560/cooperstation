package com.athulbabu.azstudio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.athulbabu.azstudio.model.product;



@RepositoryRestResource(collectionResourceRel = "products",path="products")
public interface product_dao extends JpaRepository<product, Integer>{
	product findByTitle(String title);
}
