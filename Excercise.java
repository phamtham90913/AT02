package seleniumWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;

public class SeleniumSample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new FirefoxDriver();
		String baseUrl="http://only-testing-blog.blogspot.in/2013";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.name("fname")).sendKeys("Hoang Ha");
		//driver.findElement(By.name("lname")).sendKeys("abcd");
		driver.findElement(By.id("text4")).sendKeys("check");
		driver.findElement(By.xpath("//*[@value='Bike']")).click();
		// check bike
		driver.findElement(By.xpath("//*[@value='Car']")).click();
		driver.findElement(By.xpath("//*[@value='male']")).click();
		//radio
		driver.findElement(By.xpath("//*[@value='female']")).click();
		//driver.findElement(By.xpath("//select /option[@value='Russia' and  text()='Audi']")).click();
		Select orderBy = new Select(driver.findElement(By.xpath("//select")));
		orderBy.selectByIndex(2);
		orderBy.selectByVisibleText("Audi");
		// check table
		driver.findElement(By.xpath("//select/option[@value='Mexico']")).click();
		driver.findElement(By.xpath("//select/option[@value='Spain']")).click();
		driver.findElement(By.xpath("//*[@value='->']")).click();
		
		//check confirmation box
		driver.findElement(By.xpath("//*[@value='Show Me Alert']")).click();
		String message="Hi.. This is alert message!";
		message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(message);
		driver.findElement(By.xpath("//*[text()='Show Me Confirmation']")).click();
		Thread.sleep(3000);
		String message2="";
		message2=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(message2);
		
		//verify 24
		driver.findElement(By.xpath("//td[text()='24']"));

	}

}
