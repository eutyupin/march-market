package ru.geekbrains.march.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.march.market.core.entities.Category;
import ru.geekbrains.march.market.core.entities.Order;
import ru.geekbrains.march.market.core.entities.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public List<Order> findAllByUser(User user);
}
