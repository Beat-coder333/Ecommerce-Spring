package it.object.mapstruct.ecommerce.mapper;

import org.mapstruct.Mapper;

import it.object.mapstruct.ecommerce.dto.RigaOrdineDTO;
import it.object.mapstruct.ecommerce.model.RigaOrdine;

@Mapper(componentModel = "spring")
public interface OrdineRigaMapper extends EntityMapper<RigaOrdineDTO, RigaOrdine> {

	@Override
	RigaOrdineDTO toDto(RigaOrdine entity);

	@Override
	RigaOrdine toEntity(RigaOrdineDTO dto);
}
