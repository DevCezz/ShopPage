package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.AITSI.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
