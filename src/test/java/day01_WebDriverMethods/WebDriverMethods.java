package day01_WebDriverMethods;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println(title);

		System.out.println("************************************************************************");
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);

		System.out.println("************************************************************************");
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		System.out.println("************************************************************************");
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
		System.out.println("No. of elements :" + elements.size());

		for (WebElement el : elements) {
			System.out.println("Element Name : " + el.getText());
		}

		System.out.println("************************************************************************");

		WebElement element = driver.findElement(By.xpath("//h5[text()='Elements']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		element.click();

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		System.out.println("************************************************************************");

		Set<String> windowIds = driver.getWindowHandles();
		for (String ids : windowIds) {
			System.out.println(ids);
		}

		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

//			driver.close();
		driver.quit();

	}

}
