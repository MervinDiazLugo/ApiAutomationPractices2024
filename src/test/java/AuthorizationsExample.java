import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log
public class AuthorizationsExample {



    @Before
    public void setUp(){

    }

    @Test
    public void testAuth() throws ParseException {

        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setAccept("*/*");
        requestBuilder.addHeader("api_key", "special-key");
        //request.header("Content-Type", "application/json");

        RequestSpecification request = RestAssured.given().spec(requestBuilder.build());

        //HIT THE ENDPOINT
        Response response = request.post("/oauth/authorize");

        //REVIEW RESPONSE
        response.prettyPrint();
        Assert.assertEquals(302, response.getStatusCode());



    }
    @Test
    public void testAuthNasa() {

        RestAssured.baseURI = "https://api.nasa.gov/";
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        //request.header("Content-Type", "application/json");


        requestBuilder.setAccept("*/*");
        //requestBuilder.addHeader("api_key", "special-key");

        requestBuilder.addQueryParam("api_key", "V6qg7c4V2GVXjEEtgF9GqghcOjW19cSndM8HrmjO");

        RequestSpecification request = RestAssured.given().spec(requestBuilder.build());

        //HIT THE ENDPOINT
        Response response = request.get("/planetary/apod");

        //REVIEW RESPONSE
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());



    }

}

