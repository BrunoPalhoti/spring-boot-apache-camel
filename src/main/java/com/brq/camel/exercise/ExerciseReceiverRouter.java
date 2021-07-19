package com.brq.camel.exercise;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExerciseReceiverRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("activemq:exercise")
		.to("log:my-exercise-log");
		
	}

}