package com.brq.camel.exercise;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("timer:rest-http?period=10000")
		.to("https://gorest.co.in/public/v1/users")
		.to("activemq:exercise")
		.log("${body}");
	}

}
