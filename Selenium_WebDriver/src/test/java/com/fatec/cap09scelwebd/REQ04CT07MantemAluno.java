package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ04CT07MantemAluno {

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
	public void rEQ04CT08() {

		driver.get("https://ts-scel.herokuapp.com/sig/aluno");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1234");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("bbbbbbbbbbbbbbbbbbbbbbbb");
		driver.findElement(By.cssSelector(".card-body")).click();
		driver.findElement(By.cssSelector(".row:nth-child(4) > .form-group > .col-form-label")).click();
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("regdfgdf@gmail.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("08230020");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}
}
