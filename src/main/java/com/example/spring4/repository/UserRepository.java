package com.example.spring4.repository;

import com.example.spring4.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author dkotov
 * @since 02.12.2021
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
