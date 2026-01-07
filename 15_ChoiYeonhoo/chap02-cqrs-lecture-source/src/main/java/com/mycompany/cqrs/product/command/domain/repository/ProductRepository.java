package com.mycompany.cqrs.product.command.domain.repository;

import com.mycompany.cqrs.product.command.domain.aggreagete.Product;

public interface ProductRepository {

  Product save(Product product);
}
