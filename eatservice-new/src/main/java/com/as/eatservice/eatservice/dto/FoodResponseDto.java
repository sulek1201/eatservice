package com.as.eatservice.eatservice.dto;

import lombok.Data;

@Data
public class FoodResponseDto {
    private String foodName;
    private String amount;
    private String price;
    private String chefName;
}
