package com.as.eatservice.eatservice.service;


import com.as.eatservice.eatservice.dto.AddFoodRequestDto;
import com.as.eatservice.eatservice.dto.FoodResponseDto;
import com.as.eatservice.eatservice.model.FoodOrder;
import com.as.eatservice.eatservice.repository.FoodOrderRepository;
import com.as.eatservice.eatservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Override
    @Transactional
    public Boolean addFood(AddFoodRequestDto addFoodRequestDto, String userName) {
        FoodOrder foodOrder = new FoodOrder();
        modelMapper.map(addFoodRequestDto,foodOrder);
        foodOrder.setCreatedBy(userName);
        foodOrder.setCreatedAt(new Date());
        foodOrder.setIsLive(true);
        foodOrder.setChefId(userRepository.findByUsername(userName).getId());
        try{
            foodOrderRepository.save(foodOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<FoodResponseDto> getFoods() {
        List<FoodOrder> foodOrders = foodOrderRepository.findAll();
        List<FoodResponseDto> foodResponseDtos = new ArrayList<>();
        for(FoodOrder foodOrder : foodOrders){
            FoodResponseDto foodResponseDto = new FoodResponseDto();
            modelMapper.map(foodOrder, foodResponseDto);
            foodResponseDto.setChefName(foodOrder.getCreatedBy());
            foodResponseDtos.add(foodResponseDto);
        }
        return foodResponseDtos;
    }
}
