package com.capitoleconsulting.testinditex.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitoleconsulting.testinditex.dto.SearchPriceRequestDTO;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;
import com.capitoleconsulting.testinditex.service.PriceService;

@RestController
@RequestMapping(value = "/api/v1")
public class PriceController {

	private static final Logger log = LoggerFactory.getLogger(PriceController.class);

	private PriceService priceService;

	@Autowired
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	@PostMapping(
			value = "/prices",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SearchPriceResponseDTO> searchPrice(
			@RequestBody SearchPriceRequestDTO request) {
		log.info("Finding price...");
		return ResponseEntity.ok(this.priceService.searchPrice(request));
	}
}
