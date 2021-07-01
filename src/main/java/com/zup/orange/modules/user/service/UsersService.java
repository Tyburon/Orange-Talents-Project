package com.zup.orange.modules.user.service;

import com.zup.orange.modules.exceptions.BadRequestException;
import com.zup.orange.modules.user.model.Users;
import com.zup.orange.modules.user.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users addUser(Users user) {

        Users existsEmail = usersRepository.findByEmail(user.getEmail());

        Users existsCpf = usersRepository.findByCpf(user.getCpf());

        if (existsEmail != null) {
            throw new BadRequestException(
                    "Email " + user.getEmail() + " already taken");
        }

        if (existsCpf != null) {
            throw new BadRequestException(
                    "CPF " + user.getCpf() + " already taken");
        }

        return usersRepository.save(user);
    }


}
