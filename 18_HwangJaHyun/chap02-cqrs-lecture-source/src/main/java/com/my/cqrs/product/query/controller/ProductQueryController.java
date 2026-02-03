package com.my.cqrs.product.query.controller;

import com.my.cqrs.common.dto.ApiResponse;
import com.my.cqrs.product.query.dto.request.ProductSearchRequest;
import com.my.cqrs.product.query.dto.response.ProductDetailResponse;
import com.my.cqrs.product.query.dto.response.ProductListResponse;
import com.my.cqrs.product.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* 조회 담당 컨트롤러 (Query Side) */
// requestMapping쓰지말자
@RestController //ResponseBody + @Controller
@RequiredArgsConstructor
public class ProductQueryController {
  private final ProductQueryService productQueryService;

  @GetMapping("/products/{productCode}")
  public ResponseEntity<?> getProduct(@PathVariable("productCode") Long productCode){

      ProductDetailResponse response = productQueryService.getProduct(productCode);

      return ResponseEntity.ok(ApiResponse.success(response));
  }

  /* 조건에 맞는 상품 목록 조회 */
  @GetMapping("/products")
  public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
      //@ModelAttribute(생략 가능)
      ProductSearchRequest productSearchRequest //커맨드 객체
  ){
    ProductListResponse response = productQueryService.getProducts(productSearchRequest);

    return ResponseEntity.ok(ApiResponse.success(response));
  }
}
