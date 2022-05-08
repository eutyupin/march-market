package ru.geekbrains.march.market.auth.converters;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.UserDto;
import ru.geekbrains.march.market.auth.entities.User;

@Component
@NoArgsConstructor
public class DtoToUserConverter {

    public User userDtoConvertToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
