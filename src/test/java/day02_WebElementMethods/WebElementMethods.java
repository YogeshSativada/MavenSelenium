package day02_WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();

		driver.findElement(By.id("firstName")).sendKeys("Sativada");
		driver.findElement(By.id("lastName")).sendKeys("yogesh" + Keys.RETURN);

		WebElement element01 = driver.findElement(By.id("userNumber-label"));
		System.out.println("element text is : " + element01.getText());

		WebElement element02 = driver.findElement(By.xpath("//label[text()='Male']//preceding::input[@name='gender']"));
		System.out.println("is element is disabled : " + element02.isDisplayed());
		System.out.println("is element is enabled : " + element02.isEnabled());
		System.out.println("is element is selected : " + element02.isSelected());

		WebElement element03 = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", element03);
		element03.click();
		System.out.println("After Selecting, is element is selected : " + element02.isSelected());

		driver.quit();

	}

}
