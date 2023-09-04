package com.capitoleconsulting.testinditex.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capitoleconsulting.testinditex.dto.PriceWrapper;
import com.capitoleconsulting.testinditex.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	/**
	 * Find first price by product ID, brand ID and start date
	 * taking into account price priority.
	 * 
	 * @param productId
	 * @param brandId
	 * @param startDate
	 * @return
	 */
	@Query(nativeQuery = true, 
			value = "SELECT "
			+ "pri.price, "
			+ "pri.price_list as priceList, "
			+ "pri.start_date as startDate, "
			+ "pri.end_date as endDate, "
			+ "prod.id as productId, "
			+ "brand.id as brandId "
			+ "FROM Price pri, Product prod, Brand brand "
			+ "WHERE prod.id = ?1 AND brand.id = ?2 AND pri.start_date <= ?3 AND pri.end_date >= ?3 "
			+ "ORDER BY pri.priority DESC "
			+ "LIMIT 1")
	PriceWrapper searchPrice(Long productId, Long brandId, LocalDateTime startDate);
}
