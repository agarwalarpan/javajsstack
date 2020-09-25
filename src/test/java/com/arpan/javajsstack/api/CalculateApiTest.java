package com.arpan.javajsstack.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;


class CalculateApiTest extends BaseApiTest {

	private final String calcUrl = "/calculator/calculate";

	@Test
	void calculatorAddsTwoNumbers() throws JSONException, JsonProcessingException {
		JSONObject request = new JSONObject();
		request.put("a", 1);
		request.put("b", 2);
		request.put("type", "addition");

		JsonNode response = makePostRequest(getBaseUrl() + calcUrl, request);

		assertThat(response).isNotNull();
		assertThat(response.path("result").asInt()).isEqualTo(3);

	}


	@Test
	void calculateThrowsCorrectException() throws JSONException, JsonProcessingException {
		JSONObject request = new JSONObject();
		request.put("a", 1);
		request.put("b", 0);
		request.put("type", "division");

		JsonNode response = makePostRequest(getBaseUrl() + calcUrl, request, HttpStatus.INTERNAL_SERVER_ERROR);

		assertThat(response.path("message").asText()).isEqualTo("");
	}

}
