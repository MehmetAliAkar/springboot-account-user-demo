package com.mehmetaliakar.springbootaccountuserdemo.controller;

import com.mehmetaliakar.springbootaccountuserdemo.core.model.BaseModel;
import com.mehmetaliakar.springbootaccountuserdemo.dto.request.AccountRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.AccountResponse;
import com.mehmetaliakar.springbootaccountuserdemo.repository.AccountRepository;
import com.mehmetaliakar.springbootaccountuserdemo.service.AccountService;
import com.mehmetaliakar.springbootaccountuserdemo.shared.endpoints.AccountEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AccountEndpoints.ACCOUNT)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountResponse save(@RequestBody AccountRequestDto dto){
        return accountService.save(dto);
    }

    @GetMapping("/{id}")
    public AccountResponse getById(@PathVariable Long id){
        return accountService.getById(id);
    }
}
