package ma.amine.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ma.amine.exam.dto.ClientDto;
import ma.amine.exam.service.ClientService;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClientDto createClient(@RequestBody ClientDto client) {
		return clientService.createClient(client);
	}

	@GetMapping
	public List<ClientDto> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping("/{id}")
	public ClientDto getClientById(@PathVariable Long id) {
		return clientService.getClientById(id);
	}

	@PutMapping("/{id}")
	public ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto client) {
		return clientService.updateClient(id, client);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
	}
}
