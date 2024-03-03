package com.mehmetaliakar.springbootaccountuserdemo.controller;

import com.mehmetaliakar.springbootaccountuserdemo.dto.request.UserRequestDto;
import com.mehmetaliakar.springbootaccountuserdemo.dto.response.UserResponse;
import com.mehmetaliakar.springbootaccountuserdemo.model.User;
import com.mehmetaliakar.springbootaccountuserdemo.service.UserService;
import com.mehmetaliakar.springbootaccountuserdemo.shared.endpoints.UserEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserEndpoints.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public UserResponse save(@RequestBody UserRequestDto dto){
        return userService.saveUser(dto);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id)
    {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/name")
    public void deleteByName(@RequestParam String name, @RequestParam String surname){
        userService.deleteByName(name, surname);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto){
        return userService.updateUser(id, dto);
    }

}
