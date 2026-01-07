package com.jinosoft.cqrs.product.command.domain.repository;


import com.jinosoft.cqrs.product.command.domain.aggregate.Product;

public interface ProductRepository {

  Product save(Product product);

}
