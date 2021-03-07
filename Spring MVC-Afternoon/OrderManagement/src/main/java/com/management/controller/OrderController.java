package com.management.controller;

import com.management.model.Order;
import com.management.model.OrderProduct;
import com.management.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({ "/orders" })
public class OrderController {
	@Autowired
	OrderService orderService;

	// a) POST API to Create an Order
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping({ "/createOrder" })
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return new ResponseEntity(this.orderService.createOrder(order), HttpStatus.CREATED);
	}

	// b) POST API to Add items in an Order
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping({ "/addItem/{orderId}" })
	public ResponseEntity<Order> addItemToOrder(@PathVariable(required = true, name = "orderId") int orderId,
			@RequestBody OrderProduct item) {
		if (this.orderService.checkOrderItem(orderId) == false) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(this.orderService.addItemToOrder(orderId, item), HttpStatus.CREATED);
	}

	// c) PUT API to Update Item details
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping({ "/orderItems/{orderId}" })
	public ResponseEntity<List<OrderProduct>> getAllOrderItems(
			@PathVariable(required = true, name = "orderId") int orderId) {
		if (this.orderService.checkOrderItem(orderId) == false) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(this.orderService.getOrderItems(orderId), HttpStatus.OK);
	}

	// d) GET API to Get all the Item details in an Order
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping({ "/allOrders" })
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity(this.orderService.getAllOrders(), HttpStatus.OK);
	}

	// e) DELETE API to Delete an Item in an Order
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping({ "/updateItem/{orderId}/{itemId}" })
	public ResponseEntity<OrderProduct> updateItem(@PathVariable(required = true, name = "itemId") int itemId,
			@PathVariable(required = true, name = "orderId") int orderId, @RequestBody OrderProduct item) {
		if (this.orderService.checkOrderItem(orderId) == false) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(this.orderService.updateItem(itemId, orderId, item), HttpStatus.OK);
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping({ "/deleteItem/{orderId}/{itemId}" })
	public ResponseEntity<Boolean> deleteItemFromOrder(@PathVariable(required = true, name = "orderId") int orderId,
			@PathVariable(required = true, name = "itemId") int itemId) {
		if (this.orderService.checkOrderItem(orderId) == false) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(this.orderService.removeItemFromOrder(orderId, itemId), HttpStatus.OK);
	}

	// f) DELETE API to Delete an Order
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping({ "/deleteOrder/{orderId}" })
	public ResponseEntity<Boolean> deleteOrder(@PathVariable(required = true, name = "orderId") int orderId) {
		if (this.orderService.checkOrderItem(orderId) == false) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(this.orderService.removeOrder(orderId), HttpStatus.OK);
	}
}
