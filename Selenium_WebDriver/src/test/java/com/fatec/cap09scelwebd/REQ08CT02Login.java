package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ08CT02Login {

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
	public void rEQ08CT02() {

		driver.get("https://ts-scel.herokuapp.com/logout");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("username")).sendKeys("joseee");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("345345345");
		driver.findElement(By.cssSelector("button")).click();
	}
}
