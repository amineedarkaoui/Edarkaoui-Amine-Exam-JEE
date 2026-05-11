package ma.amine.exam.service;

import java.util.List;

import ma.amine.exam.dto.PaiementDto;

public interface PaiementService {

	PaiementDto createPaiement(PaiementDto paiement);

	List<PaiementDto> getAllPaiements();

	PaiementDto getPaiementById(Long id);

	PaiementDto updatePaiement(Long id, PaiementDto paiement);

	void deletePaiement(Long id);
}
