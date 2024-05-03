package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "Order's ID must be > 0")
    private int orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "Product's ID must be > 0")
    private int productId;

    @Min(value = 0, message = "Product's Id must be >= 0")
    private Long price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "Number_of_products must be >= 1")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "total_money must be >= 0")
    private int totalMoney;

    private String color;
}
