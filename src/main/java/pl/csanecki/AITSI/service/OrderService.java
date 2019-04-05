package pl.csanecki.AITSI.service;

import java.util.List;
import java.util.Set;

import pl.csanecki.AITSI.entity.Order;

public interface OrderService {
	void saveOrder(Order order);
	List<Order> getAllOrders();
	Set<Order> getAllUniqueOrders();
}
