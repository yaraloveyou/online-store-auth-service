package com.yarainc.auth.service.repositories;

import java.util.Map;

public interface RedisRepository {
    void add(final String login, final String accessToken);
    void delete(final String login);
    public String findByLogin(final String login);
}
