package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class REQ03CT03MantemAluno {

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
	public void rEQ03CT03() {

		driver.get("https://ts-scel.herokuapp.com/sig/alunos");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("dfbdfc");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("dfbfdbfd@gmail.com.br");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("08230030");
		driver.findElement(By.id("endereco")).click();
		driver.findElement(By.cssSelector(".card-body")).click();
		{
			WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(4)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).clickAndHold().perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(4)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.cssSelector(".form-group:nth-child(4)"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).release().perform();
		}
		driver.findElement(By.cssSelector(".row:nth-child(4)")).click();
		driver.findElement(By.cssSelector(".container")).click();
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}
}
