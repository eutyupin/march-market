package ru.geekbrains.march.market.auth.tests;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.march.market.auth.entities.Role;
import ru.geekbrains.march.market.auth.repositories.RoleRepository;
import ru.geekbrains.march.market.auth.repositories.UserRepository;
import ru.geekbrains.march.market.auth.services.RoleService;
import ru.geekbrains.march.market.auth.services.UserService;

import java.util.Optional;

@SpringBootTest(classes = RoleService.class)
public class RoleServiceTest {
    @Autowired
    private RoleService roleService;

    @MockBean
    private RoleRepository roleRepository;

    @Test
    public void findByNameTest() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        Mockito.doReturn(Optional.of(role))
                .when(roleRepository)
                .findByName("ADMIN");
        roleService.getUserRole();
        Mockito.verify(roleRepository, Mockito.times(1)).findByName(ArgumentMatchers.any());

    }
}
