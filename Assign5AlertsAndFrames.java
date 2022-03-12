package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign5AlertsAndFrames {

	public static void main(String[] args) {
	/*	Alerts and Frames:
			---------------------
			https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
			Click Try It Button
			Click OK/Cancel in the alert
			Confirm the action is performed correctly by verifying the text !!
			 Hint

			Switch to the frame
			Then click Try It with xpath
			Switch to the alert
			Then perform accept / dismiss
			Get the text using id 
			Verify the text based on the action

*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (30));
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert a1=driver.switchTo().alert();
		String text1= a1.getText();
		System.out.println(text1);
		a1.dismiss();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframeResult");
		
		String text2= driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(text2.contains("OK")) 
			System.out.println("You pressed Ok in Alert box");
		
		else 
			System.out.println("You pressed cancel in alert box");
		
		
		
	}

}
