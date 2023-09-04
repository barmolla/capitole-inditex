package com.capitoleconsulting.testinditex.integration;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.capitoleconsulting.testinditex.dto.SearchPriceRequestDTO;
import com.capitoleconsulting.testinditex.dto.SearchPriceResponseDTO;
import com.capitoleconsulting.testinditex.exception.ErrorDetails;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

    private static final String PRICES_ENDPOINT = "/api/v1/prices";

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void whenValidInputThenReturns200Test1() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, SearchPriceResponseDTO.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(response.getBrandId(), 1L);
        assertEquals(response.getProductId(), 35455L);
        assertEquals(response.getRateId(), 1L);
        assertEquals(response.getFinalPrice(), 35.5);
        assertEquals(response.getStartDate(), LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        assertEquals(response.getEndDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void whenValidInputThenReturns200Test2() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2020, 6, 14, 16, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, SearchPriceResponseDTO.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(response.getBrandId(), 1L);
        assertEquals(response.getProductId(), 35455L);
        assertEquals(response.getRateId(), 2L);
        assertEquals(response.getFinalPrice(), 25.45);
        assertEquals(response.getStartDate(), LocalDateTime.of(2020, 6, 14, 15, 0, 0));
        assertEquals(response.getEndDate(), LocalDateTime.of(2020, 6, 14, 18, 30, 0));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void whenValidInputThenReturns200Test3() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2020, 6, 14, 21, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, SearchPriceResponseDTO.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(response.getBrandId(), 1L);
        assertEquals(response.getProductId(), 35455L);
        assertEquals(response.getRateId(), 1L);
        assertEquals(response.getFinalPrice(), 35.5);
        assertEquals(response.getStartDate(), LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        assertEquals(response.getEndDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void whenValidInputThenReturns200Test4() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2020, 6, 15, 10, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, SearchPriceResponseDTO.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(response.getBrandId(), 1L);
        assertEquals(response.getProductId(), 35455L);
        assertEquals(response.getRateId(), 3L);
        assertEquals(response.getFinalPrice(), 30.5);
        assertEquals(response.getStartDate(), LocalDateTime.of(2020, 6, 15, 0, 0, 0));
        assertEquals(response.getEndDate(), LocalDateTime.of(2020, 6, 15, 11, 0, 0));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void whenValidInputThenReturns200Test5() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2020, 6, 16, 21, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, SearchPriceResponseDTO.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 200);
        assertEquals(response.getBrandId(), 1L);
        assertEquals(response.getProductId(), 35455L);
        assertEquals(response.getRateId(), 4L);
        assertEquals(response.getFinalPrice(), 38.95);
        assertEquals(response.getStartDate(), LocalDateTime.of(2020, 6, 15, 16, 0, 0));
        assertEquals(response.getEndDate(), LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    }

    @Test
    @DisplayName("Test 6: Price not found")
    void whenInvalidInputThenReturns404() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2022, 6, 16, 21, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, body, ErrorDetails.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 404);
        assertEquals(response.getMessage().contains("Price not found"), true);
    }

    @Test
    @DisplayName("Test 7: 415 Unsupported media type")
    void whenNullInputThenReturns415() {
		final var body = new SearchPriceRequestDTO();

		body.setApplicationDate(LocalDateTime.of(2022, 6, 16, 21, 0, 0));
		body.setBrandID(1L);
		body.setProductID(35455L);

        final var result = restTemplate
        		.postForEntity(PRICES_ENDPOINT, null, ErrorDetails.class);

        final var response = result.getBody();

        assertEquals(result.getStatusCodeValue(), 415);
        assertEquals(response, null);
    }
}
