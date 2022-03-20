package com.as.eatservice.eatservice.dto;

import lombok.Data;

@Data
public class AddFoodRequestDto {
    private String foodName;
    private Long amount;
    private String price;
}
