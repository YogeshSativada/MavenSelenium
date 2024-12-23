package day03_LinkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class link02 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icicibank.com/");
		driver.manage().window().maximize();

		WebElement block = driver.findElement(By.xpath("//p[text()='Other']/parent::div/parent::div"));

		List<WebElement> allLinks = block.findElements(By.tagName("a"));

		System.out.println(allLinks.size());
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,2600);");

		Thread.sleep(3000);

		for (int i = 0; i < allLinks.size(); i++) {
			WebElement link = allLinks.get(i);

			System.out.println(link.getText());

			System.out.println(link.getAttribute("href"));

			link.click();

			Thread.sleep(3000);

			System.out.println(driver.getTitle());

			System.out.println(driver.getCurrentUrl());

			System.out.println("**************************");

			driver.navigate().back();

		}

		driver.quit();

	}

}
