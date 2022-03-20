package com.as.eatservice.eatservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "eatservice", name = "user_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserType {
    @Id
    private Long id;

    @Column(name = "enm_vl", length = 200)
    private String enumValue;

    @Column(name = "nm", length = 200)
    private String name;
}
