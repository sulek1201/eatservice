package com.as.eatservice.eatservice.repository;


import com.as.eatservice.eatservice.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    UserType findByName(String userTypeName);
}



