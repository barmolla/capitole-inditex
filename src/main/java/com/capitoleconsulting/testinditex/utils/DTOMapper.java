package com.capitoleconsulting.testinditex.utils;

import com.capitoleconsulting.testinditex.dto.PriceWrapper;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;

public interface DTOMapper {

	/**
	 * Convert result of JPA query (wrapper) to response DTO.
	 * 
	 * @param price found.
	 * @return mapped response.
	 */
	default SearchPriceResponseDTO mapEntityToResponse(final PriceWrapper price) {
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
