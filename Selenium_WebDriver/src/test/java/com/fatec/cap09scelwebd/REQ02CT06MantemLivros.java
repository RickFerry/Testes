package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ02CT06MantemLivros {

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
	public void rEQ02CT06() {

		driver.get("https://ts-scel.herokuapp.com/sig/livro");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("bbbbbbbbbbbbbbbbbbbbbbbbb");
		driver.findElement(By.id("titulo")).sendKeys("bbbbbbbbbbbbbbbbbbbbbbbbb");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}
}