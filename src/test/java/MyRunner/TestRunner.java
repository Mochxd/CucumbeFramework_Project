package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "/ProjectNonCommerceWebsite/src/test/resources/Features",
        glue = "LoginStepDefinations.java",
        tags = "@loginTest"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
