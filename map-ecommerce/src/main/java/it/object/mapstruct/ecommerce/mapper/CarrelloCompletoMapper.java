package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.object.mapstruct.ecommerce.dto.CarrelloCompletoDTO;
import it.object.mapstruct.ecommerce.model.Carrello;

@Mapper(componentModel = "spring")
public interface CarrelloCompletoMapper extends EntityMapper<CarrelloCompletoDTO, Carrello> {

	@Override
	@Mapping(source = "id", target = "cartId")
	CarrelloCompletoDTO toDto(Carrello entity);

	@Override
	Carrello toEntity(CarrelloCompletoDTO dto);

}
