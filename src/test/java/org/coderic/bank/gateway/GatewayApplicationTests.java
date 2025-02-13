package org.coderic.bank.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GatewayApplicationTests {

	@Autowired
	private countryClient countryClient;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetCountryCurrency() {
		String country = "Spain";
		GetCountryResponse response = countryClient.getCountry(country);
		assertNotNull(response);
		assertEquals("EUR", response.getCountry().getCurrency());
	}
}
