package com.OrderManagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	
	@Autowired
	OrdersRepository repo;
	
	Iterable<Orders> getAllOrders(Integer Id){
		return repo.findAll();
	}
	
	Optional<Orders> getOrderById(Integer id) {
		return repo.findById(id);
	}
		
		String deleteOrderById(Integer id) {
		repo.deleteById(id);
	    return "orderdeleted";
			
	}
		String updateOrderById(Integer id,Orders updatedOrder) {
			if(repo.existsById(id)) {
				repo.save(updatedOrder);
				return "Order Updated";
			}
			else {
				return"order not found,please check orderid";
			}
		}
		String placeOrder(Orders newOrder) {
			repo.save(newOrder);
			return"Order placed";
		}

	
		}

		