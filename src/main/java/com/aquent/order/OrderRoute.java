package com.aquent.order;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.springframework.stereotype.Component;

@Component
public class OrderRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		BindyFixedLengthDataFormat bindyFixedLengthDataFormat = new BindyFixedLengthDataFormat(
				com.aquent.dto.Order.class);

		BindyCsvDataFormat bindyCsvDataFormat = new BindyCsvDataFormat(com.aquent.dto.OrderOutput.class);

		from("{{route.from}}").unmarshal(bindyFixedLengthDataFormat).to("bean:handleOrder").marshal(bindyCsvDataFormat)
				.to("{{route.to}}");

		// create route while will read from database, create file and put into
		// route.from directory so existing process will pick up file and

		// from("bean:dbSrc") --this bean will give all data in Order object format
		// .to("bean:handleOrder") --reuse exising logic to sort the data
		// .to("bean:dbDes");

		// similar way create rest endpoint for getting the file uploaded by user and
		// parse and sort using existing code and return to user

	}

}