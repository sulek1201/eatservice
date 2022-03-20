package com.as.eatservice.eatservice.service;


import com.as.eatservice.eatservice.dto.AddFoodRequestDto;
import com.as.eatservice.eatservice.dto.FoodResponseDto;

import java.util.List;

public interface FoodOrderService {

    Boolean addFood(AddFoodRequestDto addFoodRequestDto, String userName);

    List<FoodResponseDto> getFoods();

}
