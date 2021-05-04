package com.fatec.cap09scelwebd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ01CT02MantemLivros {
	
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
	public void rEQ01CT02() {
		
		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1153, 1009));
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1111");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("AutorTeste");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Teste2");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	}
}