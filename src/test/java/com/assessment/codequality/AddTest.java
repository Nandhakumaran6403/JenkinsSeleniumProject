package com.assessment.codequality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {

	private WebDriver driver;

	@BeforeEach
	void start() throws InterruptedException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:3000/login");

		WebElement usernameInput = driver.findElement(By.name("name"));
		usernameInput.sendKeys("Nandhakumaran");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("123");

		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		loginButton.submit();

		Thread.sleep(5000);

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals("http://localhost:3000/main")) {
			System.out.println("Positive login test passed for employee!");
		} else if (currentUrl.equals("http://localhost:3000/usermain")) {
			System.out.println("Positive login test passed for donator!");
		} else {
			System.out.println("Positive login test failed. Unexpected redirection.");
		}

		WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Donate')]"));
		addButton.click();
	}
	
	
	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	public void testAddUserWithValidData() throws InterruptedException {

		// Locate the input fields
		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys("Vashanth");

		WebElement emailField = driver.findElement(By.name("emailid"));
		emailField.sendKeys("vasi@example.com");

		WebElement addressField = driver.findElement(By.name("address"));
		addressField.sendKeys("Mandelanagar");

		WebElement phoneField = driver.findElement(By.name("phoneNumber"));
		phoneField.sendKeys("1234567890");

		WebElement donationField = driver.findElement(By.name("donation"));
		donationField.sendKeys("100");

		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		submitButton.submit();

		Thread.sleep(5000);

		assertEquals("Data Added Successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		Thread.sleep(5000);

	}

	@Test
	public void testAddUserWithEmptyFields() throws InterruptedException {

		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));

		submitButton.submit();

		Thread.sleep(5000);

	}

	@Test
	public void testAddUserWithInvalidEmail() throws InterruptedException {

		WebElement nameField = driver.findElement(By.name("name"));
		nameField.sendKeys("Vashanth");

		WebElement emailField = driver.findElement(By.name("emailid"));
		emailField.sendKeys("InvalidEmailId");

		WebElement addressField = driver.findElement(By.name("address"));
		addressField.sendKeys("Mandelanagar");

		WebElement phoneField = driver.findElement(By.name("phoneNumber"));
		phoneField.sendKeys("1234567890");

		WebElement donationField = driver.findElement(By.name("donation"));
		donationField.sendKeys("100");

		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		submitButton.submit();

		Thread.sleep(5000);

	}

	// @Test
	// public void testAddUserWithInvalidPhoneNumber() throws InterruptedException {

	// 	WebElement nameField = driver.findElement(By.name("name"));
	// 	nameField.sendKeys("Vashanth");

	// 	WebElement emailField = driver.findElement(By.name("emailid"));
	// 	emailField.sendKeys("vasi@example.com");

	// 	WebElement addressField = driver.findElement(By.name("address"));
	// 	addressField.sendKeys("Mandelanagar");

	// 	WebElement phoneField = driver.findElement(By.name("phoneNumber"));
	// 	phoneField.sendKeys("Invalid-Phone-Number");

	// 	WebElement donationField = driver.findElement(By.name("donation"));
	// 	donationField.sendKeys("100");

	// 	WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	// 	submitButton.submit();

	// 	Thread.sleep(5000);

	// 	assertEquals("Failed to add data. Please try again.", driver.switchTo().alert().getText());

	// 	driver.switchTo().alert().accept();

	// 	Thread.sleep(5000);

	// }
}
