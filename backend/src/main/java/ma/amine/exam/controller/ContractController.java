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
import ma.amine.exam.dto.ContractDto;
import ma.amine.exam.service.ContractService;

@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
public class ContractController {

	private final ContractService contractService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContractDto createContract(@RequestBody ContractDto contract) {
		return contractService.createContract(contract);
	}

	@GetMapping
	public List<ContractDto> getAllContracts() {
		return contractService.getAllContracts();
	}

	@GetMapping("/{id}")
	public ContractDto getContractById(@PathVariable Long id) {
		return contractService.getContractById(id);
	}

	@PutMapping("/{id}")
	public ContractDto updateContract(@PathVariable Long id, @RequestBody ContractDto contract) {
		return contractService.updateContract(id, contract);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteContract(@PathVariable Long id) {
		contractService.deleteContract(id);
	}
}
