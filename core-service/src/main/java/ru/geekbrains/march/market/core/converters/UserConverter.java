package ru.geekbrains.march.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.UserDto;
import ru.geekbrains.march.market.core.entities.User;
import ru.geekbrains.march.market.core.services.UserService;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final UserService userService;

    public UserDto userConvertToDto(String username) {
        User user = userService.findByUsername(username).get();
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
