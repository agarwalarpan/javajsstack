package com.arpan.javajsstack.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseApiTest {

    @LocalServerPort
    protected int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    protected JsonNode makePostRequest(String url, JSONObject request) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

        ResponseEntity<String> response = this.testRestTemplate.postForEntity(url, entity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        return objectMapper.readTree(response.getBody());
    }

    protected JsonNode makePostRequestExpectingError(String url, JSONObject request, HttpStatus status) throws JsonProcessingException {
        HttpHeaders header = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

        ResponseEntity<String> response = this.testRestTemplate.postForEntity(url, entity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(status);

        return objectMapper.readTree(response.getBody());
    }

}
