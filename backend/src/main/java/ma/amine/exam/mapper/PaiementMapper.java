package ma.amine.exam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.amine.exam.dto.PaiementDto;
import ma.amine.exam.model.Contract;
import ma.amine.exam.model.Paiement;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

	@Mapping(target = "contractId", source = "contract.id")
	PaiementDto toDto(Paiement paiement);

	@Mapping(target = "contract", source = "contractId")
	Paiement toEntity(PaiementDto paiement);

	default Contract mapContract(Long id) {
		if (id == null) {
			return null;
		}
		Contract contract = new Contract() {
		};
		contract.setId(id);
		return contract;
	}
}
