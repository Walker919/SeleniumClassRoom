package tests.api;

import com.restapi.base.BaseClass;
import com.utility.Auth;
import com.utility.CommonUtilFunctions;
import com.utility.CreateURL;
import com.utility.PayloadGenerator;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteRepoTest {

    private static Logger log = Logger.getLogger(DeleteRepoTest.class.getName());
    String endPoint = CreateURL.getBaseURI("/repos/Walker919/");

    @Test
    public void deleteRepoTest() throws IOException {

        String payload = PayloadGenerator.generateStringPayload("createRepo.json");
        String deleteEndPoint = endPoint + CommonUtilFunctions.getResponseKeyValue(payload, "name");
        Response response = BaseClass.deleteRequest(deleteEndPoint, Auth.BEARER_TOKEN);

        Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
    }
}
