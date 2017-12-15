package com.aquent.order.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.aquent.dto.Order;
import com.aquent.dto.OrderOutput;

@Component
public class HandleOrder implements Processor {

	public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

	@Override
	public void process(Exchange exchange) throws Exception {

		List<Order> orderList = (List<Order>) exchange.getIn().getBody();
		orderList.sort((Order o1, Order o2) -> o1.getItem().toLowerCase().compareTo(o2.getItem().toLowerCase()));
		List<OrderOutput> finalList = new ArrayList<>();
		orderList.forEach(order -> {
			OrderOutput orderOutput = new OrderOutput();
			orderOutput.setItem(order.getItem());
			orderOutput.setDate(order.getDate());
			finalList.add(orderOutput);

		});
		exchange.getOut().setBody(finalList);
	}

}
