package ma.amine.exam.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.amine.exam.model.TypePaiement;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDto {

	private Long id;

	private LocalDate date;

	private BigDecimal montant;

	private TypePaiement type;

	private Long contractId;
}
