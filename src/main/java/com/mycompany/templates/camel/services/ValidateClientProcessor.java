package com.mycompany.templates.camel.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.web.client.RestTemplate;

public class ValidateClientProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		Client client = exchange.getIn().getBody(Client.class);
		Document document = null;
		try {
			String identifyDocumentName = "cc";
			String formatRESTUrl = "http://localhost/OperadorDestino/api/client/%s/%s";
			RestTemplate restTemplate = new RestTemplate();
			document = restTemplate.getForObject(String.format(formatRESTUrl, client.getIdNumber(), identifyDocumentName), Document.class);			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		exchange.getOut().setBody(document);
	}
}