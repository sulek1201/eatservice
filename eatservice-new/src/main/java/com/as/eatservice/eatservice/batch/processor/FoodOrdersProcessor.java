package com.as.eatservice.eatservice.batch.processor;

import com.as.eatservice.eatservice.model.FoodOrder;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class FoodOrdersProcessor implements ItemProcessor<List<FoodOrder>,List<FoodOrder>> {


    @Override
    public List<FoodOrder> process(List<FoodOrder> foodOrderList){

        for(FoodOrder foodOrder:foodOrderList){
            foodOrder.setIsLive(false);
        }
        return foodOrderList;
    }
}
