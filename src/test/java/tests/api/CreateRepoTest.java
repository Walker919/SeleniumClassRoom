package tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.base.BaseClass;
import com.utility.Auth;
import com.utility.CommonUtilFunctions;
import com.utility.CreateURL;
import com.utility.PayloadGenerator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.pojoclasses.CreateRepoPOJO;

import java.io.IOException;

public class CreateRepoTest {

    Response response;
    ObjectMapper objectMapper;
    String endPoint = CreateURL.getBaseURI("/user/repos");
    String bearerToken = Auth.BEARER_TOKEN;

    @Test
    public void createRepositoryTest() throws IOException {
        String requestPayload = PayloadGenerator.generateStringPayload("createRepo.json");
        response = BaseClass.postRequest(endPoint, requestPayload, bearerToken);
        String responseString = response.getBody().asString();

        Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"),
                CommonUtilFunctions.getResponseKeyValue(requestPayload, "name"));

        Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"),
                CommonUtilFunctions.getResponseKeyValue(requestPayload, "description"));
    }

    @Test
    public void createRepoTestCase() throws JsonProcessingException {
        CreateRepoPOJO requestPayload = new CreateRepoPOJO();
        requestPayload.setName("Api-testing-restcall-2");
        requestPayload.setDescription("Repository creat prin REST Assured 11");

        objectMapper = new ObjectMapper();
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
        response = BaseClass.postRequest(endPoint, payload, bearerToken);
        String responseString = response.getBody().asString();

        Assert.assertEquals(requestPayload.getName(), CommonUtilFunctions.getResponseKeyValue(responseString, "name"));
        Assert.assertEquals(requestPayload.getDescription(), CommonUtilFunctions.getResponseKeyValue(responseString, "description"));
    }
}