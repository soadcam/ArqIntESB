package com.mycompany.templates.camel.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class UpdateClientProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		Client client = exchange.getIn().getBody(Client.class);
		exchange.getOut().setBody(client.getId());
	}
}
