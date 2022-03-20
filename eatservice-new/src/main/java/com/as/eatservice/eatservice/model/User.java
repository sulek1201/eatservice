package com.as.eatservice.eatservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "eatservice", name = "users", indexes = {@Index(name = "idx_username", columnList = "uname")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "S_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "uname", length = 100, unique = true)
    private String username;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "name_surname", length = 200)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id", columnDefinition = "numeric(19)", referencedColumnName = "id")
    private UserType userTypeId;

}
