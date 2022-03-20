package com.as.eatservice.eatservice.controller;


import com.as.eatservice.eatservice.dto.AddFoodRequestDto;
import com.as.eatservice.eatservice.dto.FoodResponseDto;
import com.as.eatservice.eatservice.service.FoodOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.as.eatservice.eatservice.security.JwtTokenUtil.parseUserNameFromJwt;

@RestController
@RequestMapping("/api/addFood")
public class FoodController {

    @Autowired
    private FoodOrderServiceImpl foodOrderService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Boolean> addFood(@RequestBody AddFoodRequestDto request,
                                            @RequestHeader(name = "Authorization") String token){
        String userName = parseUserNameFromJwt(token);
        if(userName.isEmpty()){
            ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(foodOrderService.addFood(request, userName));
    }

    @RequestMapping(value = "getFood", method = RequestMethod.GET)
    public ResponseEntity<List<FoodResponseDto>> getFood(){
        return ResponseEntity.ok(foodOrderService.getFoods());
    }
}
