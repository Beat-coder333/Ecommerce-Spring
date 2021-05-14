package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.object.mapstruct.ecommerce.dto.CarrelloDTO;
import it.object.mapstruct.ecommerce.model.Carrello;

@Mapper(componentModel = "spring")
public interface CarrelloMapper {

	CarrelloMapper INSTANCE = Mappers.getMapper(CarrelloMapper.class);

	@Mapping(source = "user.id", target = "idUtente")
	CarrelloDTO cartToDto(Carrello cart);
}
