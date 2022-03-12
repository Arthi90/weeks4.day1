package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassAssignAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (30));
         
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert a1=driver.switchTo().alert();
		String text1= a1.getText();
		System.out.println(text1);
		a1.accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert a2 = driver.switchTo().alert();
		String text2=a2.getText();
		System.out.println(text2);
		a2.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert a3 = driver.switchTo().alert();
		String text3=a3.getText();
		System.out.println(text3);
		a3.sendKeys("Arthi");
		a3.accept();
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	    Alert a4=driver.switchTo().alert();
	    String text4=a4.getText();
		System.out.println(text4);
		a4.accept();
		
		String text5=driver.findElement(By.xpath("//button[text()='Sweet Alert']")).getText();
		System.out.println(text5);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();

		
	}

}
