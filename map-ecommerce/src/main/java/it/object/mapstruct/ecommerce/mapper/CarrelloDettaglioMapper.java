package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;

import it.object.mapstruct.ecommerce.dto.CarrelloDettaglioDTO;
import it.object.mapstruct.ecommerce.model.CarrelloDettaglio;

@Mapper(componentModel = "spring")
public interface CarrelloDettaglioMapper extends EntityMapper<CarrelloDettaglioDTO, CarrelloDettaglio> {

	@Override
	CarrelloDettaglioDTO toDto(CarrelloDettaglio entity);

	@Override
	CarrelloDettaglio toEntity(CarrelloDettaglioDTO dto);

}
