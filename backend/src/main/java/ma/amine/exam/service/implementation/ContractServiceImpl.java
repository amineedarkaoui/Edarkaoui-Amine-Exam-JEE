package ma.amine.exam.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.amine.exam.dto.ContractDto;
import ma.amine.exam.mapper.ContractMapper;
import ma.amine.exam.model.Contract;
import ma.amine.exam.repository.ContractRepository;
import ma.amine.exam.service.ContractService;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    @Override
    public ContractDto createContract(ContractDto contract) {
        Contract savedContract = contractRepository.save(contractMapper.toEntity(contract));
        return contractMapper.toDto(savedContract);
    }

    @Override
    public List<ContractDto> getAllContracts() {
        return contractRepository.findAll().stream()
                .map(contractMapper::toDto)
                .toList();
    }

    @Override
    public ContractDto getContractById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found with id: " + id));
        return contractMapper.toDto(contract);
    }

    @Override
    public ContractDto updateContract(Long id, ContractDto contract) {
        contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found with id: " + id));

        Contract toSave = contractMapper.toEntity(contract);
        toSave.setId(id);
        Contract savedContract = contractRepository.save(toSave);
        return contractMapper.toDto(savedContract);
    }

    @Override
    public void deleteContract(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contract not found with id: " + id));
        contractRepository.delete(contract);
    }
}
