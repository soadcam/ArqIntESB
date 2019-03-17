package com.mycompany.templates.camel.services;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetAllClientsProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Client[] clients = new Client[3];
		
		Client client1 = new Client();
		client1.setId(1);
		client1.setFirstName("1");
		client1.setLastName("1");
		client1.setAge(21);
		clients[0] = client1;
		
		Client client2 = new Client();
		client2.setId(2);
		client2.setFirstName("2");
		client2.setLastName("2");
		client2.setAge(15);
		clients[1] = client2;
		
		Client client3 = new Client();
		client3.setId(3);
		client3.setFirstName("3");
		client3.setLastName("3");
		client3.setAge(34);
		clients[2] = client3;
		
		exchange.getOut().setBody(clients[0]);
	}

}
