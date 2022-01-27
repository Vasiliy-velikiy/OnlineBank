package com.example.spring4.repository.impl;

import com.example.spring4.domain.entity.User;
import com.example.spring4.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

/**
 * @author dkotov
 * @since 25.01.2022
 */
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultCustomUserRepository implements CustomUserRepository {

    private final EntityManager entityManager;

    @Override
    public User get(UUID id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        User user = get(id);
        this.doSmth();
        entityManager.remove(user);
    }

    @Transactional
    public void doSmth() {
        System.out.println();
    }
}
