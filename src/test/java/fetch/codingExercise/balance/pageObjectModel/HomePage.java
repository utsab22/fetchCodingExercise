package fetch.codingExercise.balance.pageObjectModel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	WebDriver driver;
	
	@FindBy(id="weigh")
	WebElement btnWeigh;
	
	@FindBy(xpath="//button[@id='reset'][text()='Reset']")
	WebElement btnReset;
	
	@FindBy(xpath="//div[@id='root']//div[@class='result']//button")
	WebElement btnResult;
	
	@FindBy(xpath="//div[@class='game-board']//input[@data-side='left']")
    List<WebElement> leftBowlInputList;	
	
	@FindBy(xpath="//div[@class='game-board']//input[@data-side='right']")
    List<WebElement> rightBowlInputList;
	
	@FindBy(xpath="//div[@class='game-info']//li")
	List<WebElement> gameInfoLists;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickOnWeigh() {
		btnWeigh.click();
	}
	
	public void clickOnReset() {
		btnReset.click();
	}
	
	public String readMeasurement() {
		return btnResult.getText();
	}
	
	public void clickOnCoinByValue(String value) {
		String xpath = "//div[@class='coins']/button[text()='" + value + "']";
		WebElement coinRequested = driver.findElement(By.xpath(xpath));
		coinRequested.click();
	}
	
	public void fillIfEmpty(List<WebElement> inputElementList, String value){
		for(WebElement inputField: inputElementList) {
			if(inputField.getAttribute("value").isEmpty()) {
				inputField.sendKeys(value);
				break;
			}
		}
	}
	
	public void fillLeftBowl(String value) {
		fillIfEmpty(leftBowlInputList, value);
	}
	
	public void fillRightBowl(String value) {
		fillIfEmpty(rightBowlInputList, value);
	}
	
	public List<String> getWeighingList(){
		List<String> weighingList = new ArrayList<String>();
		for(WebElement li: gameInfoLists) {
			weighingList.add(li.getText());
		}
		return weighingList;
	}
}