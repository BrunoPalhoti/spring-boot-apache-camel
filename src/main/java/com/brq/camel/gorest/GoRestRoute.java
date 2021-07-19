package com.brq.camel.gorest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GoRestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("timer:goRest?period=1000000")
		.to("https://gorest.co.in/public/v1/users")
		.process(new GoRestProcessor())
		.log("${body}");
	}
}
