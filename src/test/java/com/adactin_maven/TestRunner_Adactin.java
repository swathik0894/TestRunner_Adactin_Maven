package com.adactin_maven;

	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	//import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
		
	public class TestRunner_Adactin {
		

		public static WebDriver driver;

			private static void chrome_Launch() {

				System.setProperty("webdriver.chrome.driver",
						"C:\\Java_workspace\\Eclipse\\Selenium_Concepts\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			private static void Launch_Url() {
				driver.get("https://adactinhotelapp.com/");
				driver.manage().window().maximize();
			}

			private static void Login_Credentials() {
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Jivita04");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
				driver.findElement(By.xpath("//input[@type='Submit']")).click();
			}

			private static void Location_Dropdown() throws InterruptedException {
				WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
				Thread.sleep(2000);
				Select s = new Select(location);
				s.selectByVisibleText("Sydney");
				Thread.sleep(2000);
			}

			private static void Hotels_Dropdown() throws InterruptedException {
				WebElement hotels = driver.findElement(By.xpath("//select[@id='hotels']"));
				Thread.sleep(2000);
				Select s1 = new Select(hotels);
				s1.selectByValue("Hotel Sunshine");
				Thread.sleep(2000);
			}

			private static void RoomType_Dropdown() throws InterruptedException {
				WebElement roomtype = driver.findElement(By.xpath("//select[@name='room_type']"));
				Thread.sleep(2000);
				Select s2 = new Select(roomtype);
				s2.selectByIndex(3);
				Thread.sleep(2000);
			}

			private void Children_Dropdown() throws InterruptedException {
				WebElement Child = driver.findElement(By.xpath("//select[@name='child_room']"));
				Thread.sleep(2000);
				Select s3 = new Select(Child);
				s3.selectByValue("1");
				Thread.sleep(2000);

			}

			private static void Search_Click() {
				driver.findElement(By.xpath("//input[@name='Submit']")).click();

			}

			private static void Radio_Button() {
				driver.findElement(By.xpath("//input[@name='radiobutton_0']")).click();
				driver.findElement(By.xpath("//input[@type='submit']")).click();
			}

//			 private static void Scroll_Concept() {
//				JavascriptExecutor js=(JavascriptExecutor) driver;
//				js.executeScript("window.scrollBy(0,200)");
		//
//			}

			private static void Details() {
				driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Swathi");
				driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("K");
				driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Anna Nagar");
				driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys("1234567890123456");
			}

			private static void CreditCard_Select() throws InterruptedException {
				WebElement CC_Dropdown = driver.findElement(By.xpath("//select[@id='cc_type']"));
				Select s4 = new Select(CC_Dropdown);
				s4.selectByValue("VISA");
				Thread.sleep(2000);
			}

			private static void ExpiryDate_Dropdown() throws InterruptedException {
				WebElement expirydate = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
				Select s5 = new Select(expirydate);
				s5.selectByVisibleText("February");
				Thread.sleep(2000);
				WebElement expiryMonth = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
				Select s6 = new Select(expiryMonth);
				s6.selectByValue("2024");
				Thread.sleep(1000);
			}

			private static void CVV_Field() throws InterruptedException {
				driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("344");
				
				//bookNow click
				driver.findElement(By.xpath("//input[@name='book_now']")).click();
				Thread.sleep(3000);

			}

			private static void Itenary_Click() throws InterruptedException {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();

			}
			
			private static void Screenshot_Method() throws IOException, InterruptedException {
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("C:\\Java_workspace\\Eclipse\\Selenium_Concepts\\Screenshots\\Adactin.png");
				FileUtils.copyFile(src, dest);
				Thread.sleep(2000);

			}
			
			private static void Logout() {
				driver.findElement(By.xpath("//input[@name='logout']")).click();
				
				//Login again
				driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();
				driver.quit();
			}

			public static void main(String[] args) throws InterruptedException, IOException {
				chrome_Launch();
				Launch_Url();
				Login_Credentials();
				Location_Dropdown();
				Hotels_Dropdown();
				RoomType_Dropdown();
				Search_Click();
				Radio_Button();
//				Scroll_Concept();
				Details();
				CreditCard_Select();
				ExpiryDate_Dropdown();
				CVV_Field();
				Itenary_Click();
				Screenshot_Method();
				Logout();

			}
		}





