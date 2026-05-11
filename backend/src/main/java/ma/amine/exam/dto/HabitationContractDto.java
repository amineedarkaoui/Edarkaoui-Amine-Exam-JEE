package ma.amine.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ma.amine.exam.model.TypeLogement;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HabitationContractDto extends ContractDto {

	private TypeLogement typeLogement;

	private String adresseLogement;

	private Double superficie;
}
