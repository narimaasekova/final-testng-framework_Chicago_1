package gov.usd.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gov.usd.utilities.Driver;



public class NarimaPage {

	private WebDriver driver;

	public NarimaPage() {

		driver = Driver.getDriver();

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='nav-dropdown__parent-label'])[2]")
	public WebElement profiles;

	@FindBy(xpath = "//ul[@class='nav-children__list']/li/a[.='States']")
	public WebElement profilesStateOption;

	@FindBy(xpath = "//tr[@class='state-list__body-row']/td[2]")
	public List<WebElement> statesAwardedAmount;

	@FindBy(xpath = "//*[contains(text(),'Sort table by ascending awarded amount')]/..")
	public WebElement clickToGetAssendingOrder;

	@FindBy(xpath = "//*[contains(text(),'Sort table by descending awarded amount')]/..")
	public WebElement clickToGetDecendingOrder;
	
	@FindBy(xpath = "//tr[@class='state-list__body-row']/td[1]")
	public List<WebElement> states;
	
	@FindBy(xpath = "/*[contains(text(),'Sort table by descending state')]/..")
	public WebElement clickToGetDecendingStatesOrder;
	
	
	

	/*this method  converting the given states Amount from String to Double
	 * and returns List of double
	 */

	public List<Double> convertingToDouble() {

		List<Double> prices = new ArrayList<>();

		for (WebElement price : statesAwardedAmount) {

			String priceStr = price.getText().replace("$", "").replace(",", "");

			prices.add(Double.valueOf(priceStr));
		}
		return prices;
	}

}


