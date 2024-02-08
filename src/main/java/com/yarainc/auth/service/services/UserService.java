package com.yarainc.auth.service.services;

import com.yarainc.auth.service.domains.Role;
import com.yarainc.auth.service.domains.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final List<User> users;

    public UserService() {
        this.users = List.of(
                // Переписать под БД
                new User("user1", "1234", "Пользователь", "1", Collections.singleton(Role.USER)),
                new User("admin1", "admin", "Администратор", "1", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }
}
