package com.capitoleconsulting.testinditex.unit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capitoleconsulting.testinditex.dto.PriceWrapper;
import com.capitoleconsulting.testinditex.utils.DTOMapper;

public class DTOMapperTest {

	private static DTOMapper dtoMapper;
	private static PriceWrapper testPriceWrapper;

	@BeforeAll
    static void setup() {
		dtoMapper = new DTOMapper() {};
		initPriceWrapperForTest();
    }

	private static void initPriceWrapperForTest() {
		testPriceWrapper = new PriceWrapper() {
			
			@Override
			public LocalDateTime getStartDate() {
				// TODO Auto-generated method stub
				return LocalDateTime.MAX;
			}
			
			@Override
			public Long getProductId() {
				// TODO Auto-generated method stub
				return 1L;
			}
			
			@Override
			public Integer getPriority() {
				// TODO Auto-generated method stub
				return 1;
			}
			
			@Override
			public Long getPriceList() {
				// TODO Auto-generated method stub
				return 1L;
			}
			
			@Override
			public Double getPrice() {
				// TODO Auto-generated method stub
				return 1.1;
			}
			
			@Override
			public LocalDateTime getEndDate() {
				// TODO Auto-generated method stub
				return LocalDateTime.MIN;
			}
			
			@Override
			public String getCurrency() {
				// TODO Auto-generated method stub
				return "EUR";
			}
			
			@Override
			public Long getBrandId() {
				// TODO Auto-generated method stub
				return 1L;
			}
		};
	}

	@Test
	void whenNullParamThenThrowsNPE() {
		assertThrows(NullPointerException.class, () -> { dtoMapper.mapEntityToResponse(null); }); 
	}

	@Test
	void whenNewParamThenInitValues() {
		final var priceDTO = dtoMapper.mapEntityToResponse(testPriceWrapper);

		assertEquals(priceDTO.getBrandId(), 1L);
		assertEquals(priceDTO.getFinalPrice(), 1.1);
		assertEquals(priceDTO.getProductId(), 1L);
		assertEquals(priceDTO.getRateId(), 1L);
		assertEquals(priceDTO.getStartDate(), LocalDateTime.MAX);
		assertEquals(priceDTO.getEndDate(), LocalDateTime.MIN);
	}
}
