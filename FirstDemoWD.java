package FirstDemoWD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class FistDemoWD {
	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://only-testing-blog.blogspot.in/2013/09/test.html";
		String expectedTitle = "Only Testing: MyTest";
		String actualTitle= "";
		String text1 = "";
		
		//Open url
		driver.get(baseUrl);
		
		//Check name
		System.out.println("Check fullname");
		driver.findElement(By.id("fname")).click();
		driver.findElement(By.name("fname")).sendKeys("Thuy");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Select checkbox
		//driver.findElement(By.xpath("//*[@value='Car']")).click();
		//Thread.sleep(5000);
		//Check all check boxes
		
		int i = 0;
		while(i<3){
			driver.findElement(By.xpath("//*[@type='checkbox']")).click();
			i++;
		}
		
		
		//Select radio
		driver.findElement(By.xpath("//*[@value='female']")).click();
		Thread.sleep(5000);
		
		//Select combobox
		driver.findElement(By.xpath("//*[@value='USA']")).click();
		Thread.sleep(2000);
		
		// The second way
		Select orderBy = new Select(driver.findElement(By.xpath("//*[@name='combo_box']/../select")));
		orderBy.selectByVisibleText("Opel");
		Thread.sleep(5000);
		orderBy.selectByIndex(3);
		Thread.sleep(5000);
		orderBy.selectByValue("UK");
		Thread.sleep(5000);
		
		//Select dropdownlist
		driver.findElement(By.xpath("//*[@value='US']")).click();
		driver.findElement(By.xpath("//*[@value='->']")).click();
		
		//Select OK popup
		driver.findElement(By.xpath("//*[@value='Show Me Alert']")).click();
		Thread.sleep(3000);
		String alertMsg = "";
		alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMsg);
		
		//Cancel popup
		driver.findElement(By.xpath("//*[text()='Get Confirmation']")).click();
		Thread.sleep(3000);
		alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		System.out.println(alertMsg);
		System.out.println("You cancelled popup message");
		
		//Select item in a table
		text1 = driver.findElement(By.xpath("//td[text()='24']")).getText();
		Thread.sleep(3000);
		System.out.println(text1);
		
		//get actual title
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		//compare actual and expected
		if(actualTitle.contentEquals(expectedTitle)){
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		//close firefox
		driver.close();
		
	}
	
}
