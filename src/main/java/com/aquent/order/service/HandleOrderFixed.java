package com.aquent.order.service;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.aquent.dto.Order;

@Component
public class HandleOrderFixed implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		
		List<List<Order>> data = (List<List<Order>>) exchange.getIn().getBody();
		for (List<Order> line : data) {

			for (Order order : line) {
				System.out.println(order.getItem() + " " + order.getDate());
			}
		}

	}

}
