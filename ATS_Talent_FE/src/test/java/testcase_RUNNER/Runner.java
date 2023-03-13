package testcase_RUNNER;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import support_Files.Base_Class;
import support_Files.ScreenRecorderUtil;
import utilities_ATS.ReadXlsx_Login;

		
	
		
	
public class Runner {

	public static WebDriver driver;
	static Properties prop = new Properties();
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/WorkOpportunities/AllOpportunities_FrontEnd.html");

	//	static ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Assessment/python.html");
	
	
	
	@BeforeClass
	public  void set_Up() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\Properties\\locator.properties");
		prop.load(fis);
		extent.attachReporter(spark);
		
	//	ScreenRecorderUtil.startRecord("set_Up");

		String browser_Name = prop.getProperty("browser");
		if (browser_Name.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();

		} else if (browser_Name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();

		} else if (browser_Name.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		}
		
		
		
		
	}
	
	@Test(dataProvider="Login" , dataProviderClass =ReadXlsx_Login.class , priority=0)
	public  void Login(String username , String password) throws IOException, InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(username);
		driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(password);
		driver.findElement(By.xpath(prop.getProperty("Submit"))).click();
		
		Thread.sleep(5000);
	
	}

	public static String Screenshot(String filepath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filepath);
		FileUtils.copyFile(source, destination);
		
		InputStream is = new FileInputStream(filepath);
		byte[] byteArray = IOUtils.toByteArray(is);
		String screenshot = Base64.getEncoder().encodeToString(byteArray);
		return screenshot;
	}
	
	@AfterClass
	public  void tear_Down() throws Exception {

	//	ScreenRecorderUtil.stopRecord();
		
	//	driver.quit();
	}
}
