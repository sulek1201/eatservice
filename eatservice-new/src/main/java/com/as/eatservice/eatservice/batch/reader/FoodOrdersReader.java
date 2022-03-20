package com.as.eatservice.eatservice.batch.reader;


import com.as.eatservice.eatservice.model.FoodOrder;
import com.as.eatservice.eatservice.repository.FoodOrderRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodOrdersReader implements ItemReader<List<FoodOrder>> {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Override
    public List<FoodOrder> read() {
        List<FoodOrder> foodOrderList = foodOrderRepository.findByIsLive(true);
        if(foodOrderList.size() == 0){
            return null;
        }
       return foodOrderList;
    }
}
