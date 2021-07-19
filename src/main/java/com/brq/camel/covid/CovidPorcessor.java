package com.brq.camel.covid;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.brq.camel.models.ResponseCovidModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CovidPorcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String input = exchange.getIn().getBody(String.class);
		System.out.println("Covid" +input);
		
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseCovidModel responseCovidModel = objectMapper.readValue(input, ResponseCovidModel.class);
		
		System.out.println(responseCovidModel.toString());
		
	}
}
