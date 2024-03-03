package com.mehmetaliakar.springbootaccountuserdemo.service;

import com.mehmetaliakar.springbootaccountuserdemo.converter.AccountConverter;
import com.mehmetaliakar.springbootaccountuserdemo.dto.request.AccountRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.AccountResponse;
import com.mehmetaliakar.springbootaccountuserdemo.model.Account;
import com.mehmetaliakar.springbootaccountuserdemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final UserService userService;
    public AccountResponse save(AccountRequestDto dto) {
        Account entity = accountConverter.toEntity(dto);
        AccountResponse response = accountConverter.toResponse(
                accountRepository.save(entity));

        userService.updateAccountId(dto.getUserId(), response);

        return response;
    }

    public AccountResponse getById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account account = optionalAccount.orElseThrow(()-> new RuntimeException(("Id bulunamadı!")));
        return accountConverter.toResponse(account);
    }
}
