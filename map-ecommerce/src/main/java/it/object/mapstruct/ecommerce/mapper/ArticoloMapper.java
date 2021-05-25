package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;

import it.object.mapstruct.ecommerce.dto.ArticoloDTO;
import it.object.mapstruct.ecommerce.model.Articolo;

@Mapper(componentModel = "spring")
public interface ArticoloMapper extends EntityMapper<ArticoloDTO, Articolo> {

	@Override
	ArticoloDTO toDto(Articolo entity);

	@Override
	Articolo toEntity(ArticoloDTO dto);

}
