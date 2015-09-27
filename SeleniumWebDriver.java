/**
 * 
 */
package objectday5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author THAM
 *
 */
public class webDriverClass {
	static WebDriver  driver = new FirefoxDriver();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String webUrl = "http://only-testing-blog.blogspot.in/2013/09/test.html";
		driver.get(webUrl);
		testSelectElement();
	}
	/**
	 * @author THAM
	 * check elements on testing-blogspot
	 * use statement to navigate selenium
	 * 
	 */
	public static void testSelectElement(){

		WebElement txtName = driver.findElement(By.xpath(".//*[@id='fname']"));
		WebElement cBike = driver.findElement(By.xpath("//input[@type = 'checkbox' and @value = 'Bike']"));
		WebElement rdMale = driver.findElement(By.xpath("//input[@type = 'radio' and @value = 'male']"));
		WebElement rdFemale = driver.findElement(By.xpath("//input[@type='radio' and @value = 'female']"));
		WebElement cbSelectSaab = driver.findElement(By.xpath("//option[@value = 'UK' and text() = 'Saab']"));
		WebElement opIndian = driver.findElement(By.xpath("//option[@value = 'IND']"));
		WebElement btnSend = driver.findElement(By.xpath("//input[@value='->']"));
		WebElement btnGetConfirm = driver.findElement(By.xpath("//button[text()='Get Confirmation']"));

		//		cbSelectSaab.click();
		Select orderBy = new Select(driver.findElement(By.xpath("//form[@action = 'demo_form.asp']/../select")));
		txtName.sendKeys("Pham tham");
		rdMale.click();
		orderBy.selectByIndex(1);
		//		orderBy.selectByValue("UK");
		//		orderBy.selectByVisibleText("Opel");
		//		check if checkbox is unselected, 
		if (!cBike.isSelected()){
			cBike.click();
			System.out.println("chek cbBike");
		}else
			System.out.print("uncheck cbBike");
		//		select option Indian
		opIndian.click();
		//		get options were selected to next table
		btnSend.click();

		String alertMess = "";
		btnGetConfirm.click();
		alertMess = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		//		print mess content was get()
		System.out.println("Title\t" + alertMess);
		//	driver.switchTo().alert().dismiss();
		//		verify cells in table
		//		.//*[text()='23']
	}
}
