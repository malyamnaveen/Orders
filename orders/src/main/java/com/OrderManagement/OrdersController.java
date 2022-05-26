package com.OrderManagement;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ordermanagement")
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@PostMapping("/placeOrder")
	String Orders(@RequestBody Orders newOrder) {
		return service.placeOrder(newOrder);
		
	}
	@PutMapping("/updateOrders/{id}")
	String updateOrder(@PathVariable Integer id,@RequestBody Orders updatedOrder) {
		return service.updateOrderById(id,updatedOrder);
	}
	@DeleteMapping("/deletrorder/{id}")
	String deleteOrder(@PathVariable Integer id) {
		return service.deleteOrderById(id);
	}
	
	@GetMapping("/getOrders")
	Iterable<Orders> getAllOrders(@PathVariable Integer id){
	return service.getAllOrders(id);
	}
	
	@GetMapping("/getOrders/{id}")
	Optional<Orders> getOrderById(@PathVariable Integer id) {
	  return service.getOrderById(id);
	}
}
