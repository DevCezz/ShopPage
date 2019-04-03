package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.csanecki.AITSI.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
