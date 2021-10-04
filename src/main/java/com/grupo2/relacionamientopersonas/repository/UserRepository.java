package com.grupo2.relacionamientopersonas.repository;

import com.grupo2.relacionamientopersonas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long idUser);
    User findUserByUsername(String username);

    Boolean existsByUsername(String username);
}
