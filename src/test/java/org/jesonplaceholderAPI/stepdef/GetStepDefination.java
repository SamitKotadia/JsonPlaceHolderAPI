package org.jesonplaceholderAPI.stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.jesonplaceholderAPI.utility.ConfigureFileReader;
import org.jesonplaceholderAPI.utility.RestServices;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetStepDefination {

    public Response response;
    public RestServices services = new RestServices();
    ConfigureFileReader configFileReader = new ConfigureFileReader("API-Env.properties");

    @Given("^I have base uri$")
    public void i_have_base_uri() throws Throwable {
        assertThat(configFileReader.getApiEnvironment(), is(endsWith("https://jsonplaceholder.typicode.com")));
    }

    @When("^I execute \"([^\"]*)\" request to add Title and Body in Application$")
    public void i_execute_request_to_add_Title_and_Body_in_Application(String requestType) throws Throwable {
        switch (requestType){
            case "post":
                response = services.postService();
                break;
            case "get":
                response = services.getService();
                break;
            case "delete":
                response = services.deleteService();
                break;

        }
    }

    @Then("^I should see status code as \"([^\"]*)\"$")
    public void i_should_see_status_code_as(int expectedStatusCode) throws Throwable {
        response.then().statusCode(expectedStatusCode);
    }



}
