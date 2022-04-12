package ru.geekbrains.march.market.converters;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.dtos.UserDto;
import ru.geekbrains.march.market.entities.User;
import ru.geekbrains.march.market.services.UserService;

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
