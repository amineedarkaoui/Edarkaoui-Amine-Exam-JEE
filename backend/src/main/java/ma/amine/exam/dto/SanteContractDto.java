package ma.amine.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ma.amine.exam.model.NiveauCouverture;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SanteContractDto extends ContractDto {

	private NiveauCouverture niveauCouverture;

	private Integer nombrePersonnesCouvertes;
}
