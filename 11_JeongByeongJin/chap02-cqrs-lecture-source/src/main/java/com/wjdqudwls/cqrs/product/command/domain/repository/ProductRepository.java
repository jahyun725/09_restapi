package com.wjdqudwls.cqrs.product.command.domain.repository;


import com.wjdqudwls.cqrs.product.command.domain.aggregate.Product;

public interface ProductRepository {

  Product save(Product product);

}
