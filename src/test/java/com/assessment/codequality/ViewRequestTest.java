package com.assessment.codequality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewRequestTest {
	
	private WebDriver driver;

	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	void testViewRequest() throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:3000/login");

		WebElement usernameInput = driver.findElement(By.name("name"));
		usernameInput.sendKeys("nandha");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("nandha123");

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

		WebElement requestDetailsButton = driver.findElement(By.xpath("//*[@id=\"root\"]/nav/div/div[2]/ul/li/a/button"));
		requestDetailsButton.click();
		
		
		Thread.sleep(5000);

	}


}
