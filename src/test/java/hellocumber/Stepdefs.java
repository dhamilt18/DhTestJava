package hellocumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Stepdefs {
@Given("I am at the homepage and verify elements")
public void at_homepage() {
	System.setProperty("webdriver.chrome.driver", "C:\\JavaProjects\\Testing\\AdpTestDH\\NewChromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();

	//maximize the window
	driver.manage().window().maximize();

//Page 1 - verify elements on page start at Homepage
	driver.get("https://autotrader.com");
	System.out.println("Starting test:\n");	
	
	//Find & Verify Elements on the Page exists		
		boolean BrowseByMakeisDisplayed = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[1]/div[1]/span")).isDisplayed();
		WebElement makeElement = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[1]/div[1]/span"));
		
		boolean BrowseByStyleisDisplayed = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[2]/div/span")).isDisplayed();
		WebElement styleElement = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[2]/div/span"));

		boolean AdvancedSearchisDisplayed = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[3]/div/a")).isDisplayed();		
		WebElement advsearchElement = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[3]/div/a"));
		
		boolean SearchButton = driver.findElement(By.id("search")).isDisplayed();
		WebElement searchbuttonElement = driver.findElement(By.id("search"));
		
		boolean MakeDropList = driver.findElement(By.id("makeCodeListPlaceHolder")).isDisplayed();
		WebElement makeDropElement = driver.findElement(By.id("makeCodeListPlaceHolder"));
		
		boolean ModelDropList = driver.findElement(By.id("modelCodeListPlaceHolder")).isDisplayed();
		WebElement modelDropElement = driver.findElement(By.id("modelCodeListPlaceHolder"));
			
		//Display links if exist:		
		if (BrowseByMakeisDisplayed) {
			System.out.println("Verified link " + makeElement.getAttribute("title") + " is present.");
		} else {
			System.out.println("Unable to see browse by make.");
		}
		
		if (BrowseByStyleisDisplayed) {
			System.out.println("Verified link " + styleElement.getAttribute("title") + " is present.");
		} else {
			System.out.println("Unable to see browse by style");
		}
		
		if (AdvancedSearchisDisplayed) {
			System.out.println("Verified link " + advsearchElement.getAttribute("data-qaid") + " is present");
		} else {
			System.out.println("Unable to see advanced search.");
		}
		if (SearchButton) {
			System.out.println("Verified " + searchbuttonElement.getAttribute("id") + " button is present");
		} else {
			System.out.println("Unable to see search button.");
		}
		
		if(MakeDropList) {
			System.out.println("Verified Make Dropdown exists");
		} else {
			System.out.println("Couldn't find make dropdown list.");
		}
		
		if (ModelDropList) {
			System.out.println("Verified Model Dropdown exists");
		} else {
			System.out.println("Couldnt find model dropdown list"	);
		}
	throw new io.cucumber.java.PendingException();
}

@When("I click on the Advanced Search link")
public void i_click_advancedsearch() {
	WebDriver driver = new ChromeDriver();
	WebElement advsearchElement = driver.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[2]/span/span/div[3]/div/a"));

		System.out.println("Clicking on advanced search... ");
		advsearchElement.click();
		//Thread.sleep(4000);
		driver.close();
    throw new io.cucumber.java.PendingException();
}

@And("And I enter in search criteria")
public void open_browser2(){
	//Write code here
		System.setProperty("webdriver.chrome.driver", "C:\\JavaProjects\\Testing\\AdpTestDH\\NewChromedriver\\chromedriver.exe");
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://www.autotrader.com/cars-for-sale/");
		driver2.manage().window().maximize();
		WebElement zipCode = driver2.findElement(By.id("zipundefined"));
		zipCode.sendKeys("30004");
		System.out.println("Zip Sent");
		
		WebElement conditionCertified = driver2.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div[1]/form/div[3]/div/div[2]/div/div/div/div[3]/label"));
		conditionCertified.click();		
		
		WebElement styleConvertible = driver2.findElement(By.xpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div[1]/form/div[5]/div/div[2]/div/div/div[1]/label[1]"));		
		
		//To click convertible style since element is present but has overlay blocking it
		JavascriptExecutor js = (JavascriptExecutor) driver2;
		js.executeScript("arguments[0].click();", styleConvertible);
		
		//Selecting values from dropdown	
		Select startYear = new Select(driver2.findElement(By.name("startYear")));
		startYear.selectByValue("2017");
		
		Select endYear = new Select(driver2.findElement(By.name("endYear")));
		endYear.selectByValue("2020");
		
		Select makeFilter = new Select(driver2.findElement(By.name("makeFilter0")));
		makeFilter.selectByValue("BMW");		
		WebElement searchButton2 = driver2.findElement(By.xpath("//button[text() = 'Search']"));
		System.out.println("Clicking on search button... ");
		js.executeScript("arguments[0].click();", searchButton2);
		//searchButton2.click();
		//Thread.sleep(4000);
		driver2.close();
	throw new io.cucumber.java.PendingException();
}


@Then("And I validate all are BMWs")
public void validate_bms(){
	//find all elements with xpath that has each result
	System.setProperty("webdriver.chrome.driver", "C:\\JavaProjects\\Testing\\AdpTestDH\\NewChromedriver\\chromedriver.exe");
	WebDriver driver3 = new ChromeDriver();
	driver3.get("https://www.autotrader.com/cars-for-sale/Certified+Cars/Convertible/BMW/Alpharetta+GA-30004?vehicleStyleCodes=CONVERT&makeCodeList=BMW&listingTypes=CERTIFIED&searchRadius=50&zip=30004&startYear=2017&endYear=2020&marketExtension=include&isNewSearch=true&sortBy=relevance&numRecords=25&firstRecord=0");		
	driver3.manage().window().maximize();
	List<WebElement>resultsList = driver3.findElements(By.xpath("//h2[@data-cmp]"));
	List<String>getTextResults = new ArrayList<String>();
		
		//Go through elements and save the text to list
		for (WebElement e : resultsList) {
			getTextResults.add(e.getText());
		}
		
		//Results that contain BMW into list matches
		List<String> matches = getTextResults.stream().filter(it -> it.contains("BMW")).collect(Collectors.toList());
		
		//Check to display total number of bmw matches
		//System.out.println("bmw counter = " + matches);
		
		//Compare number of BMW matches to size of returned cars from search
		if(matches.size() == resultsList.size()){
			System.out.println("Verified that all cars listed are BMWs counts = " + matches.size());
		} else {
			System.out.println("All cars listed are NOT BMWS- fail");
		}
		//Thread.sleep(4000);
		driver3.close();
	throw new io.cucumber.java.PendingException();
}

}