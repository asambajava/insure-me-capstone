package com.project.staragile.insureme;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumTests {
	@Test
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver-mac-arm64/chromedriver");
	ChromeOptions chromeoptions = new ChromeOptions();
	chromeoptions.addArguments("--headless");
	WebDriver driver=new ChromeDriver(chromeoptions);
	driver.get("http://54.87.202.235:8081/contact.html");
	WebElement name=driver.findElement(By.id("inputName"));
	WebElement number=driver.findElement(By.id("inputNumber"));
	WebElement mail=driver.findElement(By.name("inputMail"));
	WebElement message=driver.findElement(By.name("inputMessage"));
	WebElement send=driver.findElement(By.name("my-button"));
	WebElement resp=driver.findElement(By.name("response"));
	name.sendKeys("abc");
	number.sendKeys("12345");
	mail.sendKeys("abc12345@gmail.com");
	message.sendKeys("hello");
	send.click();
	String actualMessage="Message Sent";
	String expectedMessage= resp.getText();
	Assert.assertEquals(actualMessage,expectedMessage);
	driver.close();
	}

}
