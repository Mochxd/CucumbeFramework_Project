package stepDefinations;

import Pages.DashBoardPage;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinations extends BaseDefinations {
	public DashBoardPage dashBoard = new DashBoardPage(driver);
	@Given("The User is on HRMLogin page")
	public void loginTest() {
		setUp();
	}

	@When("The User enters username as {string} and password as {string}")
	public void goToHomePage(String userName, String passWord) {
		//login to application
		loginPage loginPage = new loginPage(driver);
		loginPage.setUserNamefield(userName);
		loginPage.setPasswordfield(passWord);
		dashBoard = loginPage.clickLoginButton();
	}

	@Then("The User should be able to login successfully and the Dashboard page open")
	public void verifyLogin() {
		Assert.assertEquals(dashBoard.getDashBoardHeader(), "Dashboard");
	}
	@Then("The User should be able to see error message Invalid credentials")
	public void userShouldBeAbleToSeeErrorMessageErrorMessage() {
		loginPage loginPage = new loginPage(driver);
		Assert.assertEquals(loginPage.getInvalidCredentialsMessage(),"Invalid credentials");
	}
	@After
	public void tearDown(){
		driver.quit();
	}
}