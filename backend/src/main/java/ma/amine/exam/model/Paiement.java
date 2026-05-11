package ma.amine.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;

	private BigDecimal montant;

	@Enumerated(EnumType.STRING)
	private TypePaiement type;

	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;
}
