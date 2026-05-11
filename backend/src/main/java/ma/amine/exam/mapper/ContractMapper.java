package ma.amine.exam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import ma.amine.exam.dto.AutoContractDto;
import ma.amine.exam.dto.ContractDto;
import ma.amine.exam.dto.HabitationContractDto;
import ma.amine.exam.dto.SanteContractDto;
import ma.amine.exam.model.AutoContract;
import ma.amine.exam.model.Client;
import ma.amine.exam.model.Contract;
import ma.amine.exam.model.HabitationContract;
import ma.amine.exam.model.SanteContract;

@Mapper(componentModel = "spring")
public interface ContractMapper {

	@SubclassMapping(source = AutoContract.class, target = AutoContractDto.class)
	@SubclassMapping(source = HabitationContract.class, target = HabitationContractDto.class)
	@SubclassMapping(source = SanteContract.class, target = SanteContractDto.class)
	@Mapping(target = "clientId", source = "client.id")
	ContractDto toDto(Contract contract);

	@SubclassMapping(source = AutoContractDto.class, target = AutoContract.class)
	@SubclassMapping(source = HabitationContractDto.class, target = HabitationContract.class)
	@SubclassMapping(source = SanteContractDto.class, target = SanteContract.class)
	@Mapping(target = "client", source = "clientId")
	Contract toEntity(ContractDto contract);

	default Client mapClient(Long id) {
		if (id == null) {
			return null;
		}
		Client client = new Client();
		client.setId(id);
		return client;
	}
}
