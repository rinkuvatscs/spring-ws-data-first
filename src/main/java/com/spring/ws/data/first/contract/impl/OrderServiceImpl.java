package com.spring.ws.data.first.contract.impl;

import java.util.Calendar;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Component;

import com.liverestaurant.orderservice.schema.Order;
import com.spring.ws.data.first.contract.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	@Override
	public String placeOrder(Order order) {
	     System.out.println("Order has been placed. Order Info is : " + ObjectUtils.toString(order));
	        return getRandomOrderRefNo();
	}

	@Override
	public boolean cancelOrder(String refNumber) {
		 System.out.println("Order has been placed. Order Reference : " + refNumber);
	        return true;
	}

	private String getRandomOrderRefNo() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		return "Ref-" + year + "-" + month + "-" + day + "-" + Math.random();

	}
}
