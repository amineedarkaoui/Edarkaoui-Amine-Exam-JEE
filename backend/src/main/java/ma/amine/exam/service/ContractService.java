package ma.amine.exam.service;

import java.util.List;

import ma.amine.exam.dto.ContractDto;

public interface ContractService {

	ContractDto createContract(ContractDto contract);

	List<ContractDto> getAllContracts();

	ContractDto getContractById(Long id);

	ContractDto updateContract(Long id, ContractDto contract);

	void deleteContract(Long id);
}
