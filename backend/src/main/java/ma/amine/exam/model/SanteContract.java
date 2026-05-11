package ma.amine.exam.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("SANTE")
@Data
@EqualsAndHashCode(callSuper = false)
public class SanteContract extends Contract {

	@Enumerated(EnumType.STRING)
	private NiveauCouverture niveauCouverture;

	private Integer nombrePersonnesCouvertes;
}
