package com.jinosoft.cqrs.product.command.application.dto.request;

import com.jinosoft.cqrs.product.command.domain.aggregate.ProductStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductCreateRequest {
  @NotBlank
  private final String productName;
  @Min(1)
  private final Long productPrice;
  @NotBlank
  private final String productDescription;
  @Min(1)
  private final Long categoryCode;
  @Min(1)
  private final Long productStock;
}
