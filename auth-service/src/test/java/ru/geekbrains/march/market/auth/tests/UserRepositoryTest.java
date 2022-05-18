package ru.geekbrains.march.market.auth.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.geekbrains.march.market.auth.entities.User;
import ru.geekbrains.march.market.auth.repositories.UserRepository;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByUserNameTest() {
        User foundedUser = userRepository.findByUsername("bob").get();
        Assertions.assertEquals("bob", foundedUser.getUsername());
        Assertions.assertEquals("bob_johnson@gmail.com", foundedUser.getEmail());
    }

    @Test
    public void findByIdTest() {
        User foundedUser = userRepository.findById(1L).get();
        Assertions.assertEquals("bob", foundedUser.getUsername());
        Assertions.assertEquals("bob_johnson@gmail.com", foundedUser.getEmail());
    }

}
