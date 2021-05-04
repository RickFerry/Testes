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

public class REQ02CT02MantemLivros {

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
	public void rEQ02CT02() {

		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1153, 1009));
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1111");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Teste");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".row:nth-child(3) > .form-group")).click();
		assertThat(driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText(),
				is("Autor deve ter entre 1 e 50 caracteres"));
	}
}
