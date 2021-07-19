package com.brq.camel.gorest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.brq.camel.models.GoRestDataModel;
import com.brq.camel.models.GoRestLinkModel;
import com.brq.camel.models.ResponseGoRestModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoRestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		//pegando o valor vinda do body do route 
		String input = exchange.getIn().getBody(String.class);
		System.out.println("GoRest " +input);
		
		//transformando a infromação vinda do body do route em Objeto
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseGoRestModel responseGoRestModel = objectMapper.readValue(input, ResponseGoRestModel.class);
		log.info("GoRest" + responseGoRestModel.toString());
		
		//requisição rest para outros endpontys(controllers)
		RestTemplate restTemplate = new RestTemplate();	
			  //tipo		    resepitor	<-  da onde tá vindo os dados
		for (GoRestDataModel 	usuario : 		responseGoRestModel.getData()) {
			HttpEntity<GoRestDataModel> request = new HttpEntity<GoRestDataModel>(usuario);
			restTemplate.postForObject("http://localhost:8080/usuarios", request, ResponseGoRestModel.class);
		}
		
		//outra foram de instanciar classe
		GoRestLinkModel goRestLinkModel = GoRestLinkModel
				.builder()
				.next("Uma String")
				.previous("Outra String")
				.build();
		log.warn("goRestLinkModel:" + goRestLinkModel);
	}
}
