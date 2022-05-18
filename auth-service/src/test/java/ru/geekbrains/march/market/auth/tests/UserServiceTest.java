package ru.geekbrains.march.market.auth.tests;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.march.market.auth.entities.User;
import ru.geekbrains.march.market.auth.repositories.UserRepository;
import ru.geekbrains.march.market.auth.services.UserService;

import java.util.Optional;

@SpringBootTest(classes = UserService.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findByUserNameTest() {
        User user = new User();
        user.setId(1L);
        user.setUsername("bob");
        user.setEmail("bob_johnson@gmail.com");
        Mockito.doReturn(Optional.of(user))
                .when(userRepository)
                .findByUsername("bob");
        userRepository.findByUsername("bob");
        Mockito.verify(userRepository, Mockito.times(1)).findByUsername(ArgumentMatchers.any());
    }
}
