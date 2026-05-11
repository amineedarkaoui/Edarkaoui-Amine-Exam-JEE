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
import ma.amine.exam.dto.PaiementDto;
import ma.amine.exam.service.PaiementService;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

	private final PaiementService paiementService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PaiementDto createPaiement(@RequestBody PaiementDto paiement) {
		return paiementService.createPaiement(paiement);
	}

	@GetMapping
	public List<PaiementDto> getAllPaiements() {
		return paiementService.getAllPaiements();
	}

	@GetMapping("/{id}")
	public PaiementDto getPaiementById(@PathVariable Long id) {
		return paiementService.getPaiementById(id);
	}

	@PutMapping("/{id}")
	public PaiementDto updatePaiement(@PathVariable Long id, @RequestBody PaiementDto paiement) {
		return paiementService.updatePaiement(id, paiement);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePaiement(@PathVariable Long id) {
		paiementService.deletePaiement(id);
	}
}
