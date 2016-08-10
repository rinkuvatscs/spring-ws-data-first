package com.spring.ws.data.first.contract;

import com.liverestaurant.orderservice.schema.Order;

public interface OrderService {

	public String placeOrder(Order order) ;
	
	public boolean cancelOrder(String refNumber) ;
	
}
