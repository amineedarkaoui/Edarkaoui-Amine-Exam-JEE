package ma.amine.exam.service.implementation;

import ma.amine.exam.dto.ContractDto;
import ma.amine.exam.repository.ContractRepository;
import ma.amine.exam.service.ContractService;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    @Override
    public ContractDto createContract(ContractDto contract) {
        return null;
    }

    @Override
    public List<ContractDto> getAllContracts() {
        return List.of();
    }

    @Override
    public ContractDto getContractById(Long id) {
        return null;
    }

    @Override
    public ContractDto updateContract(Long id, ContractDto contract) {
        return null;
    }

    @Override
    public void deleteContract(Long id) {

    }
}
