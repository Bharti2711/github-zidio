package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.entity.Users;
import com.zidio.zidioconnect.exception.UserNameNOTFOUNDException;
import com.zidio.zidioconnect.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;
    public UsersService (UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public Users getUserByEmail(String email){
        return usersRepository.findByEmail(email).orElseThrow(()->new UserNameNOTFOUNDException("User_Not_Found"));

    }
}
