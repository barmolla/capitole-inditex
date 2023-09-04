package com.capitoleconsulting.testinditex.service;

import com.capitoleconsulting.testinditex.dto.SearchPriceRequestDTO;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;

public interface PriceService {

	/**
	 * Search price given the following input data:
	 * 
	 * - Application date;
	 * - Product ID;
 	 * - Brand ID.
	 * 
	 * @param request DTO that represents requests for this case.
	 * @TODO @return price found.
	 */
	SearchPriceResponseDTO searchPrice(SearchPriceRequestDTO request);
}

