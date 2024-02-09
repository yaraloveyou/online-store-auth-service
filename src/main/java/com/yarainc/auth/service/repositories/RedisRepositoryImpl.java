package com.yarainc.auth.service.repositories;

import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "TOKEN";
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(final String login, final String token) {
        if (findByLogin(login) != null)
            hashOperations.delete(login, KEY);

        hashOperations.put(login, KEY, token);
    }

    @Override
    public void delete(final String login) {
        hashOperations.delete(login, KEY);
    }

    @Override
    @Nullable
    public String findByLogin(final String login) {
        return (String) hashOperations.get(login, KEY);
    }
}
