package com.as.eatservice.eatservice.service;



import com.as.eatservice.eatservice.dto.RegistrationRequest;
import com.as.eatservice.eatservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Boolean register(RegistrationRequest registrationRequest);

    User findByUserName(String userName);


}
