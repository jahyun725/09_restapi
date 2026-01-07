package com.jinosoft.cqrs.product.query.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDetailResponse {
  /* API 응답 구조의 일관성과 코드 확장성,
   * JSON 데이터 응답 형태를 위해
   * DTO를 감싼 Reponse 클래스를 별도 생성
   * */

  private final ProductDTO product;
  private final CategoryDTO category;
  private final String productImageUrl;
  private final Long productStock;
  private final Long productPrice;
  private final String productDescription;
  private final String productName;
  private final Long productCode;

}
