package com.jinosoft.cqrs.product.query.controller;

import com.jinosoft.cqrs.common.dto.ApiResponse;
import com.jinosoft.cqrs.product.query.dto.request.ProductSearchRequest;
import com.jinosoft.cqrs.product.query.dto.response.ProductDetailResponse;
import com.jinosoft.cqrs.product.query.dto.response.ProductListResponse;
import com.jinosoft.cqrs.product.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductQueryController {
  private final ProductQueryService productQueryService;

  @GetMapping("/products/{productCode}")
  public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable("productCode") Long productCode) {
    ProductDetailResponse response =  productQueryService.getProduct(productCode);
    return ResponseEntity.ok(ApiResponse.success(response));
  }

  @GetMapping("/products")
  public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
     // @ModelAttribute
     ProductSearchRequest productSearchRequest
  ){
    ProductListResponse response = productQueryService.getProducts(productSearchRequest);
    return ResponseEntity.ok(ApiResponse.success(response));
  }


}
