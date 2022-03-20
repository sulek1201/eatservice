package com.as.eatservice.eatservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "eatservice", name = "user_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "food_order_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private FoodOrder foodOrder;

    @Column(name = "comment", length = 2000)
    private String comment;

    @Column(name = "score")
    private Long score;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;

}
