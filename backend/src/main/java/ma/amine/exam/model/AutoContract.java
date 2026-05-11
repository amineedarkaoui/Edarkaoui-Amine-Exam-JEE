package ma.amine.exam.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("AUTO")
@Data
@EqualsAndHashCode(callSuper = false)
public class AutoContract extends Contract {

	private String numeroImmatriculation;

	private String marqueVehicule;

	private String modeleVehicule;
}
