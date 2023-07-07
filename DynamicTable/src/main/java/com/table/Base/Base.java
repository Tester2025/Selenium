package com.table.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	String browser="chrome";
	public WebDriver init() {
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new ChromeDriver();
	}
	return driver;
	}
	

}
