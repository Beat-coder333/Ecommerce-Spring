package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.object.mapstruct.ecommerce.dto.OrdineDTO;
import it.object.mapstruct.ecommerce.model.Ordine;

@Mapper(componentModel = "spring")
public interface OrdineMapper extends EntityMapper<OrdineDTO, Ordine> {

	@Override
	@Mapping(source = "user.nomeUtente", target = "username")
	@Mapping(source = "user.id", target = "idUtente")
	OrdineDTO toDto(Ordine entity);

	@Override
	Ordine toEntity(OrdineDTO dto);

}