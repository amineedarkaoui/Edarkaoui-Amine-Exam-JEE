package ma.amine.exam.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.amine.exam.dto.ClientDto;
import ma.amine.exam.mapper.ClientMapper;
import ma.amine.exam.model.Client;
import ma.amine.exam.repository.ClientRepository;
import ma.amine.exam.service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto createClient(ClientDto client) {
        Client savedClient = clientRepository.save(clientMapper.toEntity(client));
        return clientMapper.toDto(savedClient);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto client) {
        clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        Client toSave = clientMapper.toEntity(client);
        toSave.setId(id);
        Client savedClient = clientRepository.save(toSave);
        return clientMapper.toDto(savedClient);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        clientRepository.delete(client);
    }
}
