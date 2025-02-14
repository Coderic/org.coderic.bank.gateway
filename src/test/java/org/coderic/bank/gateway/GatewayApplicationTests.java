package org.coderic.bank.gateway;

import org.coderic.bank.gateway.clients.CountryClient;
import org.coderic.bank.wsdl.GetCountryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GatewayApplicationTests {

	@Autowired
	private CountryClient countryClient;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetCountryCurrency() {
		String country = "Spain";
		GetCountryResponse response = countryClient.getCountry(country);
		assertNotNull(response);
		assertEquals("EUR", response.getCountry().getCurrency().toString());
	}
}
