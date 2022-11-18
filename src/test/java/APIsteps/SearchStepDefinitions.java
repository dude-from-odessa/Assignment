package APIsteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import utils.APIConstants;

import java.util.List;
import java.util.Map;

public class SearchStepDefinitions {



    Response response;

    @When("he calls search endpoint for item {string}")
    public void he_calls_search_endpoint_for_item(String item) {
        response = SerenityRest.given().get(APIConstants.SEARCH_ITEM+item);
    }

    @When("status code {int} checked")
    public void status_code_checked(Integer code) {
        response.then().assertThat().statusCode(code);
    }

    @Then("he sees the results displayed for {string} and check the {string} from body")
    public void he_sees_the_results_displayed_for_and_check_the_from_body(String item, String title) {
        List<Map<String, String>> array=response.body().jsonPath().get();
        for (Map<String, String> map : array) {
            boolean actual = map.get(title).toLowerCase().contains(item);
            if(actual==false){
                System.out.println("Title is : \""+map.get(title)+"\". And not contains : \""+item+"\"");
            }
            Assert.assertTrue(actual);
        }
    }

    @Then("he does not see the results and object {string} has key {string} with status true")
    public void he_does_not_see_the_results_and_object_has_key_with_status_true(String object, String key) {
        Map<String, Boolean> actualData = response.body().jsonPath().get(object);
        Boolean actualValue = actualData.get(key);
        Assert.assertTrue(actualValue);
    }
}
