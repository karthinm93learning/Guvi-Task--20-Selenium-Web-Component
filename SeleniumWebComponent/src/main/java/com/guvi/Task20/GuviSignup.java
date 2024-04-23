package com.guvi.Task20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


public class GuviSignup {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		String pageLink = "https://www.guvi.in/";

		String email = "test@test.com";

		String password = "Testing@1235";

		driver.get(pageLink); // Page URL

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement signupButton = driver.findElement(By.xpath("//a[starts-with(@class, 'nav-link btn')]"));
		signupButton.click();

		WebElement fullName = driver.findElement(By.xpath("//input[@class = 'form-control' and @id = 'name']"));
		fullName.sendKeys("Guru");

		WebElement emailBox = driver.findElement(By.xpath("//input[@type = 'email' and @id = 'email']"));
		emailBox.sendKeys(email);

		WebElement passwordFiels = driver.findElement(By.xpath("//input[@type = 'password' and @id = 'password']"));
		passwordFiels.sendKeys(password);

		WebElement mobileNumber = driver
				.findElement(By.xpath("//input[@autocomplete = 'off' and @id = 'mobileNumber']"));
		mobileNumber.sendKeys("9876543210");

		WebElement signUpButton = driver.findElement(By.xpath("//a[@id = 'signup-btn' and @class = 'btn signup-btn']"));
		signUpButton.click();

		WebElement currentProfile = driver
				.findElement(By.xpath("//select[@class = 'form-control' and @id = 'profileDrpDwn']"));
		Select profileDrop = new Select(currentProfile);
		profileDrop.selectByIndex(1);

		WebElement degree = driver.findElement(By.xpath("//select[@class = 'form-control' and @id = 'degreeDrpDwn']"));
		Select degreeDrop = new Select(degree);
		degreeDrop.selectByVisibleText("B.Sc. / M.Sc.");

		WebElement yearOfPass = driver.findElement(By.xpath("//input[@class = 'form-control' and @id = 'year']"));
		yearOfPass.sendKeys("2020");

		WebElement submitBtn = driver.findElement(By.xpath("//a[text() = 'Submit']"));
		submitBtn.click();

		driver.navigate().to(pageLink);

		WebElement loginButton = driver.findElement(By.xpath("//*[starts-with(@class, 'nav-link  text-primary')]"));
		loginButton.click();

		WebElement loginEmailField = driver.findElement(By.xpath("//input[@type = 'email' and @id = 'email']"));
		loginEmailField.sendKeys(email);

		WebElement loginpwdField = driver.findElement(By.xpath("//input[@type = 'password' and @id = 'password']"));
		loginpwdField.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.xpath("//a[@id = 'login-btn' and @class = 'btn login-btn']"));
		loginBtn.click();

		String expectedTitle = "GUVI | courses";

		String actualTitle = driver.getTitle();

		if (expectedTitle.equalsIgnoreCase(actualTitle)) {
			System.out.println("Page is Logged In Successfully!!");
		} else {
			System.out.println("Page is Not Logged In");
		}

		driver.quit();
	}

}
