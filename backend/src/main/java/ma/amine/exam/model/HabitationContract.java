package ma.amine.exam.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("HABITATION")
@Data
@EqualsAndHashCode(callSuper = false)
public class HabitationContract extends Contract {

	@Enumerated(EnumType.STRING)
	private TypeLogement typeLogement;

	private String adresseLogement;

	private Double superficie;
}
