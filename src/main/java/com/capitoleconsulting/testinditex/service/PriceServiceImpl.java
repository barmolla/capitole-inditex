package com.capitoleconsulting.testinditex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitoleconsulting.testinditex.dto.SearchPriceRequestDTO;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;
import com.capitoleconsulting.testinditex.exception.ResourceNotFoundException;
import com.capitoleconsulting.testinditex.repository.PriceRepository;
import com.capitoleconsulting.testinditex.utils.DTOMapper;

@Service
public class PriceServiceImpl implements PriceService {

	private static final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

	private PriceRepository priceRepository;
	private DTOMapper dtoMapperImpl;

	@Autowired 
	public PriceServiceImpl(
			PriceRepository priceRepository,
			DTOMapper dtoMapperImpl) {
		this.priceRepository = priceRepository;
		this.dtoMapperImpl = dtoMapperImpl;
	}

	@Override
	public SearchPriceResponseDTO searchPrice(SearchPriceRequestDTO request) {
		final var productID = request.getProductID();
		final var brandID = request.getBrandID();
		final var applicationDate = request.getApplicationDate();

		log.info("Searching price by product ID: {}. brandID: {}. applicationDate: {}.", productID, brandID, applicationDate);

		final var priceWrapper = this.priceRepository.searchPrice(productID, brandID, applicationDate);

		if (priceWrapper == null) throw new ResourceNotFoundException("Price not found.");

		log.info("Price found with ID: {}", priceWrapper.getPriceList());

		return this.dtoMapperImpl.mapEntityToResponse(priceWrapper);
	}
}
