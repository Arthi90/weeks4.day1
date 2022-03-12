package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4NumberOfFrames {

	public static void main(String[] args) {
		/*1.Find the number of frames
  - find the Elements by tagname - iframe
  - Store it in a list
  - Get the size of the list. (This gives the count of the frames visible to the main page)
*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (30));
		
		
		List<WebElement> l = driver. findElements(By.tagName("iframe"));
		System.out.println("Number of Frames is:" +l.size());
		

	}

}
