package day03_LinkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links in Current WebPage : " + links.size());
		
		for(WebElement link :links) {                                                  //for each loop
			System.out.println("link Text : " + link.getText());
			System.out.println("link URL : " + link.getAttribute("href"));
		}
		
//		System.out.println("Using For Loop");
//		for(int i=0;i<links.size();i++)                                                          //for loop
//		{
//			System.out.println( links.get(i).getText());
//			System.out.println( links.get(i).getAttribute("href"));
//		}
		
		System.out.println("No of valid Links in WebPage");
		int validLinkCount = 0;
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				validLinkCount++;
			}
		}
		System.out.println("No of valid Links in WebPage is :" + validLinkCount);
		driver.quit();

	}

}
