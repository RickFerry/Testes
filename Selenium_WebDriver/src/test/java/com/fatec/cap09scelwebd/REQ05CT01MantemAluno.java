package com.fatec.cap09scelwebd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ05CT01MantemAluno {

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

	@SuppressWarnings("deprecation")
	@Test
	public void rEQ05CT01() {

		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1153, 1009));
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.cssSelector("form > .row:nth-child(2)")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1115");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("aaaaaa");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("asdasda@sadasdas.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("01001000");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector("tr:nth-child(5)")).click();
		assertThat(driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(6)")).getText(),
				is("Praça da Sé"));
		driver.close();
	}
}
