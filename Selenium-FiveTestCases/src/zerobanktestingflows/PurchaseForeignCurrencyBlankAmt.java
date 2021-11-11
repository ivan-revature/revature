package zerobanktestingflows;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class PurchaseForeignCurrencyBlankAmt {
public WebDriver driver;
	
	// common across the test cases
	@BeforeTest
	public void setUp() {
		//system path for browser webdriver
		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		//initiate webdriver
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// open browser
		driver.get("http://zero.webappsecurity.com/");
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
		//assertEquals(actualTitle, expectedTitle);
		
		// assert with message
		assertEquals(actualTitle, expectedTitle, "Title did not match!!! \n");
		
		// click on signin button
		driver.findElement(By.id("signin_button")).click();
		
		assertEquals(driver.getTitle(), "Zero - Log in", "Login page title did not match! \n");
		
		//enter username
		driver.findElement(By.name("user_login")).sendKeys("username");
		
		//enter password
		driver.findElement(By.id("user_password")).sendKeys("password");
		
		//click on login button
		driver.findElement(By.name("submit")).click();
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		driver.findElement(By.id("details-button")).click();
		
		driver.findElement(By.id("proceed-link")).click();
		
		assertEquals(driver.getTitle(), "Zero - Account Summary");
		
	
	}

	// common across the test cases
	@AfterTest
	public void cleanUp() {
		// close browser
		driver.close();
		driver.quit();
	}
	
	// 
	@Test (priority=0)
	public void purchaseCurrencyBlankAmtTest() {
		// ################### Explicit wait ###################
				WebDriverWait wait = new WebDriverWait(driver,10);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pay Bills")));
				WebElement payBills = wait.until(ExpectedConditions.
						elementToBeClickable(By.linkText("Pay Bills")));
				payBills.click();
				
				WebElement purchaseCurrency = wait.until(ExpectedConditions.
						elementToBeClickable(By.linkText("Purchase Foreign Currency")));
				purchaseCurrency.click();
				/*
				assertEquals(driver.findElement(
						By.xpath("//div[starts-with(@class,'board-header')]/h2[contains(text(),"
								+ "'Purchase foreign currency cash')]")).getText(), 
									"Purchase foreign currency cash");
				*/
				WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//h2[contains(text(),'Purchase foreign currency cash')]")));
				assertEquals(h2Title.getText(), "Purchase foreign currency cash");
				driver.navigate().refresh();
				driver.navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
	}
	
	@Test (priority=1)
	public void fundTransferTest() {
		// ################### Explicit wait ###################
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pay Bills")));
		
		WebElement fundTransfer = wait.until(ExpectedConditions.
				elementToBeClickable(By.linkText("Transfer Funds")));
		fundTransfer.click();
		
		driver.findElement(By.id("tf_amount")).sendKeys("500.00");
		driver.findElement(By.id("tf_description")).sendKeys("Fund transfer test...");
		driver.findElement(By.id("btn_submit")).click();
		
		WebElement doTransfer = wait.until(ExpectedConditions.
				elementToBeClickable(By.id("btn_submit")));
		doTransfer.click();
		WebElement h2Title = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Transfer Money & Make Payments - Confirm')]")));
		assertEquals(h2Title.getText(), "Transfer Money & Make Payments - Confirm");
		
		/*
		// select box method
		// select currency
		Select currency = new Select(driver.findElement(By.id("pc_currency")));
		
		currency.selectByVisibleText("Denmark (krone)");
		Thread.sleep(3000);
		
		currency.selectByValue("EUR");
		Thread.sleep(3000);
		*/
	}
	
	@Test (priority=2)
	public void viewStatements() throws InterruptedException {
		// ################### Explicit wait ###################
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement viewStmt = wait.until(ExpectedConditions.
				elementToBeClickable(By.linkText("Online Statements")));
		viewStmt.click();
		
		// select box method
		// select account type
		Select acctType = new Select(driver.findElement(By.id("os_accountId")));
		
		acctType.selectByVisibleText("Checking");
		Thread.sleep(3000);
		
		/*currency.selectByValue("EUR");
		Thread.sleep(3000); */
		WebElement osLink = wait.until(ExpectedConditions.
				elementToBeClickable(By.linkText("Statement 01/10/12(57K)")));
		assertEquals(osLink.isEnabled(), true);
		
	}
	
	@Test (priority=3)
	public void findTransaction() {
		// ################### Explicit wait ###################
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pay Bills")));
		
		WebElement findTrans = wait.until(ExpectedConditions.
				elementToBeClickable(By.linkText("Account Activity")));
		findTrans.click();
		
		findTrans = wait.until(ExpectedConditions.
				elementToBeClickable(By.linkText("Find Transactions")));
		findTrans.click();
		
		driver.findElement(By.name("description")).sendKeys("ONLINE TRANSFER REF");
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		WebElement tblFind = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]")));
		assertEquals(tblFind.isEnabled(), true);
		/*
		currency.selectByVisibleText("Denmark (krone)");
		Thread.sleep(3000);
		
		currency.selectByValue("EUR");
		Thread.sleep(3000);
		*/
	}
	
	@Test (priority=4)
	public void logoutTest() {
		// ################### Explicit wait ###################
		WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pay Bills")));
		
		driver.findElement(By.xpath("//"
				+ "body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
		WebElement logoutCmd = wait.until(ExpectedConditions.
				elementToBeClickable(By.id("logout_link")));
		logoutCmd.click();
		assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");
		// select box method
		// select currency
		/*
		Select currency = new Select(driver.findElement(By.id("pc_currency")));
		
		currency.selectByVisibleText("Denmark (krone)");
		Thread.sleep(3000);
		
		currency.selectByValue("EUR");
			Thread.sleep(3000);
		*/
}
}
