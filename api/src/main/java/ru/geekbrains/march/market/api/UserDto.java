package ru.geekbrains.march.market.api;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель пользователя")
public class UserDto {
    @Schema(description = "ID пользователя", required = true, example = "1")
    private Long id;
    @Schema(description = "Имя пользователя", required = true, example = "Bob")
    private String username;
    @Schema(description = "e-mail пользователя", required = true, example = "Bob@mail.ru")
    private String email;
    @Schema(description = "Номер телефона пользователя", required = true, example = "+79235152552")
    private String phone;
    @Schema(description = "Адрес пользователя", required = true, example = "г. Москва 3-я улица Строителей 25 квартира 12")
    private String address;

    public UserDto() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
