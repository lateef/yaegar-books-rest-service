package com.yaegar.yaegarbooksrestservice.steps;

import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.repository.UserRepository;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserSteps extends SpringBootIntegrationTest {
    private String uri;
    private RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() {
        request = RestAssured.with();
        uri = "http://localhost:" + port + "/register";
    }

    @Given("^a phone number (\\+\\d+) and password (\\w+)$")
    public void aPhoneNumberAndPassword(String phoneNumber, String password) {
        Map<String, Object> phone = new HashMap<>();
        phone.put("number", phoneNumber);

        Map<String, Object> user = new HashMap<>();
        user.put("phoneNumber", phoneNumber);
        user.put("password", password);
        user.put("phones", Collections.singletonList(phone));

        request.given()
                .contentType("application/json")
                .body(user);
    }

    @When("^a sign up request is sent to the server with these details$")
    public void aSignUpRequestIsSentToTheServerWithTheseDetails() {
        response = request.when().post(uri);
    }

    @Then("^a user with phone number (\\+\\d+) should be saved in the user table$")
    public void aUserWithPhoneNumberShouldBeSavedInTheUserTable(String phoneNumber) {
        Optional<User> user = userRepository.findOptionalByPhoneNumber(phoneNumber);
        assertTrue(user.isPresent());
    }

    @And("^the status code is (\\d+) and phone number is (\\+\\d+)$")
    public void theStatusCodeIsAndPhoneNumberIs(int statusCode, String phoneNumber) {
        assertEquals(statusCode, response.statusCode());
        response.then().body("phoneNumber", equalTo(phoneNumber));
    }
}
