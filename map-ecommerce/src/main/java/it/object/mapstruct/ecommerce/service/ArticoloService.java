package it.object.mapstruct.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.mapstruct.ecommerce.dto.ArticoloDTO;
import it.object.mapstruct.ecommerce.mapper.ArticoloMapper;
import it.object.mapstruct.ecommerce.model.Articolo;
import it.object.mapstruct.ecommerce.repository.ArticoloRepository;

@Service
public class ArticoloService {

	@Autowired
	private ArticoloRepository articoloRepo;

	@Autowired
	private ArticoloMapper articoloMapper;

	public List<ArticoloDTO> findAll() {
		List<ArticoloDTO> articoloDtoList = null;
		List<Articolo> articoli = articoloRepo.findAll();
		articoloDtoList = articoloMapper.toDto(articoli);
		return articoloDtoList;
	}

	public ArticoloDTO findById(Long id) {
		Optional<Articolo> itemOpt = articoloRepo.findById(id);
		ArticoloDTO itemDto = null;
		if (itemOpt.isPresent()) {
			itemDto = articoloMapper.toDto(itemOpt.get());
		}
		return itemDto;
	}
}
