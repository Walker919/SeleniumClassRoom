package tests.api;

import com.restapi.base.BaseClass;
import com.utility.CommonUtilFunctions;
import com.utility.CreateURL;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRepoLanguagesTest {

    @Test
    public void getListRepoLanguages(){

        String endPoint = CreateURL.getBaseURI("/repos/Walker919/ApiTesting/languages");
        Response response = BaseClass.getRequest(endPoint);
        String responseString = response.getBody().asString();
        System.out.println("Response: " + responseString);

        Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 200);
    }
}
