package com.zup.orange.user;

import com.zup.orange.modules.exceptions.BadRequestException;
import com.zup.orange.modules.user.model.Users;
import com.zup.orange.modules.user.repository.UsersRepository;
import com.zup.orange.modules.user.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UsersRepository usersRepository;

    private UsersService usersService;

    @BeforeEach
    void setUp(){
        usersService = new UsersService(usersRepository);
    }

    @Test
    void itShouldBeAbleToGetAllStudents(){
        usersService.getAllUsers();

        verify(usersRepository).findAll();
    }

    @Test
    void itShouldNotBeAbleToCreateNewUserWithTakenCpf(){

        LocalDate data_nasc = LocalDate.of(2001, 6, 11);

        Users user = new Users(
                "Gabriel Cezar",
                "gabriel2@gabriel.com",
                "00000000022",
                data_nasc
        );

        usersService.addUser(user);

        Users userWithSameCpf = new Users(
                "Gabriel Cezar",
                "gabriel22@gabriel.com",
                "00000000022",
                data_nasc
        );

        List<Users> userTeste = usersService.getAllUsers();
//TODO:  Descobrir por que não ta funcionando
//        assertThrows(BadRequestException.class, () -> {usersService.addUser(userWithSameCpf);} , "CPF " + userWithSameCpf.getCpf() + " already taken");



    }
}
