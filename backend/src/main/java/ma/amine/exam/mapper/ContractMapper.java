package ma.amine.exam.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
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

	@Mapping(target = "clientId", source = "client.id")
	AutoContractDto toDto(AutoContract contract);

	@Mapping(target = "clientId", source = "client.id")
	HabitationContractDto toDto(HabitationContract contract);

	@Mapping(target = "clientId", source = "client.id")
	SanteContractDto toDto(SanteContract contract);

	@SubclassMapping(source = AutoContractDto.class, target = AutoContract.class)
	@SubclassMapping(source = HabitationContractDto.class, target = HabitationContract.class)
	@SubclassMapping(source = SanteContractDto.class, target = SanteContract.class)
	@Mapping(target = "client", source = "clientId")
	Contract toEntity(ContractDto contract);

	@Mapping(target = "client", source = "clientId")
	AutoContract toEntity(AutoContractDto contract);

	@Mapping(target = "client", source = "clientId")
	HabitationContract toEntity(HabitationContractDto contract);

	@Mapping(target = "client", source = "clientId")
	SanteContract toEntity(SanteContractDto contract);

	@ObjectFactory
	default Contract createContract(ContractDto contract) {
		if (contract == null) {
			return null;
		}
		if (contract instanceof AutoContractDto) {
			return new AutoContract();
		}
		if (contract instanceof HabitationContractDto) {
			return new HabitationContract();
		}
		if (contract instanceof SanteContractDto) {
			return new SanteContract();
		}
		throw new IllegalArgumentException("Unsupported contract dto type: " + contract.getClass().getName());
	}

	default Client mapClient(Long id) {
		if (id == null) {
			return null;
		}
		Client client = new Client();
		client.setId(id);
		return client;
	}
}
