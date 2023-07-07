package com.table.cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.table.Base.Base;

public class Testcase extends Base {

	@BeforeTest()
	public void initialization() {
		driver = init();
	}

	@Test(dataProvider = "dataset")
	public void testcae(String[] s) throws InterruptedException {
		driver.get("https://demo:demo@demo.opencart.com/admin");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(s[0]);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(s[1]);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	/*	driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		driver.findElement(By.xpath("//li//a[text()='Orders']")).click();
		String custName = "Marcus van Tiddens";
		WebElement cname = driver.findElement(By.xpath("//table//tbody//td[contains(text(),'" + custName + "')]"));
		System.out.println(cname.getText());

		// 2nd method

		List<WebElement> lists = driver.findElements(By.xpath("//table//tbody//tr//td[4]"));
		System.out.println(lists.size());
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getText().equals("Marcus van Tiddens")) {
				String path = "//table//tbody//tr[" + (i + 1) + "]//td[1]";
				driver.findElement(By.xpath(path)).click();
				break;
			}
		}*/

	}

	@Test(invocationCount = 5)
	public void testcase1() {
		System.out.println("testcase 1");
	}

	@Test(dependsOnMethods = "testcase1")
	public void testcase2() {
		System.out.println("testcase 2");
	}

	@Ignore()
	@Test(dependsOnMethods = "testcase2", dataProvider = "datasets")
	public void testcase3(String data) {
		System.out.println("testcase 3" + data);
	}

	@DataProvider(name = "excel")
	public String[][] excelsheet() throws IOException {
		File file = new File("");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet("0");
		int rows = sheet.getLastRowNum();
		for (int i = 0; i < rows; i++) {
			XSSFRow data = sheet.getRow(i);
			System.out.println(data.getCell(0).getStringCellValue());
			System.out.println(data.getCell(1).getStringCellValue());
			System.out.println(data.getCell(2).getStringCellValue());
		}

		return null;

	}

	@DataProvider(name = "datasets")
	public String[] datas() {
		String[] datas = { "name", "surya", "madhu", "file" };
		return datas;

	}

	@DataProvider(name = "dataset")
	public String[][] datasupply() {
		String[][] data = { { "dem01", "demo1" }, { "dem02", "demo2" }, { "demo", "demo" }, };
		return data;
	}

}
