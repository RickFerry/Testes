package com.fatec.cap09scelwebd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ06CT01Emprestimo {

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
	public void rEQ06CT01() {

		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1232");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1115");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".text-danger")).click();
		assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
		driver.close();
	}
}
