package com.brq.camel.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		from("activemq:my-active-mq")
		.to("log:my-active-mq-log"); 
	}
}
