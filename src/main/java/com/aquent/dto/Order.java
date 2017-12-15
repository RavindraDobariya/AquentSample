package com.aquent.dto;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(paddingChar = ' ', ignoreTrailingChars = true, skipHeader = true)
public class Order implements Comparable<Order> {

	public static final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

	
	@DataField(pos = 1, length = 12, trim = true)
	private String item;

	@DataField(pos = 13, length = 10, trim = true)
	private String date;

	public String getItem() {
		return item;
	}

	public String getDate() {
		return new java.text.SimpleDateFormat(DATE_FORMAT)
				.format(new java.util.Date(Long.parseLong(date)));
	}


	@Override
	public int compareTo(Order o) {

		return this.item.toLowerCase().compareTo(o.getItem());
	}

	@Override
	public String toString() {
		return "OrderFixedLenght [item=" + item + ", date=" + getDate() + "]";
	}

}
