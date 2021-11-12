package com.ol.assessment.tests;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ol.assessment.pages.GoogleHomePage;
import com.ol.assessment.pages.OpenLandingPage;
import com.ol.assessment.util.PDFUtil;


public class BaseTest {

	// using chrome driver
	String driverPath = "C:\\Selenium\\chromedriver.exe";

	WebDriver driver;

	GoogleHomePage objGoogleHomePage;
	OpenLandingPage objOpenLandingPage;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);

		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); // set chrome options capability to auto
																				// download pdf
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.default_directory", "C:\\personal\\ol");

		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}

	@Test(priority = 0)
	public void navigateToGoogleAndSearch() {
		objGoogleHomePage = new GoogleHomePage(driver);
		objGoogleHomePage.searchFor("Open Lending");
		objGoogleHomePage.click();
	}

	@Test(priority = 1)
	public void navigateToOpenLandingPage() throws MalformedURLException {
		objOpenLandingPage = new OpenLandingPage(driver);
		objOpenLandingPage.clickInvestorRelationsLink();
		objOpenLandingPage.clickViewAllLink();
		objOpenLandingPage.clickFilterButton();
		objOpenLandingPage.clickPDFAndDownload();
	}

	@Test(priority = 2)
	public void openPDFAndVerifyTitle() {
		String expectedTitle = "Open Lending to Announce First Quarter 2021 Results on May 11, 2021";
		String readPDFTitle = PDFUtil.readPDF();
		Assert.assertEquals(readPDFTitle, expectedTitle);
		System.out.println("Success!!!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
