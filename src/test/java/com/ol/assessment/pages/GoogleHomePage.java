package com.ol.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleHomePage extends BasePage {

	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a")
	private WebElement linkText;
	
	// search for term in google and submit
	public void searchFor(String searchTerm) {
		searchBox.sendKeys(searchTerm);
		searchBox.submit();
	}

	// click open landing link on search page
	public void click() {
		linkText.click();
	}

}
