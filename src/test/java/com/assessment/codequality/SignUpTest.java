package com.assessment.codequality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignUpTest {

	private WebDriver driver;

	@BeforeEach
	void start() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/signup");
	}

	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	public void testSignupWithValidData() throws InterruptedException {

		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys("nandha");

		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys("nandha@example.com");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("nandha64");

		WebElement signupButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		signupButton.submit();

		Thread.sleep(5000);
		assertEquals("Data Added Successfully", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		assertEquals("http://localhost:3000/login", driver.getCurrentUrl());

		Thread.sleep(10000);

	}

	@Test
	public void testSignupWithEmptyFields() throws InterruptedException {

		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys("");

		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys("sena@example.com");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("sena123");

		WebElement signupButton = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		signupButton.submit();

		Thread.sleep(5000);
		assertEquals("Please enter Valid Name!!!", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		Thread.sleep(5000);
		assertEquals("Please Enter the Valid Inputs!!!", driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		assertEquals("http://localhost:3000/signup", driver.getCurrentUrl());

		Thread.sleep(10000);

	}

}
