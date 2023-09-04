package com.capitoleconsulting.testinditex.dto;

import java.time.LocalDateTime;

public interface PriceWrapper {
	Long getPriceList();
	LocalDateTime getStartDate();
	LocalDateTime getEndDate();
	Integer getPriority();
	Double getPrice();
	String getCurrency();
	Long getProductId();
	Long getBrandId();
}
