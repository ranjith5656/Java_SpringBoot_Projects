package com.order.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.domain.OrderDomain;
import com.order.response.OrderResponse;
import com.order.response.StatusType;
import com.order.service.OrderService;

/**
 * The BookHelper class provides to interact with the BookService.
 */
@Component
public class OrderHelper {

	private static final Logger logger = LoggerFactory.getLogger(OrderHelper.class);

	private static final String ERROR_MSG = "Exception Occured while executing service";

	@Autowired
	private OrderService orderService;

	
	public OrderResponse<OrderDomain> creatOrder(OrderDomain orderDomain) {

		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;

		try {
			OrderDomain saveOrder = orderService.creatOrder(orderDomain);

			if (saveOrder != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
						"Order Details are added successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While Creating Orders,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While Creating Orders");
		}
		return response;
	}
	
	public OrderResponse<OrderDomain> updateOrder(Long bookId, OrderDomain orderDomain) {

		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;

		try {
			OrderDomain updateExistingOrder = orderService.updateOrder(bookId, orderDomain);

			if (updateExistingOrder != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
						"Order Details are updated successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While updating Orders,please try again later.");
			}

		}  catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While updating Books");
		}
		return response;
	}

	
	public OrderResponse<OrderDomain> retriveOrder(Long orderId) {

		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;

		try {
			OrderDomain getOrder = orderService.getOrderById(orderId);

			if (getOrder != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(getOrder, StatusType.SUCCESS, httpStatus.value(),
						"Order Details are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While fetch Orders,please try again later.");
			}
		}  catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Orders");
		}
		return response;
	}
    /**
     * Deletes a book
     * @param bookId The based on ID of the book to be deleted.
     * @return  A BookResponse object containing the status and message
     */
	public OrderResponse<Void> deleteOrder(Long orderId) {

		OrderResponse<Void> response;
		HttpStatus httpStatus;

		try {
			orderService.deleteOrderById(orderId);
			httpStatus = HttpStatus.OK;
			response = OrderResponse.builResponse(null, StatusType.SUCCESS, httpStatus.value(),
					"Order Details are Delete successfully.");

		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}

	
	public OrderResponse<OrderDomain> fetchOrderStatus(String orderStatus) {

		OrderResponse<OrderDomain> response;
		HttpStatus httpStatus;

		try {
			OrderDomain getBook = orderService.getOrderByStatus(orderStatus);

			if (getBook != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(getBook, StatusType.SUCCESS, httpStatus.value(),
						"OrderStatus are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While orderNames,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching orderNames");
		}
		return response;
	}

	/**
     * Fetch all active books 
     *
     * @return A BookResponse object containing the status, message and data.
     */
	
	/**
     * Fetch books with pagination 
     *
     * @param pageNumber The page number for pagination.
     * @param pageSize   The number of books per page.
     * @return A BookResponse object containing the status, message.
     */
	public OrderResponse<List<OrderDomain>> fetchBooksWithPagination(Integer pageNumber, Integer pageSize) {

		OrderResponse<List<OrderDomain>> response;
		HttpStatus httpStatus;

		try {
			List<OrderDomain> orderDomain = orderService.getAllOrdersWithPagination(pageNumber, pageSize);

			if (orderDomain != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(orderDomain, StatusType.SUCCESS, httpStatus.value(),
						"All Books are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While Book,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}
	
	public OrderResponse<List<OrderDomain>> fetchOrders() {

		OrderResponse<List<OrderDomain>> response;
		HttpStatus httpStatus;

		try {
			List<OrderDomain> orderDomain = orderService.getAllOrders();

			if (orderDomain != null) {
				httpStatus = HttpStatus.OK;
				response = OrderResponse.builResponse(orderDomain, StatusType.SUCCESS, httpStatus.value(),
						"All Books are fetch successfully.");
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
						"Error Occurred While Book,please try again later.");
			}
		} catch (Exception e) {
			logger.error(ERROR_MSG, e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			response = OrderResponse.builResponse(null, StatusType.ERROR, httpStatus.value(),
					"Error Occurred While fetching Books");
		}
		return response;
	}

}
