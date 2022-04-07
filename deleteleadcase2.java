package assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.Before;

public class deleteleadcase2 extends ProjectSpecificMethods{
	@BeforeTest
	public void setdata() {
		excelfilepath="./testdata/book2.xlsx";
	}
	@Test(dataProvider = "Dynamic_Data")
	public void runtc002(String username,String password,String phonenumber) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//span[text()='phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']]")).sendKeys(phonenumber);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	String leadid=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.findElement(By.linkText("Delete")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadid);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
String text=driver.findElement(By.className("X-paging-info")).getText();
if(text.equals("no records to display")) {
	System.out.println("text matched");
	
}
else {
	System.out.println("text not matched");
}
	
	
	
	
}
}
