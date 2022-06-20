package org.jesonplaceholderAPI;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.jesonplaceholderAPI.utility.ConfigureFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        tags = "@getService",
        plugin = "json:target/cucumber.json")

public class RunCukesTest {

    @BeforeClass
    public static void setBaseURL() {
        ConfigureFileReader configFileReader = new ConfigureFileReader("API-Env.properties");
        RestAssured.baseURI = configFileReader.getApiEnvironment();
    }
}

