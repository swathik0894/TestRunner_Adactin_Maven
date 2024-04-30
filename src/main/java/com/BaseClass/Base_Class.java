package com.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver; // null
	public static String value; // null

	// browserLaunch Method
	public static WebDriver browserLaunch(String type) {
		if (type.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (type.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;

	}

	// getURL Method
	public static WebDriver getUrl(String url) {

		driver.get(url);
		return driver;
	}

	// click Method
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	// send_keys Method
	public static void inputvalueElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	// close Method
	public static WebDriver close() {
		driver.close();
		return driver;

	}

	// quit Method
	public static WebDriver quit() {
		driver.quit();
		return driver;

	}

	// drop_down Method
	public static void dropdown(WebElement element, String type, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (type.equalsIgnoreCase("index")) {
			int data = Integer.parseInt(value);
			s.selectByIndex(data);

		} else if (type.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		}

	}

	// Alert Methods
	public static WebDriver accept() {
		driver.switchTo().alert().accept();
		return driver;

	}

	public static WebDriver dismiss() {
		driver.switchTo().alert().dismiss();
		return driver;

	}

	public static WebDriver getText() {
		driver.switchTo().alert().getText();
		return driver;

	}

	// Screenshot Method
	public static void screenshot(WebElement element, String value) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(value);
		FileUtils.copyFile(src, des);

	}

	// getTitle Method
	public static WebDriver getTitle() {
		driver.getTitle();
		return driver;

	}

	// getText Method
	public static void getText(WebElement element) {
		element.getText();

	}

	// getCurrentUrl Method
	public static WebDriver getCurrentUrl() {
		driver.getCurrentUrl();
		return driver;

	}

	// getAttribute Method
	public static void getAttribute(WebElement element, String value) {
		element.getAttribute(value);
	}

	// isEnabled Method
	public static void isEnabled(WebElement element) {
		element.isEnabled();

	}

	// isDisplayed Method
	public static void isDisplayed(WebElement element) {
		element.isDisplayed();

	}

	// isSelected Method
	public static void isSelected(WebElement element) {
		element.isSelected();

	}

	// windowHandles Method
	public static WebDriver windowHandle() {
		driver.getWindowHandles();
		return driver;

	}

	// Actions Method
	public static void Actions(WebElement element, String type, WebElement target) {
		Actions a = new Actions(driver);
		if (type.equalsIgnoreCase("moveToElement")) {
			a.moveToElement(element).perform();

		} else if (type.equalsIgnoreCase("doubleClick")) {
			a.doubleClick(element).perform();

		} else if (type.equalsIgnoreCase("contextClick")) {
			a.contextClick(element).perform();

		} else if (type.equalsIgnoreCase("draganddrop")) {
			a.dragAndDrop(element, target).perform();

		}
	}

	// scroll Method
	public static void scroll(String type) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (type.equalsIgnoreCase("bottom")) {
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)"); // scroll to bottom
		} else if (type.equalsIgnoreCase("top")) {
			js.executeScript("window.scrollTo(0,0)"); // scroll to top

		}

	}

	// Navigation Methods
	public static WebDriver navigate(String type, String value) {
		if (type.equalsIgnoreCase("to")) {
			driver.navigate().to(value);

		} else if (type.equalsIgnoreCase("Back")) {
			driver.navigate().back();

		} else if (type.equalsIgnoreCase("Forward")) {
			driver.navigate().forward();

		} else if (type.equalsIgnoreCase("Refresh")) {
			driver.navigate().refresh();

		}
		return driver;

	}

	// Frames Method
	public static void frames(String frame1, int frameint, WebElement element) {
		if (frame1.equalsIgnoreCase("frame1")) {
			driver.switchTo().frame(element);

		} else if (frame1.equalsIgnoreCase("frameint")) {
			driver.switchTo().frame(frameint);

		} else if (frame1.equalsIgnoreCase("parentframe")) {
			driver.switchTo().parentFrame();

		} else if (frame1.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();

		}

	}

	// wait Method
	public static void waitforPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// getOptions Method
	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		s.getOptions();

	}

	// getList selected option Method
	public static void getlistSelectedOption(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();

	}

	// isMultiple Method
	public static void isMultiple(WebElement element) {
		Select dropdown = new Select(element);
		dropdown.isMultiple();

	}

 }
