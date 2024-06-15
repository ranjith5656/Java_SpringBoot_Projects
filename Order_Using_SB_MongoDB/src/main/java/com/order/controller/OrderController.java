package com.order.controller;

import java.util.List;


import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.domain.OrderDomain;
import com.order.helper.OrderHelper;
import com.order.response.OrderResponse;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

	@Autowired
	private OrderHelper orderHelper;
	
	@PostMapping()
	public ResponseEntity<OrderResponse<OrderDomain>> addOrder(@RequestBody OrderDomain order){
		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;
		response = orderHelper.creatOrder(order);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@PutMapping(value = "/{orderId}")
	public ResponseEntity<OrderResponse<OrderDomain>> updateOrder(@PathVariable(value = "orderId") Long orderId,  @RequestBody OrderDomain order){
		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;
		response = orderHelper.updateOrder(orderId, order);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<OrderResponse<OrderDomain>> getOrder(@PathVariable(value = "orderId") Long orderId){
		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;
		response = orderHelper.retriveOrder(orderId);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	@DeleteMapping(value = "/{bookId}")
	public ResponseEntity<OrderResponse<Void>> deleteBook(@PathVariable(value = "bookId") Long bookId){
		OrderResponse<Void> response;
		HttpStatus httpStatus;
		response = orderHelper.deleteOrder(bookId);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	@GetMapping(value = "/status/{orderStatus}")
	public ResponseEntity<OrderResponse<OrderDomain>> fetchOrderStatus(@PathVariable(value = "orderStatus")String orderStatus){
		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;
		response = orderHelper.fetchOrderStatus(orderStatus);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}
	
	
	
	
	@GetMapping(value = "/allPaginationOrders")
	public ResponseEntity<OrderResponse<List<OrderDomain>>> fetchordersWithPagination(
			@RequestParam(name = "pageNumber", defaultValue = "1") @Range(min = 1, message = "Please select positive numbers for pageNumber")Integer pageNumber, 
			@RequestParam(value = "pageSize", defaultValue = "10") @Range(min = 1, max = 30, message = "Please select positive numbers for pageSize and must be between 1-30") Integer pageSize){
		OrderResponse<List<OrderDomain>>response;
		HttpStatus httpStatus;
		response = orderHelper.fetchBooksWithPagination(pageNumber, pageSize);
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}	
	
	@GetMapping(value = "/allOrders")
	public ResponseEntity<OrderResponse<List<OrderDomain>>> fetchOrders(){
		OrderResponse<List<OrderDomain>>response;
		HttpStatus httpStatus;
		response = orderHelper.fetchOrders();
	    httpStatus = HttpStatus.valueOf(Integer.parseInt(response.getCode()));
		return new ResponseEntity<>(response, httpStatus);
	}	
	
}