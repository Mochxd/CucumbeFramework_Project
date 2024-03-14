package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	private WebDriver driver;
	private By dashBoardHeader = By.xpath("//span/h6");
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getDashBoardHeader() {
		return driver.findElement(dashBoardHeader).getText();
	}
}
