package com.assessment.codequality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

	private WebDriver driver;

	@BeforeEach
	void start() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/login");
	}

	@AfterEach
	void close() {

		driver.quit();
	}

	@Test
	public void testLoginWithValidCredentialsAsDonatorAndEmployee() throws InterruptedException {
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

		Thread.sleep(10000);

	}

	@Test
	public void testLoginWithInvalidCredentials() throws InterruptedException {

		WebElement usernameInput = driver.findElement(By.name("name"));
		usernameInput.sendKeys("InvalidUser");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("InvalidPassword");

		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		loginButton.submit();

		WebElement errorMessage = null;
		try {
			errorMessage = driver.findElement(By.className("text-red-500"));
		} catch (Exception e) {
			
		}
		if (errorMessage != null && errorMessage.isDisplayed()) {
			System.out.println("Negative login test passed for invalid credentials!");
		} else {
			System.out.println("Negative login test failed. Expected error message not found.");
		}

		Thread.sleep(10000);

	}

}
