package ma.amine.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AutoContractDto extends ContractDto {

	private String numeroImmatriculation;

	private String marqueVehicule;

	private String modeleVehicule;
}
