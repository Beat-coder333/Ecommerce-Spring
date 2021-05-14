package it.object.mapstruct.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.object.mapstruct.ecommerce.dto.CarrelloDettaglioDTO;
import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;

@Mapper(componentModel = "spring")
public interface CarrelloDettaglioMapper {

	CarrelloDettaglioMapper INSTANCE = Mappers.getMapper(CarrelloDettaglioMapper.class);

	@Mapping(source = "cart.id", target = "idCarrello")
	@Mapping(source = "articolo.id", target = "idArticolo")
	CarrelloDettaglioDTO cartDetToDto(CarrelloDettaglio cartDetail);

	@Mapping(target = "cart", ignore = true)
	@Mapping(target = "articolo", ignore = true)
	CarrelloDettaglio cartDtoToEntity(CarrelloDettaglioDTO cartDetDto);

	@Mapping(source = "cart.id", target = "idCarrello")
	@Mapping(source = "articolo.id", target = "idArticolo")
	List<CarrelloDettaglioDTO> cartDetToDto(List<CarrelloDettaglio> listCart);
}
