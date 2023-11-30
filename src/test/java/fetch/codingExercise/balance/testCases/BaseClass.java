package fetch.codingExercise.balance.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import fetch.codingExercise.balance.utilities.ReadConfig;

public class BaseClass {
	public static Logger logger;
	WebDriver driver;
	public String baseUrl = ReadConfig.getApplicationUrl();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		
		if(browser.equals("chrome")) {
			launchChromeBrowser();
		}else if(browser.equals("firefox")) {
			launchFirefoxBrowser();
		}
		logger=Logger.getLogger("fetchCodingExcercise");
		PropertyConfigurator.configure("Log4j.properties");
	}

	
	private void launchFirefoxBrowser() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", ReadConfig.getFirefoxDriverPath());
		driver = new FirefoxDriver();

		
	}

	private void launchChromeBrowser() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ReadConfig.getChromeDriverPath());
		driver = new ChromeDriver();
	}

	@AfterClass
	public void terminate() {
		driver.quit();
	}

}
