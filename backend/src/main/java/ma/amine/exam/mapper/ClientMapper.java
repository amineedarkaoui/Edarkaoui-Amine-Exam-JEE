package ma.amine.exam.mapper;

import org.mapstruct.Mapper;

import ma.amine.exam.dto.ClientDto;
import ma.amine.exam.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientDto toDto(Client client);

	Client toEntity(ClientDto client);
}
