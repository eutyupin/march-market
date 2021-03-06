package ru.geekbrains.march.market.auth.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.UserDto;
import ru.geekbrains.march.market.auth.entities.User;
import ru.geekbrains.march.market.auth.services.UserService;

@Component
@RequiredArgsConstructor
public class UserToDtoConverter {
    private final UserService userService;

    public UserDto userConvertToDtoByName(String username) {
        User user = userService.findByUsername(username).get();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    public UserDto userConvertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
