package it.object.mapstruct.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.ArticoloDTO;
import it.object.mapstruct.ecommerce.service.ArticoloService;

@RestController
@RequestMapping("/api/articolo")
public class ArticoloController {

	@Autowired
	private ArticoloService articoloServ;

	@GetMapping("/list")
	public List<ArticoloDTO> findAll() {
		List<ArticoloDTO> listArticoli = articoloServ.findAll();
		return listArticoli;

	}

}
