package it.object.mapstruct.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<ArticoloDTO>> findAll() {
		log.info("ArticoloController - findAll");
		List<ArticoloDTO> listArticoli = articoloServ.findAll();
		ResponseEntity<List<ArticoloDTO>> resp = null;
		if (listArticoli.isEmpty()) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			resp = new ResponseEntity<>(listArticoli, HttpStatus.OK);
		}
		return resp;

	}

	@GetMapping("/idArticolo/{id}")
	public ResponseEntity<ArticoloDTO> findArticle(@PathVariable Long id) {
		log.info("ArticoloController - find Article");
		ArticoloDTO item = articoloServ.findById(id);
		ResponseEntity<ArticoloDTO> resp = new ResponseEntity<>(item, HttpStatus.OK);
		if (item == null) {
			resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return resp;

	}

}
