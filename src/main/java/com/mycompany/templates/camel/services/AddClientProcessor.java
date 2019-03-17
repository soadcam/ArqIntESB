package com.mycompany.templates.camel.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AddClientProcessor implements Processor {

	int currentId = 1;
	@Override
	public void process(Exchange exchange) throws Exception {
		Client client = exchange.getIn().getBody(Client.class);
		client.setId(currentId++);
		exchange.getOut().setBody(client.getId());
	}
}