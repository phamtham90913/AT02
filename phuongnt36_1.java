package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Class_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://only-testing-blog.blogspot.in/2013/09/test.html";
		//open browser
		driver.get(baseUrl);
		//maximize browser
		driver.manage().window().maximize();
		//nhap gia tri vao textbox 		
		WebElement element = driver.findElement(By.id("fname"));
		element.sendKeys("Phuong");
		//click checkbox
		WebElement element1 = driver.findElement(By.xpath(".//*[contains(@value,'Bike')]"));
		element1.click();
		//click radio
		WebElement element3 = driver.findElement(By.xpath(".//input[@value='male']"));
		element3.click();
		//click select box
			//WebElement element2 = driver.findElement(By.xpath(".//option[@value='UK']"));
			//element2.click();
		//select tu thu vien
		Select orderBy = new Select(driver.findElement(By.xpath(".//*[@name='combo_box']/../select")));
		//orderBy.selectByVisibleText("Opel");
		//orderBy.selectByIndex(0);
		orderBy.selectByValue("UK");
		
		//select gia tri 
		Select orderBy1 = new Select(driver.findElement(By.xpath(".//select[@name='FromLB']")));
		orderBy1.selectByVisibleText("Malaysia");
		WebElement element4 = driver.findElement(By.xpath(".//input[@value='->']"));
		element4.click();
		
		String alertMss = "";
		driver.findElement(By.xpath(".//button[text()='Get Confirmation']")).click();
		alertMss = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		System.out.println(alertMss);
		
		
		
		String alertMss1 = "";
		driver.findElement(By.xpath("..//button[text()='Get Confirmation']")).click();
		alertMss1 = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
		driver.findElement(By.xpath(".//div[1]/table/tbody//*[text()='23']")).click();
		
		
		
		
		

	}

}
