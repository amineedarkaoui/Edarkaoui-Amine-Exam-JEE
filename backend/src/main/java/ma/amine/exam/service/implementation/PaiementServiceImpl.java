package ma.amine.exam.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ma.amine.exam.dto.PaiementDto;
import ma.amine.exam.mapper.ContractMapper;
import ma.amine.exam.mapper.PaiementMapper;
import ma.amine.exam.model.Paiement;
import ma.amine.exam.repository.PaiementRepository;
import ma.amine.exam.service.ContractService;
import ma.amine.exam.service.PaiementService;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {
	private final ContractService contractService;

	private final PaiementRepository paiementRepository;

	private final PaiementMapper paiementMapper;
	private final ContractMapper contractMapper;

	@Override
	public PaiementDto createPaiement(PaiementDto paiement) {
		Paiement paiementEntity = paiementMapper.toEntity(paiement);
		paiementEntity.setContract(contractMapper.toEntity(contractService.getContractById(paiement.getContractId())));

		return paiementMapper.toDto(paiementRepository.save(paiementEntity));
	}

	@Override
	public List<PaiementDto> getAllPaiements() {
		return paiementRepository.findAll().stream()
				.map(paiementMapper::toDto)
				.toList();
	}

	@Override
	public PaiementDto getPaiementById(Long id) {
		Paiement paiement = paiementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Paiement not found with id: " + id));
		return paiementMapper.toDto(paiement);
	}

	@Override
	public PaiementDto updatePaiement(Long id, PaiementDto paiement) {
		paiementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Paiement not found with id: " + id));

		Paiement toSave = paiementMapper.toEntity(paiement);
		toSave.setId(id);
		Paiement savedPaiement = paiementRepository.save(toSave);
		return paiementMapper.toDto(savedPaiement);
	}

	@Override
	public void deletePaiement(Long id) {
		Paiement paiement = paiementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Paiement not found with id: " + id));
		paiementRepository.delete(paiement);
	}
}
