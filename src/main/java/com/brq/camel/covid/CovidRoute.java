package com.brq.camel.covid;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class CovidRoute extends RouteBuilder{
	@Override
	public void configure() throws Exception {
	
		from("timer:covid?period=1000000")
		.to("https://covid19-brazil-api.now.sh/api/report/v1")
		.process(new CovidPorcessor())
		.log("${body}");
		
	}
}
