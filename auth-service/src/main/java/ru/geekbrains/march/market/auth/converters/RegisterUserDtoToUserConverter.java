package ru.geekbrains.march.market.auth.converters;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.geekbrains.march.market.api.RegisterUserDto;
import ru.geekbrains.march.market.api.UserDto;
import ru.geekbrains.march.market.auth.entities.User;

@Component
@NoArgsConstructor
public class RegisterUserDtoToUserConverter {

    public User registerUserDtoConvertToUser(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setId(null);
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(registerUserDto.getPassword());
        user.setEmail(registerUserDto.getEmail());
        user.setAddress(registerUserDto.getAddress());
        user.setPhone(registerUserDto.getPhone());
        return user;
    }
}
