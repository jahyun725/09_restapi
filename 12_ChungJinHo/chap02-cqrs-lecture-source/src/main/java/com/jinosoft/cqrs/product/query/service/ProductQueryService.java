package com.jinosoft.cqrs.product.query.service;

import com.jinosoft.cqrs.common.dto.Pagination;
import com.jinosoft.cqrs.exception.BusinessException;
import com.jinosoft.cqrs.exception.ErrorCode;
import com.jinosoft.cqrs.product.query.dto.request.ProductSearchRequest;
import com.jinosoft.cqrs.product.query.dto.response.ProductDTO;
import com.jinosoft.cqrs.product.query.dto.response.ProductDetailResponse;
import com.jinosoft.cqrs.product.query.dto.response.ProductListResponse;
import com.jinosoft.cqrs.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductQueryService {
  private final ProductMapper productMapper;

  @Transactional(readOnly = true)
  public ProductDetailResponse getProduct(Long productCode) {
    ProductDTO product = Optional.ofNullable(productMapper.selectProductByCode(productCode))
        .orElseThrow(()-> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

    return ProductDetailResponse.builder().product(product).build();
  }

  @Transactional(readOnly = true)
  public ProductListResponse getProducts(ProductSearchRequest productSearchRequest) {
    List<ProductDTO> products = productMapper.selectProducts(productSearchRequest);

    long totalItems = productMapper.countProducts(productSearchRequest);

    int page = productSearchRequest.getPage();
    int size = productSearchRequest.getSize();


    return ProductListResponse.builder().products(products).pagination(
        Pagination.builder().currentPage(page).totalPage((int) Math.ceil((double) totalItems / size)).totalItems(totalItems).build()
    ).build();
  }
}
