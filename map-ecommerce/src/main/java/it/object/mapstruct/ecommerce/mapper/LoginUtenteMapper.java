package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.model.Utente;

@Mapper(componentModel = "spring")
public interface LoginUtenteMapper {

	LoginUtenteMapper INSTANCE = Mappers.getMapper(LoginUtenteMapper.class);

	@Mapping(source = "nomeUtente", target = "username")
	LoginUtenteDTO usertToDto(Utente utente);

}
