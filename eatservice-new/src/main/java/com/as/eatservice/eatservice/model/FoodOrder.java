package com.as.eatservice.eatservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "eatservice", name = "food_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder extends BaseEntity{

    @Id
    @SequenceGenerator(name = "food_order_seq", sequenceName = "S_FOOD_ORDER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_order_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "chef_id")
    private Long chefId;

    @Column(name = "food_name", length = 100)
    private String foodName;

    @Column(name = "price")
    private String price;

    @Column(name = "amount")
    private String amount;

    @Column(name = "order_count")
    private Long orderCount;

    @Column(name = "is_live")
    private Boolean isLive;
}
