package com.ol.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenLandingPage extends BasePage {

	private WebElement element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"DrpDwnMn13\"]/a")
	private WebElement investorRelationsLinkLocator;

	@FindBy(how = How.XPATH, using = "//*[@id=\"block-nir-pid3666-content\"]/article/div/div/div/div[2]/div/div[1]/div/div/nav/ul/li/a")
	private WebElement viewAllLink;

	@FindBy(how = How.ID, using = "edit-submit")
	private WebElement filterButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"block-nir-pid3666-content\"]/article/div/div/div/div/div/div/div/div/div/div/div[2]/article[10]/div[4]/div/a")
	private WebElement pdfLink;
	
	public OpenLandingPage(WebDriver driver) {
		super(driver);
	}

	public void clickInvestorRelationsLink() {
		element = waitforVisibilityOfElement(investorRelationsLinkLocator);
		element.click();
	}

	public void clickViewAllLink() {
		windowHandle();
		element = waitforVisibilityOfElement(viewAllLink);
		element.click();
	}

	public void clickFilterButton() {
		filterButton.click();
	}

	public void clickPDFAndDownload() {
		element = waitforVisibilityOfElement(pdfLink);
		element.click();
	}
}
