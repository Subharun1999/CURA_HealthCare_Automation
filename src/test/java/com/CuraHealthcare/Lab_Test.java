package com.CuraHealthcare;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab_Test {

	@Test
	public void positive_TC001() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get(" https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement APPOINTMENT = driver.findElement(By.xpath("//a[text()='Make Appointment' and contains(@id,btn-make-appointment)]"));
		APPOINTMENT.click();
		Thread.sleep(2000);

		//Entering ID
		WebElement ID = driver.findElement(By.xpath("//input[@name='username']"));
		ID.sendKeys("John Doe");

		//Entering PASSWORD
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@name='password']"));
		PASSWORD.sendKeys("ThisIsNotAPassword");

		//Clicking on Login button
		WebElement LOGIN = driver.findElement(By.xpath("//button[text()='Login']"));
		LOGIN.click();
		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

		WebElement PROGRAM_TYPE = driver.findElement(By.xpath("//input[@id= 'radio_program_medicaid']"));
		PROGRAM_TYPE.click();

		WebElement VISIT_DATE = driver.findElement(By.xpath("//input[@id= 'txt_visit_date']"));
		VISIT_DATE.sendKeys("24/07/2024");

		WebElement COMMENT = driver.findElement(By.xpath("//textarea[@id= 'txt_comment']"));
		COMMENT.sendKeys("Orthopaedic Appointment Required");

		WebElement BOOK_APPOINTMENT = driver.findElement(By.xpath("//button[@id= 'btn-book-appointment' and contains(@type, 'submit')]"));
		BOOK_APPOINTMENT.click();

		WebElement APPOINTMENT_CONFIRMATION = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));

		//Verifying whether the appointment confirmation is present or not;
		System.out.println(APPOINTMENT_CONFIRMATION.isDisplayed());
		Thread.sleep(2000);
		driver.quit();

	}
}
