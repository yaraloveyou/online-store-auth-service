package com.yarainc.auth.service.services;

import com.yarainc.auth.service.domains.User;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public interface UserService {
    Optional<User> getByLogin(@NonNull String login);
}
