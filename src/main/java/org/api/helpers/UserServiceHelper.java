package org.api.helpers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.api.constants.EndPoints;
import org.api.model_pojo.Users;
import org.api.utils.ConfigManager;
import io.restassured.response.Response;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class UserServiceHelper {

    Faker faker = new Faker();

    Users users = new Users();
    //we need to read the config variables
    //Rest Assured about the URI & Port/endpoint
    //make a get request to this URI and send the data to TestGetUser

    private static final String BASE_URL = ConfigManager.getInstance().getString("baseURI");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public UserServiceHelper(){

        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Users> getAllUsers(){

        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(EndPoints.GET_ALL_USERS)
                .andReturn();

        Type type = new TypeReference<List<Users>>(){}.getType();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");

        List<Users> userList = response.as(type);
        return userList;

    }

    public String getSingleUsers(){

        Response response = RestAssured

                .given().log().all()
                .when()
                .get(EndPoints.GET_SINGLE_USERS, 2);
                // Get the status code of the response
                int statusCode = response.getStatusCode();
                Assert.assertEquals(statusCode, 200);

                // Print the response body
                String responseBody = response.getBody().asString();
                System.out.println(responseBody);

                assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");

                return responseBody;
    }

    public Response CreateUser(){

//        users.setId(faker.idNumber().hashCode());
        users.setId(10);
        users.setName("nabeel");
        users.setEmail("nabeel@gmail.com");
        users.setGender("Male");
        users.setStatus("inactive");

        Response response = RestAssured
                .given().log().all().when().body(users)
                .contentType(ContentType.JSON)
                .post(EndPoints.CREATE_USERS)
                .andReturn();

        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "CREATED");
        return response;

    }

    public Response patchUser(Integer id){

        users.setName("nabeelUpdated");
        users.setEmail("nabeelUpdated@gmail.com");
        users.setGender("Male");
        users.setStatus("nabeelUpdated_Active");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when().body(users)
                .patch(EndPoints.UPDATE_USERS)
                .andReturn();

        assertTrue((response.getStatusCode() == HttpStatus.SC_OK));

        return response;

    }
    public Response deleteUser(Integer id){

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .log().all()
                .when()
                .delete(EndPoints.DELETE_USER)
                .andReturn();

        assertTrue(response.getStatusCode()==HttpStatus.SC_OK);

        return response;
    }

}
