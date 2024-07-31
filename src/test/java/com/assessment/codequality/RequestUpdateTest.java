package com.assessment.codequality;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestUpdateTest {

	private WebDriver driver;

	@BeforeEach
	void start() throws InterruptedException {
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

		WebElement donatorDetailsButton = driver.findElement(By.xpath("//button[contains(text(),'Handle Requests')]"));
		donatorDetailsButton.click();
	}

	@AfterEach
	void close() {
		driver.quit();
	}

	@Test
	void testUpdateRequestValid() throws InterruptedException {

//		WebElement requestElementButton = driver
//				.findElement(By.("//*[@id=\"root\"]/div/table/tbody/tr[13]/td[9]/a/button"));
//		requestElementButton.click();
		
		driver.get("http://localhost:3000/edit/9");

		WebElement selectElement = driver.findElement(By.name("status"));

		// Create a Select object
		Select dropdown = new Select(selectElement);

		// Select an option by visible text
		dropdown.selectByVisibleText("Approved");

		// Verify that the correct option is selected
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		assertEquals("Approved", selectedOption.getText());

		// Click the submit button
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"edit\"]/div/form/button"));
		submitButton.submit();

		// Wait for the alert to be present
		Thread.sleep(2000); // Adjust if necessary based on alert display

		// Handle the alert
		String alertText = driver.switchTo().alert().getText();
		assertEquals("Data Updated Successfully", alertText);
		driver.switchTo().alert().accept();

		Thread.sleep(5000);

	}

}
