package com.jinosoft.cqrs.product.command.domain.aggregate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;



@Entity
@Table(name = "tbl_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
/* JPA의 delete 명령이 실행될 때 실제로 수행할 Native SQL을 지정. (Soft Delete 구현) */
@SQLDelete(sql = "UPDATE tbl_product SET status = 'DELETED' WHERE product_code = ?")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productCode;

  private String productName;

  private Long productPrice;

  private String productDescription;

  private Long categoryCode;

  private String productImageUrl;

  private Long productStock;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime modifiedAt;

  @Enumerated(EnumType.STRING)
  private ProductStatus status = ProductStatus.USABLE;

  // 이미지 변경 시 사용 될 메소드
  public void changeProductImageUrl(String productImageUrl) {
    this.productImageUrl = productImageUrl;
  }

  /* 도메인 로직: 비즈니스 규칙에 따른 데이터 변경은 엔터티 내부 메소드로 캡슐화합니다. */
  public void updateProductDetails(@NotBlank String productName, @Min(value = 1) Long productPrice, @NotBlank String productDescription, @Min(value = 1) Long categoryCode, @Min(value = 1) Long productStock, ProductStatus productStatus) {
    this.productName = productName;
    this.productPrice = productPrice;
    this.productDescription = productDescription;
    this.categoryCode = categoryCode;
    this.productStock = productStock;
    this.status = productStatus;
  }

}