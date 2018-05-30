package com.me.demo.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dexcoder.ws.Country;
import com.dexcoder.ws.Currency;
import com.dexcoder.ws.GetCountryRequest;
import com.dexcoder.ws.GetCountryResponse;

/**
 * 服务端配置Endpoint
 * 
 * @author ljh
 *
 */
@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://www.dexcoder.com/ws"; // 与xsd中的targetNamespace保持一致
	private static final String LOCAL_PART = "getCountryRequest"; // 与xsd中保持一致
	
	// 注解PayloadRoot 和ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = LOCAL_PART)
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		Country poland = new Country();
		poland.setName("Poland-" + request.getName());
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);
		response.setCountry(poland);
		return response;
	}
}