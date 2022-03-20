package com.as.eatservice.eatservice.repository;

import com.as.eatservice.eatservice.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    List<FoodOrder> findByIsLive(Boolean isLive);

}
