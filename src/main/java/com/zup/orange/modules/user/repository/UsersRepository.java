package com.zup.orange.modules.user.repository;

import com.zup.orange.modules.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByEmail(String email);
    public Users findByCpf(String cpf);
}
