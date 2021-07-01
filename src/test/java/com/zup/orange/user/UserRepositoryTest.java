package com.zup.orange.user;

import com.zup.orange.modules.user.model.Users;
import com.zup.orange.modules.user.repository.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @AfterEach
    void tearDown(){
        usersRepository.deleteAll();
    }

    @Test
    void itShouldBeAbleToCreateNewUser(){
        LocalDate data_nasc = LocalDate.of(2001, 6, 11);

        Users user = new Users(
                "Gabriel Cezar",
                "gabriel@gabriel.com",
                "00000000021",
                data_nasc
        );

        Users savedUser = usersRepository.save(user);

        Optional<Users> getSavedUser = usersRepository.findById(savedUser.getId());

        assertThat(getSavedUser).isNotEmpty();

    }

}
