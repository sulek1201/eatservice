package com.as.eatservice.eatservice.batch.writer;


import com.as.eatservice.eatservice.model.FoodOrder;
import com.as.eatservice.eatservice.repository.FoodOrderRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FoodOrderWriter implements ItemWriter<List<FoodOrder>> {


    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Override
    @Transactional
    public void write(List<? extends List<FoodOrder>> items) throws Exception {
        items.forEach(foodOrderRepository::saveAll);    }
}
