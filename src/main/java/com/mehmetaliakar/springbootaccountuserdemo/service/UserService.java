package com.mehmetaliakar.springbootaccountuserdemo.service;

import com.mehmetaliakar.springbootaccountuserdemo.converter.UserConverter;
import com.mehmetaliakar.springbootaccountuserdemo.dto.request.UserRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.AccountResponse;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.UserResponse;
import com.mehmetaliakar.springbootaccountuserdemo.model.Account;
import com.mehmetaliakar.springbootaccountuserdemo.model.User;
import com.mehmetaliakar.springbootaccountuserdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    public UserResponse saveUser(UserRequestDto dto) {
        User entity = userConverter.toEntity(dto);
        return userConverter.toResponse(userRepository.save(entity));

    }
    public UserResponse getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.orElseThrow(()->new RuntimeException("Id bulunamadı!"));
        return userConverter.toResponse(user);
    }


    public List<UserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userConverter :: toResponse)
                .collect(Collectors.toList());
/* alternative
        List<User> userList = userRepository.findAll();
        List<UserResponse> responseList = null;
        for (int i = 0; i < userList.size();i++)
        {
            UserResponse response = userConverter.toResponse(userList.get(i));
            responseList.add(response);
        }

        return responseList;*/
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException(("Id bulunamadi")));

        userRepository.deleteById(id);
    }

    public void deleteByName(String name, String surname) {
        if (Objects.isNull(name) && Objects.isNull((surname))){
            throw new RuntimeException("Silinecek kullanıcı ismi veya soyismi boş!");
        }
        else {
            User user = userRepository.findByNameAndSurname(name, surname);
            userRepository.delete(user);
        }

    }

    public UserResponse updateUser(Long id, UserRequestDto dto) {
        User theRealUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("Id bulunamadı!"));

        if (Objects.nonNull(dto.getName()))
        {
            theRealUser.setName(dto.getName());
        }
        if (Objects.nonNull(dto.getSurname()))
        {
            theRealUser.setSurname(dto.getSurname());
        }
        if (Objects.nonNull(dto.getEmail()))
        {
            theRealUser.setEmail(dto.getEmail());
        }
        if (Objects.nonNull(dto.getPassword()))
        {
            theRealUser.setPassword(dto.getPassword());
        }
        if (Objects.nonNull(dto.getPhoneNumber()))
        {
            theRealUser.setPhoneNumber(dto.getPhoneNumber());
        }

        return userConverter.toResponse(userRepository.save(theRealUser));

    }


    public UserResponse updateAccountId(Long userId, AccountResponse response) {
        User theRealUser = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Id bulunamadi"));

        Account account = new Account();
        account.setId(response.getId());
        theRealUser.setAccount(account);

        userRepository.save(theRealUser);

        return userConverter.toResponse(userRepository.save(theRealUser));
    }
}
