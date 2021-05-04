package com.fatec.cap09scelwebd;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ10CT01Login {

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

	@Test
	public void rEQ10CT01() {

		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(578, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("maria");
		driver.findElement(By.name("password")).sendKeys("456");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		driver.findElement(By.linkText("Alunos")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win1299", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win1299").toString());
		driver.close();
		driver.switchTo().window(vars.get("root").toString());
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.linkText("Page 3")).click();
		driver.findElement(By.linkText("Page 3")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
