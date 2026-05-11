package ma.amine.exam.service;

import java.util.List;

import ma.amine.exam.dto.ClientDto;

public interface ClientService {

	ClientDto createClient(ClientDto client);

	List<ClientDto> getAllClients();

	ClientDto getClientById(Long id);

	ClientDto updateClient(Long id, ClientDto client);

	void deleteClient(Long id);
}
