package service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Adresse;
import model.Client;
import model.Login;
import model.Titre;
import repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public void createClient(Client client) {
		if (client != null) {
			clientRepository.save(client);
		}
	}

	public void deleteClient(Client client) {
		if (client != null) {
			clientRepository.delete(client);
		}
	}

	public void deleteClientByName(String name) {
		clientRepository.delete(clientRepository.findByClientName(name));
	}

	public void modifyClientName(Client client, String name) {
		if (name != null) {
			client.setClientName(name);
			clientRepository.save(client);
		}
	}

	public void modifyClientCellNumber(Client client, Integer cellNumber) {
		if (cellNumber != null) {
			client.setNumeroTel(cellNumber);
			clientRepository.save(client);
		}

	}

	public void modifyClientFaxNumber(Client client, Integer faxNumber) {
		client.setNumeroFax(faxNumber);
		clientRepository.save(client);
	}

	public void modifyClientMail(Client client, String mail) {
		if (mail != null) {
			client.setMail(mail);
			clientRepository.save(client);
		}

	}

	public void modifyClientAdress(Client client, Adresse adress) {
		if (adress != null) {
			client.setAdresse(adress);
			clientRepository.save(client);
		}
	}

}
