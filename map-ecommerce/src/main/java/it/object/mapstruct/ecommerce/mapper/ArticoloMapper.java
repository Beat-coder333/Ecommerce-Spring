package it.object.mapstruct.ecommerce.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.object.mapstruct.ecommerce.dto.ArticoloDTO;
import it.object.mapstruct.ecommerce.model.Articolo;

@Mapper(componentModel = "spring")
public interface ArticoloMapper {

	ArticoloMapper INSTANCE = Mappers.getMapper(ArticoloMapper.class);

	ArticoloDTO artToArtDto(Articolo articolo);

	List<ArticoloDTO> artToArtDto(List<Articolo> articoli);

}
