package ma.amine.exam.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.amine.exam.dto.ClientDto;
import ma.amine.exam.repository.ClientRepository;
import ma.amine.exam.service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto client) {
        return null;
    }

    @Override
    public List<ClientDto> getAllClients() {
        return List.of();
    }

    @Override
    public ClientDto getClientById(Long id) {
        return null;
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto client) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }
}
