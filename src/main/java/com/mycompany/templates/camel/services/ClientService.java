package com.mycompany.templates.camel.services;

public interface ClientService {
	int addClient(Client client);
	int updateClient(Client client);
	Client getAllClients();
}
