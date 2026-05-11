package ma.amine.exam.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ma.amine.exam.model.ContractStatus;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

	private Long id;

	private LocalDateTime dateSouscription;

	private ContractStatus statut;

	private LocalDateTime dateValidation;

	private Double montantCotisation;

	private Integer dureeContrat;

	private Double tauxCouverture;

	private Long clientId;
}
