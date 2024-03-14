package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseDefinations {
    protected WebDriver driver;
    public int TIMEOUT = 10;
    
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver(getChromeOptions());
        goHome();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
    @AfterTest
	public void tearDown(){
		driver.quit();
	}
}
