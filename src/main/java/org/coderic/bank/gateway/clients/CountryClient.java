package org.coderic.bank.gateway.clients;

import org.coderic.bank.wsdl.GetCountryRequest;
import org.coderic.bank.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://api.coderic.co/bank/endpoint/ws/countries", request,
                        new SoapActionCallback(
                                "http://coderic.org/bank/ws/GetCountryRequest"));

        return response;
    }

}
