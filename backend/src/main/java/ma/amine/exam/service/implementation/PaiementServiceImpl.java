package ma.amine.exam.service.implementation;

import ma.amine.exam.dto.PaiementDto;
import ma.amine.exam.repository.PaiementRepository;
import ma.amine.exam.service.PaiementService;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {
    private final PaiementRepository paiementRepository;

    @Override
    public PaiementDto createPaiement(PaiementDto paiement) {
        return null;
    }

    @Override
    public List<PaiementDto> getAllPaiements() {
        return List.of();
    }

    @Override
    public PaiementDto getPaiementById(Long id) {
        return null;
    }

    @Override
    public PaiementDto updatePaiement(Long id, PaiementDto paiement) {
        return null;
    }

    @Override
    public void deletePaiement(Long id) {

    }
}
