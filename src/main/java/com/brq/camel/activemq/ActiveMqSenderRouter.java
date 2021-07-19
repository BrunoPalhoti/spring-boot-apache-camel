package com.brq.camel.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
	from("timer:active-mq-timer?period=1000000")
	.to("activemq:my-active-mq")
	.log("${body}");
	
	}
}
