package objectday5;

//import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homeWork {
	static WebDriver driver = new FirefoxDriver();
	static	WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void main(String[] args) throws NullPointerException, InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		String webUrl = "http://live.guru99.com/";
		driver.get(webUrl);
		testShopping();
		//		driver.quit();
	}
	/**
	 * ham lay sap xep ngau nhien cac ky tu tu chuoi cho truoc
	 * @author THAM
	 * @param length: so luong ky tu trong chuoi
	 * @return tra lai chuoi ky tu co do dai = length
	 */
	public static String randomString(int length){
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890"; //numbers
		return RandomStringUtils.random(length, allowedChars);
	}
	/**
	 * testcase: thuc hien dang ky -> mua hang > check out tren trang live.guru99 thanh cong
	 * @throws InterruptedException
	 */
	public static void testShopping() throws InterruptedException{
		//		register new account
		WebElement btnAccount = driver.findElement(By.xpath(".//a[@class='skip-link skip-account']/span[text()='Account']")),
				btnRegister = driver.findElement(By.xpath(".//*[text()='Register']"));
		btnAccount.click();
		btnRegister.click();
		WebElement	txtFirstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		WebElement	txtLastName = driver.findElement(By.id("lastname"));
		WebElement	txtEmail = driver.findElement(By.id("email_address"));
		WebElement	txtPass = driver.findElement(By.id("password"));
		WebElement	txtConfirm = driver.findElement(By.id("confirmation"));
		WebElement	btnSubmitRegister = driver.findElement(By.xpath(".//*[@class = 'button' and @type ='submit']"));
		String passWord = "123456";
		String quantity = "3";

		txtFirstName.sendKeys("tham");
		txtLastName.sendKeys("pham");
		String email = randomString(5)+"@gmail.com";
		txtEmail.sendKeys(email);
		txtPass.sendKeys(passWord);
		txtConfirm.sendKeys(passWord);
		btnSubmitRegister.click();
		WebElement alertSuccess=driver.findElement(By.xpath(".//span[text()='Thank you for registering with Main Website Store.']"));
		//		wait for alert announce account was created success
		wait.until(ExpectedConditions.visibilityOf(alertSuccess));

		//		go shopping
		WebElement lbMobile = driver.findElement(By.xpath(".//*[text()='Mobile']"));
		lbMobile.click();
		WebElement btnAddToCartSamsung = driver.findElement(By.xpath("//a[@title='Samsung Galaxy' and @class='product-image']/..//button[@class='button btn-cart']"));
		btnAddToCartSamsung.click();
		WebElement txtQtySamsung=driver.findElement(By.xpath(".//a[text()='Samsung Galaxy']/../../..//*[@class='input-text qty']"));
		txtQtySamsung.clear();
		txtQtySamsung.sendKeys(quantity);
		WebElement btnUpdate = driver.findElement(By.xpath(".//*[@class='button btn-update']"));
		btnUpdate.click();
		WebElement cbCountry = driver.findElement(By.xpath(".//*[@id='country']/*[@value='VN']"));
		cbCountry.click();
		WebElement txtState =driver.findElement(By.id("region"));
		txtState.sendKeys("Ha Noi");
		WebElement txtZip =driver.findElement(By.id("postcode"));
		txtZip.sendKeys("10000");

		WebElement lbGrandTotal = driver.findElement(By.xpath("//*[text()='Grand Total']/../..//*[@class='price']"));
		WebElement lbSamsungPrice = driver.findElement(By.xpath(".//a[text()='Samsung Galaxy']/../../../*[@class='product-cart-price']/span/span"));
		Float realPrice = Float.valueOf(lbSamsungPrice.getText().substring(1));
		Float realQty=Float.valueOf(quantity);
		System.out.println("realprice:\t"+realPrice);
		System.out.println("realQty:\t"+realQty);
		Float grandExpected = (realPrice*realQty),
				grandActual = Float.valueOf(lbGrandTotal.getText().substring(1));
		System.out.println("realprice * realQty:\t"+grandExpected);
		System.out.println("grandtotal substring:\t"+grandActual);
		Assert.assertEquals(grandExpected,grandActual);

		//		check out
		WebElement btnCheckOut = driver.findElement(By.xpath(".//ul[@class='checkout-types bottom']//button[@class='button btn-proceed-checkout btn-checkout']"));
		btnCheckOut.click();
		WebElement txtCompay = driver.findElement(By.id("billing:company"));
		WebElement txtAddress = driver.findElement(By.id("billing:street1"));
		WebElement txtAddress2=driver.findElement(By.id("billing:street2"));
		WebElement txtCity=driver.findElement(By.id("billing:city"));
		WebElement txtStatebill =driver.findElement(By.xpath(".//*[@id='billing:region_id']/option[text()='Arizona']"));
		WebElement txtZipbill = driver.findElement(By.id("billing:postcode"));
		WebElement txtCountryVN=driver.findElement(By.xpath(".//option[text()='Vietnam']"));
		WebElement txtPhone=driver.findElement(By.id("billing:telephone"));
		WebElement txtFax=driver.findElement(By.id("billing:fax"));
		WebElement txtShipThisAddress=driver.findElement(By.id("billing:use_for_shipping_yes"));
		WebElement btnContinue = driver.findElement(By.xpath(".//button[@title = 'Continue']"));

		//		enter billing information
		txtCompay.sendKeys("Bravebits");
		txtAddress.sendKeys("Hoang Dao Thuy");
		txtAddress2.sendKeys("32 DC");
		txtCity.sendKeys("Ha Noi");
		txtStatebill.click();
		txtZipbill.sendKeys("10000");
		txtCountryVN.click();
		txtPhone.sendKeys("093453534");
		txtFax.sendKeys("3243242");
		if(!txtShipThisAddress.isSelected()){
			txtShipThisAddress.click();
		}
		btnContinue.click();

		//		select shipping method
		WebElement btnContinue_SaveShippingMethod = driver.findElement(By.xpath("//button[@onclick = 'shippingMethod.save()']"));
		wait.until(ExpectedConditions.visibilityOf(btnContinue_SaveShippingMethod));
		btnContinue_SaveShippingMethod.click();
		Thread.sleep(2000);

		//		payment info
		WebElement rdCheckMoneyOrder = driver.findElement(By.id("p_method_checkmo"));
		rdCheckMoneyOrder.click();
		WebElement btnContinue_SavePayment=driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button"));
		btnContinue_SavePayment.click();

		//		Order review
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[@class='first']//span[@class='price']")));
		WebElement subTotalOnBill=driver.findElement(By.xpath(".//tr[@class='first']//span[@class='price']"));
		Assert.assertEquals(grandExpected, Float.valueOf(subTotalOnBill.getText().substring(1)));
		WebElement btnPlaceOrder = driver.findElement(By.xpath(".//button[@class='button btn-checkout' and @type='submit']"));
		btnPlaceOrder.click();

		//		verify alert announce place order success
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Your order has been received.']")));
		WebElement alertOrderReceived = driver.findElement(By.xpath("//*[text()='Your order has been received.']"));
		Assert.assertTrue(alertOrderReceived.isDisplayed());
	}

}

