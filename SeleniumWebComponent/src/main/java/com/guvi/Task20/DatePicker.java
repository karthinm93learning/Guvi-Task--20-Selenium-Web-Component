package com.guvi.Task20;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		String webpage = "https://jqueryui.com/datepicker/";
	
		String expectedDate = "22";
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(webpage);
		
		driver.switchTo().frame(0);
		
		WebElement dateField = driver.findElement(By.xpath("//input[@id = 'datepicker' and @class = 'hasDatepicker']"));
		dateField.click();
		
		WebElement nextButton = driver.findElement(By.xpath("//a[@data-handler = 'next' and @title = 'Next']"));
		nextButton.click();

		WebElement dateTable = driver.findElement(By.xpath("//table[@class = 'ui-datepicker-calendar']/child::tbody"));
		
		List <WebElement> dates =dateTable.findElements(By.tagName("td"));
		
		
		for (WebElement temp : dates) {
			
			String neededDate = temp.getText();
			
			if(expectedDate.contentEquals(neededDate))
			{
				temp.click();
			}
		}
		
		//We Can't Print Selected date in Console, So I skipping the step.
		
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
