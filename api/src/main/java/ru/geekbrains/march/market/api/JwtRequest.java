package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель запроса данных пользователя для авторизации")
public class JwtRequest {
    @Schema(description = "Имя пользователя", required = true, example = "user")
    private String username;
    @Schema(description = "Пароль пользователя", required = true, example = "12345")
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
