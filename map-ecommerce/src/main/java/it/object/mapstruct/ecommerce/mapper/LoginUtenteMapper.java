package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.object.mapstruct.ecommerce.dto.LoginUtenteDTO;
import it.object.mapstruct.ecommerce.model.Utente;

@Mapper(componentModel = "spring")
public interface LoginUtenteMapper extends EntityMapper<LoginUtenteDTO, Utente> {

	@Override
	@Mapping(source = "nomeUtente", target = "username")
	LoginUtenteDTO toDto(Utente utente);

	@Override
	@Mapping(target = "password", ignore = true)
	Utente toEntity(LoginUtenteDTO dto);

}
