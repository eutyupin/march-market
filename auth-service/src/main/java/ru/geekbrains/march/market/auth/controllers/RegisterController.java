package ru.geekbrains.march.market.auth.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.march.market.api.JwtRequest;
import ru.geekbrains.march.market.api.JwtResponse;
import ru.geekbrains.march.market.api.RegisterUserDto;
import ru.geekbrains.march.market.auth.converters.RegisterUserDtoToUserConverter;
import ru.geekbrains.march.market.auth.exceptions.AppError;
import ru.geekbrains.march.market.auth.services.UserService;
import ru.geekbrains.march.market.auth.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
@Tag(name = "Регистрация", description = "Методы регистрации нового пользователя")
public class RegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserDtoToUserConverter registerUserDtoToUserConverter;

    @Operation(
            summary = "Регистрация пользователя",
            responses = {
                    @ApiResponse(
                            description = "Пользователь успешно создан", responseCode = "201"
                    )
            }
    )
    @PostMapping("/register")
    public void registerNewUser(@RequestBody RegisterUserDto registerUserDto) {
        String bcryptCachedPassword = passwordEncoder.encode(registerUserDto.getPassword());
        registerUserDto.setPassword(bcryptCachedPassword);
        registerUserDto.setConfirmPassword(bcryptCachedPassword);
        userService.createNewUser(registerUserDtoToUserConverter.registerUserDtoConvertToUser(registerUserDto));
    }
}
