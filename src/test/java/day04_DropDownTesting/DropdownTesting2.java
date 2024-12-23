package day04_DropDownTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting2 {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
//		Thread.sleep(10000);

		List<WebElement> allItems = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")))
				.getOptions();

		System.out.println("No of Items in Dropdown " + allItems.size());

		for (WebElement item : allItems) {
			System.out.println(item.getText());
		}

		driver.quit();

	}

}
