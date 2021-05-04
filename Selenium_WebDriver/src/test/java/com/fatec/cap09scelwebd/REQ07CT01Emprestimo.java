package com.fatec.cap09scelwebd;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ07CT01Emprestimo {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> whNow = driver.getWindowHandles();

		@SuppressWarnings("unchecked")
		Set<String> whThen = (Set<String>) vars.get("window_handles");

		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void rEQ07CT01() {

		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1153, 1009));
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("5555");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("6666");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".my-5")).click();
		assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win5204", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win5204").toString());
		driver.findElement(By.cssSelector("tr:nth-child(4)")).click();
		assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(5)")).getText(), is("2021/05/04"));
		driver.close();
		driver.switchTo().window(vars.get("root").toString());
		driver.close();
	}
}
