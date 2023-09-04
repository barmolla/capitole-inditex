package com.capitoleconsulting.testinditex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitoleconsulting.testinditex.dto.PriceWrapper;
import com.capitoleconsulting.testinditex.dto.SearchPriceRequestDTO;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;
import com.capitoleconsulting.testinditex.exception.ResourceNotFoundException;
import com.capitoleconsulting.testinditex.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	private static final Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

	private PriceRepository priceRepository;

	@Autowired 
	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public SearchPriceResponseDTO searchPrice(SearchPriceRequestDTO request) {
		final PriceWrapper priceWrapper = this.priceRepository.searchPrice(request.getProductID(), request.getBrandID(), request.getApplicationDate());

		if (priceWrapper == null) throw new ResourceNotFoundException("Price not found.");
		
		return this.mapEntityToResponse(priceWrapper);
	}

	/**
	 * Convert entity to response DTO.
	 * 
	 * @param price found.
	 * @return mapped response.
	 */
	private SearchPriceResponseDTO mapEntityToResponse(final PriceWrapper price) {
		final var response = new SearchPriceResponseDTO();

		response.setProductId(price.getProductId());
		response.setBrandId(price.getBrandId());
		response.setStartDate(price.getStartDate());
		response.setEndDate(price.getEndDate());
		response.setFinalPrice(price.getPrice());
		response.setRateId(price.getPriceList());

		return response;
	}
}
