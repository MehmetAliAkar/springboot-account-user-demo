package com.mehmetaliakar.springbootaccountuserdemo.converter;

import com.mehmetaliakar.springbootaccountuserdemo.dto.request.UserRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.UserResponse;
import com.mehmetaliakar.springbootaccountuserdemo.model.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserConverter {

    public UserResponse toResponse(User entity){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(entity.getId());
        userResponse.setAccountId(Objects.isNull(entity.getAccount())?null:entity.getAccount().getId());
        userResponse.setPassword(entity.getPassword());
        userResponse.setName(entity.getName());
        userResponse.setSurname(entity.getSurname());
        userResponse.setEmail(entity.getEmail());
        userResponse.setPhoneNumber(entity.getPhoneNumber());
        userResponse.setCreatedDate(entity.getCreatedDate());
        userResponse.setUpdatedDate(entity.getUpdatedDate());

        return userResponse;
    }

    public User toEntity(UserRequestDto dto)
    {
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
