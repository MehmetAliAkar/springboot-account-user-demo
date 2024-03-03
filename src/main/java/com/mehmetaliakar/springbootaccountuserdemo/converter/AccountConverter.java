package com.mehmetaliakar.springbootaccountuserdemo.converter;

import com.mehmetaliakar.springbootaccountuserdemo.dto.request.AccountRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.AccountResponse;
import com.mehmetaliakar.springbootaccountuserdemo.model.Account;
import com.mehmetaliakar.springbootaccountuserdemo.model.User;
import com.mehmetaliakar.springbootaccountuserdemo.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class AccountConverter {
    public AccountResponse toResponse(Account entity){
        AccountResponse response = new AccountResponse();
        response.setId(entity.getId());
        response.setUserId(Objects.nonNull(entity.getUsers().get(0)) ? entity.getUsers().get(0).getId() : null);
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setName(entity.getName());

        return response;
    }

    public Account toEntity (AccountRequestDto dto){
        Account account = new Account();
        account.setName(dto.getName());

        User user = new User();
        user.setId(dto.getUserId());

        account.setUsers(Collections.singletonList(user));
        return account;
    }
}
