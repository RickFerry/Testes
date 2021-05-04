package com.fatec.cap09scelwebd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ03CT04MantemAluno {

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
	public void rEQ03CT03() {

		driver.get("https://ts-scel.herokuapp.com/");
		driver.manage().window().setSize(new Dimension(1153, 1009));
		driver.findElement(By.linkText("Alunos")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win8862", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win8862").toString());
		driver.findElement(By.linkText("Excluir")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".panel-body"));
			assert (elements.size() > 0);
		}
		driver.close();
	}
}