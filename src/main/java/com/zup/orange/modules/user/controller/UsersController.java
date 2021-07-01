package com.zup.orange.modules.user.controller;

import com.zup.orange.modules.user.model.Users;
import com.zup.orange.modules.user.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UsersController {

    @Autowired
    private final UsersService usersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> listar(){return usersService.getAllUsers();}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> criar(@Valid @RequestBody Users user) {
        Users savedUser = usersService.addUser(user);


        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }
}
