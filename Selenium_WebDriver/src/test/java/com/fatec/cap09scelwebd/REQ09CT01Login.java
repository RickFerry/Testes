package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class REQ09CT01Login {

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void rEQ09CT01() {

		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("Livros")).click();
		{
			WebElement element = driver.findElement(By.cssSelector(".row:nth-child(2)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector(".row:nth-child(2)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector(".row:nth-child(2)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("SDGSD");
		driver.findElement(By.cssSelector(".row:nth-child(4) > .col-md-8")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("DFHJGHJFH");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector("tr:nth-child(3) .delete")).click();
		driver.findElement(By.cssSelector("tr:nth-child(3) .btn-primary")).click();
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("aut");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("titu");
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.cssSelector(".btn")).click();
	}
}
