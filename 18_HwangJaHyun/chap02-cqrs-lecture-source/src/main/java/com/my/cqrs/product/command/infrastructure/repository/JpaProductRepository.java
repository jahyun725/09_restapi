package com.my.cqrs.product.command.infrastructure.repository;

import com.my.cqrs.product.command.domain.aggregate.Product;
import com.my.cqrs.product.command.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {
// 자식타입이 bean등록되어있어서 JpaProductRepository를 구현한 Proxy가 Bean 존재
}
