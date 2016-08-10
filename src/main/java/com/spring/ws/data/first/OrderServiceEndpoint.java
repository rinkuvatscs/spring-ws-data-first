package com.spring.ws.data.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.liverestaurant.orderservice.schema.PlaceOrderRequest;
import com.liverestaurant.orderservice.schema.PlaceOrderResponse;
import com.spring.ws.data.first.contract.OrderService;

@Endpoint
public class OrderServiceEndpoint {

	public static final String NAMESPACE = "http://www.liverestaurant.com/OrderService/schema" ;
	
	
	@Autowired
	OrderService orderServiceImpl;
	
	@PayloadRoot(localPart = "placeOrderRequest", namespace = NAMESPACE)
	@ResponsePayload
	public PlaceOrderResponse placeOrder(@RequestPayload PlaceOrderRequest placeOrderRequest) {
		PlaceOrderResponse placeOrderResponse = new PlaceOrderResponse() ;
		String response = orderServiceImpl.placeOrder(placeOrderRequest.getOrder());
		placeOrderResponse.setRefNumber(response);
		return placeOrderResponse ;
	}
}
