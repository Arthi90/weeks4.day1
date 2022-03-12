package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {

	public static void main(String[] args) {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (30));
		
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> allWindowHandleSet = driver.getWindowHandles();
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		String newWindow = allWindowHandleList.get(1);
		driver.switchTo().window(newWindow);
		
		System.out.println(driver.getCurrentUrl());
		
		WebElement e2 = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//descendant::a[@class='linktext'][1]"));
		String LeadID = e2.getText();
		System.out.println(LeadID);
		e2.click();
		driver.switchTo().window(allWindowHandleList.get(0));
		driver.findElement(By.xpath("//table[@name='ComboBox_partyIdTo']/following::img[@alt='Lookup']")).click();
		Set<String> allWindowHandleSet1 = driver.getWindowHandles();
		List<String> allWindowHandleList1 = new ArrayList<String>();
		allWindowHandleList1.addAll(allWindowHandleSet1);
		String newWindow1 = allWindowHandleList1.get(1);
		driver.switchTo().window(newWindow1);
		System.out.println(driver.getCurrentUrl());
		
		WebElement e21 = driver.findElement(By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt'][1]//descendant::a[@class='linktext'][1]"));
		String LeadID1 = e21.getText();
	    System.out.println(LeadID1);
		e21.click();
		driver.switchTo().window(allWindowHandleList.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous'and text()='Merge']")).click();
		Alert al1 = driver.switchTo().alert();
		String text1=al1.getText();
		System.out.println(text1);
		al1.accept();
		System.out.println(driver.getCurrentUrl());
		
		System.out.println("The title is:"+ driver.getTitle());
	}

}
