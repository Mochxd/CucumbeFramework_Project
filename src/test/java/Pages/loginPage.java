package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	private WebDriver driver;
	private By userNameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By  InvalidCredentialsMessage = By.xpath("//div/p[contains(@class, 'oxd-text oxd-text--p oxd')]");

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUserNamefield(String userName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
		driver.findElement(userNameField).sendKeys(userName);
	}
	public void setPasswordfield(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		driver.findElement(passwordField).sendKeys(password);
	}
	public DashBoardPage clickLoginButton() {
		driver.findElement(loginButton).submit();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
        return dashBoardPage;
	}

	public String getInvalidCredentialsMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidCredentialsMessage));
		return driver.findElement(InvalidCredentialsMessage).getText();
	}

}
