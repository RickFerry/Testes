package com.fatec.cap09scelwebd;

import static org.hamcrest.CoreMatchers.is;
//Generated by Selenium IDE
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ04CT02MantemAluno {
	
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
	public void rEQ04CT02() {

		driver.get("https://ts-scel.herokuapp.com/sig/aluno");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1234");
		driver.findElement(By.id("ra")).sendKeys("12345");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("leo");
		driver.findElement(By.id("email")).sendKeys("sdgsd@gmail.com");
		driver.findElement(By.id("cep")).sendKeys("08230020");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(),
				is("RA deve ter 4 caracteres"));
	}
}
