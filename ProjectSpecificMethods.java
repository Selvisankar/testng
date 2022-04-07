package assignments;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ProjectSpecificMethods {
	
	public ChromeDriver driver;
	public String excelfilepath;

	@Parameters({ "URL" }) // This gets the value for the URL from the xml ...parameters are static data
	@BeforeMethod
	
	public void beforeMethod(String url) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				driver.manage().window().maximize(); 
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@DataProvider(name = "Dynamic_Data")//dataprovider is a dynamic data
	public String[][] testData() throws IOException {
		String[][] data = readexcel.getdata(excelfilepath);
		return data;
	}
}
