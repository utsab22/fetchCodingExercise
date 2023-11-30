package fetch.codingExercise.balance.testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fetch.codingExercise.balance.pageObjectModel.HomePage;
import fetch.codingExercise.balance.utilities.ReadConfig;

public class TC_Find_Fake_Bar_Fetch_V_11_2_0 extends BaseClass {
	private WebDriver webDriver;
	private HomePage homePage;

	@Test
	public void findFakeBarInMinimumSteps() {
		webDriver = driver;
		webDriver.get(baseUrl);
		logger.info("Url Opened: " + baseUrl);
		homePage = new HomePage(webDriver) ;
		
		int start = 1;
		int end = 8;
		int fakeCoin = 0;
		int mid;
		
		while(true) {
			mid = (start+end)/2;
			putCoinsAndTakeMeasurement(start, end, mid);
			String measurement = readMeasurement();
            clickOnReset();
            if (measurement.equals("=")) {
            	break;
    		} else if (measurement.equals("<")) {
    			end = mid;
    			fakeCoin = start;
    		} else if(measurement.equals(">")) {
    			start = mid +1;
    			fakeCoin = end;
    		}
            if((start-end)==0) break;
		}
		clickOnFakeCoin(fakeCoin);
		String alertMessage = handleAndGetAlertMessage();
		printWeighingInfo(homePage.getWeighingList());
		
		if (alertMessage.contains(ReadConfig.getSuccessAlertMessage())) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	private String handleAndGetAlertMessage() {
		Alert alert = webDriver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);
		alert.accept();
		return alertText;
	}

	private void clickOnFakeCoin(int fakeCoin) {
		String strValue = String.valueOf(fakeCoin);
		System.out.println("The fake gold coin is " + strValue);
		clickOnFakeCoin(strValue);
	}

	public void putCoinsAndTakeMeasurement(int start, int end, int mid) {
		putCoinsOnLeftBowl(start, mid);
		putCoinsOnRightBowl(mid + 1, end);
		clickOnWeigh();
	}
	
	public String readMeasurement() {
		return homePage.readMeasurement();
	}
	
	public void clickOnReset() {
		homePage.clickOnReset();
		System.out.println("Clicked on Reset.");
	}
	
	
	public void clickOnFakeCoin(String value) {
		homePage.clickOnCoinByValue(value);
		logger.info("Clicked On Fake Coin Bar");
	}
	

	public void clickOnWeigh() {
		homePage.clickOnWeigh();
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				String measurement = homePage.readMeasurement();
				return !measurement.equals("?");
			}
		});
		System.out.println("Clicked on Weigh.");
	}


	public void putCoinsOnLeftBowl(int start, int end) {
		while (end >= start) {
			homePage.fillLeftBowl(String.valueOf(start));
			System.out.println("Putting " + start + " on the left bowl.");
			start++;
		}
		logger.info("Value Inserted On Left Bowl Input");
	}
	
	public void printWeighingInfo(List<String> weighingList) {
		int index=0;
		System.out.println("Following comparison were made: ");
		for(String comparison:weighingList) {
			System.out.println(++index + ". " + comparison);
		}
		
		System.out.println("The number of comparison is: "+ weighingList.size());
		
	}

	public void putCoinsOnRightBowl(int start, int end) {
		while (start <= end) {
			homePage.fillRightBowl(String.valueOf(start));
			System.out.println("Putting " + start + " on the right bowl.");
			start++;
		}
		logger.info("Value Inserted On Right Bowl Input");
	}
}
