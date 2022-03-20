package com.as.eatservice.eatservice.service;



import com.as.eatservice.eatservice.dto.RegistrationRequest;
import com.as.eatservice.eatservice.exception.CustomerNotFoundException;
import com.as.eatservice.eatservice.exception.DuplicateKeyValueException;
import com.as.eatservice.eatservice.model.User;
import com.as.eatservice.eatservice.repository.UserRepository;
import com.as.eatservice.eatservice.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserTypeRepository userTypeRepository;


    @Override
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            user.setUserTypeId(userTypeRepository.findByName(registrationRequest.getUserType()));
            Date date = new Date();
            user.setCreatedAt(date);
            userRepository.save(user);
            return Boolean.TRUE;
        }catch (DataIntegrityViolationException ex){
            throw new DuplicateKeyValueException(ex.getMessage());
        }
        catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public User findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if(user == null){
            throw new CustomerNotFoundException("User not found");
        }
        return user;
    }
}
