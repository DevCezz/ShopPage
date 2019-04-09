package pl.csanecki.AITSI.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.csanecki.AITSI.entity.Order;
import pl.csanecki.AITSI.entity.OrderProduct;
import pl.csanecki.AITSI.repository.OrderRepository;
import pl.csanecki.AITSI.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public void saveOrder(Order order) {
		for(OrderProduct orderProduct : order.getOrderProducts()) {
			orderProduct.setOrder(order);
		}
		
		orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	@Override
	public Set<Order> getAllUniqueOrders() {
		return new HashSet<>(orderRepository.findAll());
	}

	@Override
	public Set<Order> getUniqueOrdersByUserEmail(String email) {
		List<Order> orders = orderRepository.findAllUserOrders(email);

		return new HashSet<>(orders);
	}
}











