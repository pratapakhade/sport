package com.sport.service;

import java.util.List;

import com.sport.entity.ProductEntity;
import com.sport.exception.ProductNotFoundException;

public interface IProductService {

	public ProductEntity addProduct(ProductEntity product);

	public boolean removeProduct(Long productId);

	public ProductEntity updateProduct(Long productId, ProductEntity product) throws ProductNotFoundException ;

	public ProductEntity getProduct(Long productId);

	public List<ProductEntity> getAllProduct();

	List<ProductEntity> getProductsByName(String name) throws ProductNotFoundException;

	List<ProductEntity> getProductsBySize(String size) throws ProductNotFoundException;

	List<ProductEntity> getProductsByPrice(Double price) throws ProductNotFoundException;

	List<ProductEntity> getProductsByColor(String color) throws ProductNotFoundException;

}
