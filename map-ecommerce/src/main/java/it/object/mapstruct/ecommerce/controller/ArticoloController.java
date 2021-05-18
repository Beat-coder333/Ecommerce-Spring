package it.object.mapstruct.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.mapstruct.ecommerce.dto.ArticoloDTO;
import it.object.mapstruct.ecommerce.service.ArticoloService;

@RestController
@RequestMapping("/api/articolo")
public class ArticoloController {

	private static Logger log = LoggerFactory.getLogger(ArticoloController.class);

	@Autowired
	private ArticoloService articoloServ;

	@GetMapping("/list")
	public List<ArticoloDTO> findAll() {
		log.info("ArticoloController - findAll");
		List<ArticoloDTO> listArticoli = articoloServ.findAll();
		return listArticoli;

	}

}
