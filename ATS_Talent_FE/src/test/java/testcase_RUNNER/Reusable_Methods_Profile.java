package testcase_RUNNER;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import support_Files.Base_Class;
import support_Files.ScreenRecorderUtil;
import utilities_ATS.ReadXlsx_Certification;
import utilities_ATS.ReadXlsx_Core_Competencies;
import utilities_ATS.ReadXlsx_Education;
import utilities_ATS.ReadXlsx_Login;
import utilities_ATS.ReadXlsx_Major_Projects;
import utilities_ATS.ReadXlsx_Personal_Details;
import utilities_ATS.ReadXlsx_Preference;
import utilities_ATS.ReadXlsx_Professional_Experience;
import utilities_ATS.ReadXlsx_Testimonials;

public class Reusable_Methods_Profile extends Runner {
	
	@Ignore
	@Test(dataProvider="Personal_Data" , dataProviderClass =ReadXlsx_Personal_Details.class , priority=1)
	public void Personal_Details(String Photo , String Name, String DOB, String Email, String PhoneNumber, String Address,
			String City, String	Pincode, String	LinkedIn_Profile , String Resume) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		Thread.sleep(1500);
		
			
		String Talent_Previous_Pic = Screenshot("SNAPS\\Profile\\Personal_Details\\Previous_Pic.png");
		
		driver.findElement(By.xpath(prop.getProperty("profile_Picture_link"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("profile_Picture"))).sendKeys(Photo);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

				
	//********************************* Add Personal Details***********************************
				
		Thread.sleep(1000);
		
		// Talent_Profile_Screenshot
		
		String Talent_Updated_Pic = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Updated_Pic.png");
		extent.createTest("Talent Change Profile Picture ").log(Status.INFO, "Talent_Profile_Pic_Changed").addScreenCaptureFromBase64String(Talent_Previous_Pic).addScreenCaptureFromBase64String(Talent_Updated_Pic);
		
		
		driver.findElement(By.xpath(prop.getProperty("personal_Details_Add"))).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(1000);
		String Talent_Personal_Details_Before = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Personal_Details_Before.png");
		extent.createTest("Talent_Personal_Details_Before_Edit").log(Status.INFO, "Talent_Personal_Details_Before_Edit").addScreenCaptureFromBase64String(Talent_Personal_Details_Before);
		
		
		js.executeScript("window.scroll(0,300)");
		driver.findElement(By.xpath(prop.getProperty("personal_Details_Edit"))).click();
		Thread.sleep(1500);
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Name"))).clear();
		Thread.sleep(1000);
		String Talent_Name_Edit = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Name_Edit.png");
		
		driver.findElement(By.xpath(prop.getProperty("Name"))).sendKeys(Name);
	
		String Talent_Name_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Name_Changed.png");
		
		extent.createTest("Talent_Edit_Name").log(Status.INFO, "Talent Name Changed")
		.addScreenCaptureFromBase64String(Talent_Name_Edit).addScreenCaptureFromBase64String(Talent_Name_Changed);
		
		driver.findElement(By.xpath(prop.getProperty("Gender"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Female"))).click();
	
		
		String Talent_Gender_Edit = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Gender_Edit.png");
		driver.findElement(By.xpath(prop.getProperty("Gender"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("Male"))).click();
		
		String Talent_Gender_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Gender_Changed.png");
		
		extent.createTest("Talent_Edit_Gender").log(Status.INFO, "Talent Gender Changed ")
		.addScreenCaptureFromBase64String(Talent_Gender_Edit).addScreenCaptureFromBase64String(Talent_Gender_Changed);
	
		driver.findElement(By.xpath(prop.getProperty("DOB"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("DOB"))).clear();
		driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys("05/14/1996");
		String Talent_DOB_Edit = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_DOB_Edit.png");
		
		
		String Talent_DOB_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_DOB_Changed.png");
		extent.createTest("Talent_Edit_DOB").log(Status.INFO, "Talent DOB Changed").addScreenCaptureFromBase64String(Talent_DOB_Edit).addScreenCaptureFromBase64String(Talent_DOB_Changed);
	
	
		
		driver.findElement(By.xpath(prop.getProperty("Email"))).click();
		Thread.sleep(1000);
		
		String Talent_Edit_MobileNumber = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Edit_MobileNumber.png");
	
		driver.findElement(By.xpath(prop.getProperty("phone_Number"))).click();
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("phone_Number"))).sendKeys(PhoneNumber);
		Thread.sleep(1000);
		
		String Talent_MobileNumber_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_MobileNumber_Changed.png");
		extent.createTest("Talent_Edit_MobileNumber").log(Status.INFO, "Talent_MobileNumber Changed").addScreenCaptureFromBase64String(Talent_Edit_MobileNumber).addScreenCaptureFromBase64String(Talent_MobileNumber_Changed);
	
		String Talent_Edit_Address = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Edit_Address.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("Address"))).clear();
	
		driver.findElement(By.xpath(prop.getProperty("Address"))).sendKeys(Address);
	
		
		String Talent_Address_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Address_Changed.png");
		extent.createTest("Talent_Edit_Address").log(Status.INFO, "Talent_Address_Changed").addScreenCaptureFromBase64String(Talent_Edit_Address).addScreenCaptureFromBase64String(Talent_Address_Changed);
	
		
		
		driver.findElement(By.xpath(prop.getProperty("City"))).clear();
	
		
		String Talent_Edit_City = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Edit_City.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("City"))).sendKeys(City);
	
		
		String Talent_City_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_City_Changed.png");
		extent.createTest("Talent_Edit_City").log(Status.INFO, "Talent_City_Changed").addScreenCaptureFromBase64String(Talent_Edit_City).addScreenCaptureFromBase64String(Talent_City_Changed);
		
		driver.findElement(By.xpath(prop.getProperty("Pincode"))).clear();
		
		
		String Talent_Edit_Pincode = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Edit_Pincode.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("Pincode"))).sendKeys(Pincode);
	
		
		String Talent_Pincode_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Pincode_Changed.png");
		extent.createTest("Talent_Edit_Pincode").log(Status.INFO, "Talent_Pincode_Changed").addScreenCaptureFromBase64String(Talent_Edit_Pincode).addScreenCaptureFromBase64String(Talent_Pincode_Changed);
		
		driver.findElement(By.xpath(prop.getProperty("Linkedin_Profile_Edit"))).clear();
	
		
		String Talent_Edit_Linkedin = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Edit_Linkedin.png");
		
		driver.findElement(By.xpath(prop.getProperty("Linkedin_Profile_Edit"))).sendKeys(LinkedIn_Profile);
		Thread.sleep(1000);
		
		String Talent_Linkedin_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Linkedin_Changed.png");
		extent.createTest("Talent_Edit_Linkedin").log(Status.INFO, "Talent_Linkedin_Changed").addScreenCaptureFromBase64String(Talent_Edit_Linkedin).addScreenCaptureFromBase64String(Talent_Linkedin_Changed);
		
		Thread.sleep(1000);
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);
		String Talent_Resume_Replace = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Resume_Replace.png");
		
		driver.findElement(By.xpath(prop.getProperty("resume_Replace_Link"))).click();
		Thread.sleep(1000);
	
		
		driver.findElement(By.xpath(prop.getProperty("resume_Replace_File"))).sendKeys(Resume);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		
		
		
		Thread.sleep(1000);
		
		String Talent_Resume_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Resume_Changed.png");
		extent.createTest("Talent_Resume_Replace").log(Status.INFO, "Talent_Resume_Changed")
		.addScreenCaptureFromBase64String(Talent_Resume_Replace).addScreenCaptureFromBase64String(Talent_Resume_Changed);
		
				
		
		
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("personal_Details_Save_Changes"))).click();
		
		js.executeScript("window.scroll(200,0)");
		js.executeScript("window.scroll(0,800)");
//		
	//	driver.findElement(By.xpath(prop.getProperty("personal_Details_Minimize"))).click();
		Thread.sleep(1000);
		
		String Talent_Personal_Details_Changed = Screenshot("SNAPS\\Profile\\Personal_Details\\Talent_Personal_Details_Changed.png");
	
		extent.createTest("Talent Personal Details Changed").log(Status.PASS, "Personal Details of Talent Changed Successfully").addScreenCaptureFromBase64String(Talent_Personal_Details_Changed);
		
	
		
	}
	
	
	@Ignore
	@Test(dataProvider="preferences" , dataProviderClass= ReadXlsx_Preference.class , priority=2 )
	public void preference(String JobTitle, String Work_Experience, String Current_Pay , String Expected_Pay , String Interest, String Introduction) throws Exception {
		Robot r = new Robot();
		
//		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		JavascriptExecutor js =(JavascriptExecutor)driver;
	
		
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		Thread.sleep(1500);
		
	//	js.executeScript("window.scroll(0,400)");
		
		driver.findElement(By.xpath(prop.getProperty("preference_Add"))).click();
		Thread.sleep(1500);
		js.executeScript("window.scroll(0,400)");
		driver.findElement(By.xpath(prop.getProperty("preference_Edit"))).click();
		Thread.sleep(1500);
		
		String  Add_Preference= Screenshot("SNAPS\\Preference\\Add_Preferences.png");
		extent.createTest("Preferences").log(Status.INFO, "Preference Data to be Enter").addScreenCaptureFromBase64String(Add_Preference);
	
		driver.findElement(By.xpath(prop.getProperty("job_Title"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("job_Title"))).clear();
	
		driver.findElement(By.xpath(prop.getProperty("job_Title"))).sendKeys(JobTitle);
	
		
		String  Current_Job_Title= Screenshot("SNAPS\\Preference\\Current_Job_Title.png");
		extent.createTest("Current_Job_Title").log(Status.INFO, "Current Job Title Entered").addScreenCaptureFromBase64String(Current_Job_Title);
		
		
	
		driver.findElement(By.xpath(prop.getProperty("employee_Status"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
		
		driver.findElement(By.xpath(prop.getProperty("employee_Status"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("employee_Status"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		

		String  employee_Status= Screenshot("SNAPS\\Preference\\employee_Status.png");
		extent.createTest("employee_Status").log(Status.INFO, "Employee_Status Entered").addScreenCaptureFromBase64String(employee_Status);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Work_Experience"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Work_Experience"))).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Work_Experience"))).sendKeys(Work_Experience);
		Thread.sleep(2000);
		
		String  Talent_Work_Experience= Screenshot("SNAPS\\Preference\\Work_Experience.png");
		extent.createTest("Work_Experience").log(Status.INFO, "Work_Experience Entered").addScreenCaptureFromBase64String(Talent_Work_Experience);
	
		driver.findElement(By.xpath(prop.getProperty("notice_Period"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
//		driver.findElement(By.xpath(prop.getProperty("notice_Period_Morethan_8_Weeks"))).click();
//		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("notice_Period"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
//		driver.findElement(By.xpath(prop.getProperty("notice_Period_4_to_8_Weeks"))).click();
//		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("notice_Period"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
//		driver.findElement(By.xpath(prop.getProperty("notice_Period_2_To_4_Weeks"))).click();
//		Thread.sleep(1500);
		
//		driver.findElement(By.xpath(prop.getProperty("notice_Period"))).click();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath(prop.getProperty("notice_Period_Within_2Weeks"))).click();
//		Thread.sleep(1500);
//		
//		driver.findElement(By.xpath(prop.getProperty("notice_Period"))).click();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath(prop.getProperty("notice_Period_Immediately"))).click();
//		Thread.sleep(1500);
		
		String  Notice_Period= Screenshot("SNAPS\\Preference\\Notice_Period.png");
		extent.createTest("Notice_Period").log(Status.INFO, "Notice_Period Entered").addScreenCaptureFromBase64String(Notice_Period);
	
		
		driver.findElement(By.xpath(prop.getProperty("current_Pay"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("current_Pay"))).clear();
	
		driver.findElement(By.xpath(prop.getProperty("current_Pay"))).sendKeys(Current_Pay);
	
		
	
		String  Talent_Current_Pay= Screenshot("SNAPS\\Preference\\Current_Pay.png");
		extent.createTest("Current_Pay").log(Status.INFO, "Current_Pay Entered").addScreenCaptureFromBase64String(Talent_Current_Pay);
	
		driver.findElement(By.xpath(prop.getProperty("expected_Pay"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("expected_Pay"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("expected_Pay"))).sendKeys(Expected_Pay);
	
		
		
		String  Talent_Expected_Pay= Screenshot("SNAPS\\Preference\\Expected_Pay.png");
		extent.createTest("Expected_Pay").log(Status.INFO, "Expected_Pay Entered").addScreenCaptureFromBase64String(Talent_Expected_Pay);
	
		
		driver.findElement(By.xpath(prop.getProperty("International_Clients_No"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("International_Clients_Yes"))).click();
	
		
	
		String  International_Clients= Screenshot("SNAPS\\Preference\\International_Clients.png");
		extent.createTest("International_Clients").log(Status.INFO, "International_Clients Entered").addScreenCaptureFromBase64String(International_Clients);
	
		
		driver.findElement(By.xpath(prop.getProperty("associated_Uplers"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	//	driver.findElement(By.xpath(prop.getProperty("associated_Uplers_PartTime"))).click();
		
		
		
		
//		driver.findElement(By.xpath(prop.getProperty("associated_Uplers"))).click();
//		Thread.sleep(1500);
//		
//		
//		
//		driver.findElement(By.xpath(prop.getProperty("associated_Uplers_Project_2_Project"))).click();
//		Thread.sleep(1500);
		
	//	driver.findElement(By.xpath(prop.getProperty("associated_Uplers"))).click();
		
		//driver.findElement(By.xpath(prop.getProperty("associated_Uplers_FullTime"))).click();
		
		
		String  Associated_With_Uplers= Screenshot("SNAPS\\Preference\\Associated_With_Uplers.png");
		extent.createTest("Associated_With_Uplers").log(Status.INFO, "Associated_With_Uplers Entered").addScreenCaptureFromBase64String(Associated_With_Uplers);
	
		js.executeScript("window.scroll(0,1000)");
		driver.findElement(By.xpath(prop.getProperty("Method_Of_Working_preference1"))).click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	//	WebElement findElement = driver.findElement(By.xpath(prop.getProperty("preference1_Hybrid")));
		//System.out.println(findElement.getText());
	//	driver.findElement(By.xpath(prop.getProperty("preference1_Hybrid"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Method_Of_Working_preference2"))).click();
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		//driver.findElement(By.xpath(prop.getProperty("preference2_Remote"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Method_Of_Working_preference3"))).click();
		Thread.sleep(1500);
		
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath(prop.getProperty("preference3_Office"))).click();
		
		String  Method_Of_Working= Screenshot("SNAPS\\Preference\\Method_Of_Working.png");
		extent.createTest("Method_Of_Working").log(Status.INFO, "Method_Of_Working Entered").addScreenCaptureFromBase64String(Method_Of_Working);
	
		
		
		driver.findElement(By.xpath(prop.getProperty("Working_Hours_Preference1"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath(prop.getProperty("Working_Hours1_UK_Shift"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Working_Hours_Preference2"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath(prop.getProperty("Working_Hours2_AU_Shift"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Working_Hours_Preference3"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		//driver.findElement(By.xpath(prop.getProperty("Working_Hours3_US_Shift"))).click();
		
		String  Working_Hours= Screenshot("SNAPS\\Preference\\Working_Hours.png");
		extent.createTest("Working_Hours").log(Status.INFO, "Working_Hours Entered").addScreenCaptureFromBase64String(Working_Hours);
	
		
		driver.findElement(By.xpath(prop.getProperty("Interest"))).click();
		Thread.sleep(2000);
		
		
		try {
		List<WebElement> findElements = driver.findElements(By.xpath(prop.getProperty("Interest_Choose")));
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase(Interest)) {
				webElement.click();
			}
		}
		}
		catch(StaleElementReferenceException e){
			List<WebElement> findElements = driver.findElements(By.xpath(prop.getProperty("Interest_Choose")));
			for (WebElement webElement : findElements) {
				System.out.println(webElement.getText());
				if (webElement.getText().equalsIgnoreCase(Interest)) {
					webElement.click();
				}
			}
			
			
			
		}
		
		
		String  Talent_Interest= Screenshot("SNAPS\\Preference\\Talent_Interest.png");
		extent.createTest("Talent_Interest").log(Status.INFO, "Talent_Interest Entered").addScreenCaptureFromBase64String(Talent_Interest);
	
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Bold"))).click();
	
		Thread.sleep(1000);
																														
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.findElement(By.xpath(prop.getProperty("Introduction"))).click();
	
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Bold"))).click();
		driver.findElement(By.xpath(prop.getProperty("Introduction"))).click();
		 r.keyPress(KeyEvent.VK_CONTROL);
	        r.keyPress(KeyEvent.VK_A);
	        r.keyPress(KeyEvent.VK_BACK_SPACE);
	        r.keyRelease(KeyEvent.VK_BACK_SPACE);
	        r.keyRelease(KeyEvent.VK_A);
	        r.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.findElement(By.xpath(prop.getProperty("Introduction"))).sendKeys(Introduction);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		driver.findElement(By.xpath(prop.getProperty("Introduction_Bold"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Italic"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Underlined"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Bullet"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Number"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Undo"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Introduction_Redo"))).click();
		Thread.sleep(1000);
		
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		
		Thread.sleep(2000);
		String  Talent_Introduction= Screenshot("SNAPS\\Preference\\Talent_Introduction.png");
		extent.createTest("Talent_Introduction").log(Status.INFO, "Talent_Introduction Entered").addScreenCaptureFromBase64String(Talent_Introduction);
	
		driver.findElement(By.xpath(prop.getProperty("Preference_Save"))).click();
		Thread.sleep(3000);
		
		js.executeScript("window.scroll(200,0)");
		js.executeScript("window.scroll(0,400)");
		
		Thread.sleep(4000);
		String  Talent_Preference_Data= Screenshot("SNAPS\\Preference\\Talent_Preference_Data.png");
		extent.createTest("Talent_Preference_Data").log(Status.PASS, "Talent_Preference_Data Entered").addScreenCaptureFromBase64String(Talent_Preference_Data);
	

		
		extent.flush();
		Thread.sleep(4000);
		
		
	}
	
	
	@Ignore
	@Test(dataProvider="professional_Experience_Data" , dataProviderClass =ReadXlsx_Professional_Experience.class , priority=4)
	public  void Professional_Experience(String Designation , String Company_Name , String Start_Date, String End_Date, String Roles) throws Exception {

		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Robot r = new Robot();
		
	
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Professional_Experience_Add"))).click();

		
		Thread.sleep(1500);
		
		String Talent_Edit_Experience = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Edit_Experience.png");
		extent.createTest("Talent_Edit_Experience").log(Status.INFO, "Talent Delete Past Experience")
		.addScreenCaptureFromBase64String(Talent_Edit_Experience);
		
		
	//	driver.findElement(By.xpath(prop.getProperty("Professional_Experience_Delete"))).click();
		Thread.sleep(1500);
	//	Alert confirm = driver.switchTo().alert();
	//	confirm.accept();
		Thread.sleep(1500);
	//	js.executeScript("window.scroll(0,200)");
	//	driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		
	//	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(prop.getProperty("Designation"))));
		driver.findElement(By.xpath(prop.getProperty("Designation"))).click();
		
		String Talent_Edit_Designation = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Edit_Designation.png");
		driver.findElement(By.xpath(prop.getProperty("Designation"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Designation"))).sendKeys(Designation);
		
		String Talent_Designation_Changed = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Designation_Changed.png");
		extent.createTest("Talent Edit Designation").log(Status.INFO, "Talent Designation Changed")
		.addScreenCaptureFromBase64String(Talent_Edit_Designation).addScreenCaptureFromBase64String(Talent_Designation_Changed);
		
		driver.findElement(By.xpath(prop.getProperty("Company_Name"))).click();
		
		String Talent_Edit_CompanyName = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Edit_CompanyName.png");
		driver.findElement(By.xpath(prop.getProperty("Company_Name"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Company_Name"))).sendKeys(Company_Name);
		
		String Talent_CompanyName_Changed = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_CompanyName_Changed.png");
		extent.createTest("Talent Edit Company_Name").log(Status.INFO, "Company Name Changed")
		.addScreenCaptureFromBase64String(Talent_Edit_CompanyName).addScreenCaptureFromBase64String(Talent_CompanyName_Changed);
		
		
		driver.findElement(By.xpath(prop.getProperty("Start_Date"))).click();	
		
		String Talent_Experience_StartDate = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Experience_StartDate.png");
		
		for(int i=0 ; i<=7 ; i++) {
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Start_Date"))).sendKeys(Start_Date);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath(prop.getProperty("End_Date"))).click();	
		
		
		
		for(int i=0 ; i<=7 ; i++) {
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("End_Date"))).sendKeys(End_Date);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
	
		String Talent_Experience_EndDate = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Experience_EndDate.png");
		extent.createTest("Talent Enter Experience ").log(Status.INFO, "Talent Experience Changed")
		.addScreenCaptureFromBase64String(Talent_Experience_StartDate).addScreenCaptureFromBase64String(Talent_Experience_EndDate);
		
		driver.findElement(By.xpath(prop.getProperty("Current_Working"))).click();
		
		String Talent_Current_Working = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Current_Working.png");
		extent.createTest("Talent Current Working").log(Status.INFO, "Talent Click Currently Work here")
		.addScreenCaptureFromBase64String(Talent_Current_Working);
		
		

		driver.findElement(By.xpath(prop.getProperty("Roles&Responsibilities"))).click();
		
		String Talent_Add_Roles_Responsibilities = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Add_Roles_Responsibilities.png");
		
		driver.findElement(By.xpath(prop.getProperty("Roles&Responsibilities"))).sendKeys(Roles);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		driver.findElement(By.xpath(prop.getProperty("Bold"))).click();
		driver.findElement(By.xpath(prop.getProperty("Italic"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Underlined"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Number"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Undo"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Redo"))).click();
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		
		String Talent_Roles_Responsibilities = Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Roles_Responsibilities.png");
		
		driver.findElement(By.xpath(prop.getProperty("Roles_Save"))).click();
		Thread.sleep(2000);
		
		
		extent.createTest("Talent Roles & Responsibilities").log(Status.INFO, "Roles & Responsibilities Changed")
		.addScreenCaptureFromBase64String(Talent_Add_Roles_Responsibilities).addScreenCaptureFromBase64String(Talent_Roles_Responsibilities);
		
		js.executeScript("window.scroll(50,0)");
		Thread.sleep(2000);
		
		
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(3000);
		
		String Talent_Experience_Changed= Screenshot("SNAPS\\Profile\\Professional_Experience\\Talent_Experience_Changed.png");
		extent.createTest("Talent Experience Change").log(Status.PASS, "Talent Experience Changed Successfully")
		.addScreenCaptureFromBase64String(Talent_Experience_Changed);
		
		Thread.sleep(2000);
		extent.flush();
	//	ScreenRecorderUtil.stopRecord();
		
	}
	
	
	@Ignore
	@Test(dataProvider="Major_Projects_Data" , dataProviderClass =ReadXlsx_Major_Projects.class , priority=4 , enabled= true)
	public  void Major_Projects(String Project_Name , String Company_Name , String Description ,String Start_Date, String End_Date) throws Exception {

		
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		
		Robot r = new Robot();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,300)");
		
		Thread.sleep(1000);
		
		// Deletion of Existing Project
		
		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Add"))).click();
		Thread.sleep(1500);
	//	driver.findElement(By.xpath(prop.getProperty("Model_Projects_Delete"))).click();
		Thread.sleep(1500);
		
		// Handle Confirm Alert for Deletion of Project
		
//		Alert confirm = driver.switchTo().alert();
//		confirm.accept();
//		
		// *************************Add project**********************
		
		js.executeScript("window.scroll(0,900)");
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).sendKeys(Project_Name);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).sendKeys(Company_Name);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).sendKeys(Description);
		
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bold"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Italic"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Underlined"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Number"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Undo"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Redo"))).click();
		Thread.sleep(1500);
	
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).click();
		Thread.sleep(1500);
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).sendKeys(Start_Date);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).click();
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).sendKeys(End_Date);
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		//Extent Report & Screenshot
		
		String project_1_Details = Screenshot("SNAPS\\Profile\\Major_Projects\\Project_1_Details.png");
		extent.createTest("Major Projects: Add Projects in Talent-Profile").log(Status.INFO, "Projects Fields are Entered").addScreenCaptureFromBase64String(project_1_Details);
		
	

		js.executeScript("window.scroll(0,1200)");
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Save"))).click();
		Thread.sleep(2000);
		
		String first_Project = Screenshot("SNAPS\\Profile\\Major_Projects\\Project_1_Completed.png");
		extent.createTest("First Project").log(Status.PASS, "First Project Successfully Added").addScreenCaptureFromBase64String(first_Project);
		
		Thread.sleep(2000);
	
		js.executeScript("scroll(0,200)");

		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Minimize"))).click();
		Thread.sleep(2000);
		
		// ***********************Add Second Project***********************
		
		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Add"))).click();
		Thread.sleep(1500);
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Add_More"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).sendKeys(Project_Name);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).sendKeys(Company_Name);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).sendKeys(Description);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bold"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Italic"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Underlined"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Number"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Undo"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Redo"))).click();
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).click();
		Thread.sleep(1500);
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).sendKeys(Start_Date);
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).click();
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).sendKeys(End_Date);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		String  Project_2_Details= Screenshot("SNAPS\\Profile\\Major_Projects\\Project_2_Details.png");
		extent.createTest("Second Project Details").log(Status.INFO, "Second Project Details Entered").addScreenCaptureFromBase64String(Project_2_Details);
	
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Save"))).click();
		Thread.sleep(2000);
		
		String  Project_2= Screenshot("SNAPS\\Profile\\Major_Projects\\Project_2.png");
		extent.createTest("Second Project").log(Status.INFO, "Second Project Successfully Added").addScreenCaptureFromBase64String(Project_2);
	
		js.executeScript("scroll(200,0)");

		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Minimize"))).click();
		Thread.sleep(2000);
		
		// *********************Add Third Project********************
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Add"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Major_Projects_Add_More"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Project_Name"))).sendKeys(Project_Name);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).clear();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Company_Name"))).sendKeys(Company_Name);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).sendKeys(Description);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bold"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Italic"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Underlined"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Number"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Undo"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Redo"))).click();
	
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Description"))).click();
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).click();
		Thread.sleep(1500);
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Start_Date"))).sendKeys(Start_Date);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).click();
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_End_Date"))).sendKeys(End_Date);
		Thread.sleep(1500);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
	
		String  Project_3_Details= Screenshot("SNAPS\\Profile\\Major_Projects\\Project_3_Details.png");
		extent.createTest("Third Project Details").log(Status.INFO, "Third Project Details Entered").addScreenCaptureFromBase64String(Project_3_Details);
	
		driver.findElement(By.xpath(prop.getProperty("Model_Projects_Save"))).click();
		Thread.sleep(3000);
		String  Project_3= Screenshot("SNAPS\\Profile\\Major_Projects\\Project_3.png");
		extent.createTest("Third Project").log(Status.INFO, "Third Project Successfully Added").addScreenCaptureFromBase64String(Project_3);
		Thread.sleep(2000);
		extent.createTest("Project Add in different Timeline").log(Status.WARNING, "Projects are add in Same Timeline").addScreenCaptureFromBase64String(Project_3);
		Thread.sleep(2000);
		extent.flush();
		Thread.sleep(5000);
		
	//	ScreenRecorderUtil.stopRecord();
	}
	
		
	@Ignore
	@Test(priority =5 , dataProvider="core_Competencies" , dataProviderClass=ReadXlsx_Core_Competencies.class)
	public void core_Competencies(String Position ,String Application1 ,String Application2 , String Application3 , String Repository_URL , String Skills1 , String Skills2, String Skills3 , String Achievements) throws Exception {

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();

		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		
			
		
		Thread.sleep(3000);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Add"))).click();
		
		//****************************Add_Core_Competencies*****************************************
		
		String Add_Core_Competencies = Screenshot("SNAPS\\Core_Competencies\\Add_Core_Competencies.png");
		extent.createTest("Core Competencies").log(Status.INFO, "Talent Core Competencies to be Enter")
				.addScreenCaptureFromBase64String(Add_Core_Competencies);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Edit"))).click();
		Thread.sleep(2000);
		js.executeScript("scroll(0,1000)");
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Position_Open"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Position_Applied"))).sendKeys(Position);
		Thread.sleep(2000);

		String Position_Entered = Screenshot("SNAPS\\Core_Competencies\\Position_Entered.png");
		extent.createTest("Position_Entered").log(Status.INFO, "Talent Position_Entered")
				.addScreenCaptureFromBase64String(Position_Entered);
		
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(1500);
		
		for (int i = 0; i <=10; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Application_Applied"))).sendKeys(Application1);
		Thread.sleep(1500);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String Application_1 = Screenshot("SNAPS\\Core_Competencies\\Application_1.png");
		extent.createTest("Application_1").log(Status.INFO, "Application_1 Entered")
				.addScreenCaptureFromBase64String(Application_1);

		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Application_Applied"))).sendKeys(Application2);
		Thread.sleep(1500);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String Application_2 = Screenshot("SNAPS\\Core_Competencies\\Application_2.png");
		extent.createTest("Application_2").log(Status.INFO, "Application_2 Entered")
				.addScreenCaptureFromBase64String(Application_2);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Application_Applied"))).sendKeys(Application3);
		Thread.sleep(1000);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		

		String Application_3 = Screenshot("SNAPS\\Core_Competencies\\Application_3.png");
		extent.createTest("Application_3").log(Status.INFO, "Application_3 Entered")
				.addScreenCaptureFromBase64String(Application_3);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
		r.delay(1000);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		

	//	driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Portfolio_URL"))).click();
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Portfolio_URL"))).sendKeys(Repository_URL);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		
		String Repository_url = Screenshot("SNAPS\\Core_Competencies\\Repository_url.png");
		extent.createTest("Repository_url").log(Status.INFO, "Repository_url Entered")
				.addScreenCaptureFromBase64String(Repository_url);
		
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		for (int i = 0; i <= 10; i++) {
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		
		String Add_Skills = Screenshot("SNAPS\\Core_Competencies\\Add_Skills.png");
		extent.createTest("Add_Skills").log(Status.INFO, "Add_Skills ")
				.addScreenCaptureFromBase64String(Add_Skills);
		
		



		
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Skills_Applied"))).sendKeys(Skills3);
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Skills_Applied"))).sendKeys(Skills2);
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	//	driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Skills"))).click();
	

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Skills_Applied"))).sendKeys(Skills1);
		
		String Added_Skills = Screenshot("SNAPS\\Core_Competencies\\Added_Skills.png");
		extent.createTest("Added_Skills").log(Status.INFO, "Added_Skills ")
				.addScreenCaptureFromBase64String(Added_Skills);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements"))).click();

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements"))).sendKeys(Achievements);

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements_Delete"))).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements_Add"))).click();

		Thread.sleep(1500);

		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Achievements"))).sendKeys(Achievements);

		
		String Talent_Achievements = Screenshot("SNAPS\\Core_Competencies\\Talent_Achievements.png");
		extent.createTest("Talent_Achievements").log(Status.INFO, "Talent_Achievements Entered")
				.addScreenCaptureFromBase64String(Talent_Achievements);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(3000);
		
		driver.findElement(By.xpath(prop.getProperty("Core_Competencies_Save"))).click();
		
		Thread.sleep(3000);
		
		js.executeScript("scroll(600,0)");

		js.executeScript("scroll(0,1200)");

		String Core_Competencies_Entered = Screenshot("SNAPS\\Core_Competencies\\Core_Competencies_Entered.png");
		extent.createTest("Core_Competencies_Entered").log(Status.PASS, "Talent Core_Competencies_Entered ")
				.addScreenCaptureFromBase64String(Core_Competencies_Entered);
		
		r.delay(3000);
		
		//extent.flush();
		
		//ScreenRecorderUtil.stopRecord();
	
	}
	
	

	@Ignore
	@Test(priority = 6 , dataProvider="Education" , dataProviderClass=ReadXlsx_Education.class)
	public void Education(String Degree, String University, String Start_Date, String End_Date , String Stream, String School, String StartDate, String EndDate) throws InterruptedException, AWTException, IOException {
		
		
		
		
		
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		
		Thread.sleep(1500);
		
		
		Robot r = new Robot();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("scroll(0,1200)");

		
		
		
		driver.findElement(By.xpath(prop.getProperty("Education_Add"))).click();
		Thread.sleep(1500);
		
		String Add_Degree = Screenshot("SNAPS\\Education\\Talent_Add_Education.png");
		extent.createTest("Add Talent Education ").log(Status.INFO, "Add_Degree")
				.addScreenCaptureFromBase64String(Add_Degree);

		//	driver.findElement(By.xpath(prop.getProperty("Education_Delete"))).click();
		Thread.sleep(1500);
		
		// Handle Confirm Alert for Deletion of Project
//		
//				Alert confirm = driver.switchTo().alert();
//				confirm.accept();
//				
//				
	
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).clear();
	
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).sendKeys(Degree);
		
		
		String Degree_Entered = Screenshot("SNAPS\\Education\\Talent_Enter_Degree.png");
		extent.createTest("Enter_Degree").log(Status.INFO, "Degree_Entered")
				.addScreenCaptureFromBase64String(Degree_Entered);
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).sendKeys(University);
	
		
		
		String Talent_University = Screenshot("SNAPS\\Education\\Talent_University.png");
		extent.createTest("Talent_University ").log(Status.INFO, "Talent_University Entered")
				.addScreenCaptureFromBase64String(Talent_University);
		
	
		
		driver.findElement(By.xpath(prop.getProperty("Education_End_Date"))).click();
	
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		driver.findElement(By.xpath(prop.getProperty("Education_End_Date"))).sendKeys(End_Date);
		
		
	
		
		String Degree_Course_Duration = Screenshot("SNAPS\\Education\\Talent_Degree_Course_Duration.png");
		extent.createTest("Degree_Course_Duration ").log(Status.INFO, "Degree_Course_Duration Entered")
				.addScreenCaptureFromBase64String(Degree_Course_Duration);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	
		
		js.executeScript("scroll(0,1200)");
		
		
		
	//	driver.findElement(By.xpath(prop.getProperty("Education_Discard"))).click();
		driver.findElement(By.xpath(prop.getProperty("Education_Save"))).click();
		
		Thread.sleep(1000);
		String Talent_Degree = Screenshot("SNAPS\\Education\\Talent_Degree.png");
		extent.createTest("Talent_Degree ").log(Status.PASS, "Talent_Degree Entered")
				.addScreenCaptureFromBase64String(Talent_Degree);
		
		//*********************Add School****************
	//	driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		Thread.sleep(1500);
//		driver.findElement(By.xpath(prop.getProperty("Education_Add"))).click();
		Thread.sleep(1500);
		js.executeScript("scroll(0,800)");
		driver.findElement(By.xpath(prop.getProperty("Education_Add_More"))).click();
		Thread.sleep(1000);
		js.executeScript("scroll(0,800)");

		Thread.sleep(1500);
		
		
		//driver.findElement(By.xpath(prop.getProperty("Education_Add"))).click();
//		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).click();
	
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).clear();
	
		driver.findElement(By.xpath(prop.getProperty("Education_Degree"))).sendKeys(Stream);
		
		
		String Talent_School_Stream = Screenshot("SNAPS\\Education\\Talent_School_Stream.png");
		extent.createTest("Talent_School_Stream ").log(Status.INFO, "Talent_School_Stream Entered")
				.addScreenCaptureFromBase64String(Talent_School_Stream);
		
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("Education_University"))).sendKeys(School);
		
		
		String Talent_School = Screenshot("SNAPS\\Education\\Talent_School.png");
		extent.createTest("Talent_School ").log(Status.INFO, "Talent_School Entered")
				.addScreenCaptureFromBase64String(Talent_School);
		
		driver.findElement(By.xpath(prop.getProperty("Education_Start_Date"))).click();
		Thread.sleep(1500);
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		driver.findElement(By.xpath(prop.getProperty("Education_Start_Date"))).sendKeys(StartDate);
		
		Thread.sleep(1500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1500);
		
		
	
		
		String Talent_School_Duration = Screenshot("SNAPS\\Education\\Talent_School_Duration.png");
		extent.createTest("Talent_School_Duration ").log(Status.INFO, "Talent_School_Duration Entered")
				.addScreenCaptureFromBase64String(Talent_School_Duration);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1500);
		
		js.executeScript("scroll(0,1200)");
		
		Thread.sleep(1500);
		
	//	driver.findElement(By.xpath(prop.getProperty("Education_Discard"))).click();
		driver.findElement(By.xpath(prop.getProperty("Education_Save"))).click();
		
		Thread.sleep(3000);
		
		String Talent_Education = Screenshot("SNAPS\\Education\\Talent_Education.png");
		
		js.executeScript("scroll(200,0)");
		js.executeScript("scroll(0,1000)");
		
		String Talent_Education_Completed = Screenshot("SNAPS\\Education\\Talent_Education_Completed.png");
		
		Thread.sleep(2000);
		
		
		extent.createTest("Talent_Education ").log(Status.PASS, "Talent_Education Saved")
				.addScreenCaptureFromBase64String(Talent_Education).addScreenCaptureFromBase64String(Talent_Education_Completed);
		
		
		Thread.sleep(3000);
		
	//	driver.findElement(By.xpath(prop.getProperty("//div[@class='circle-plus closed opened']"))).click();
		extent.flush();
		Thread.sleep(3000);
		
		try {
		//	ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	@Ignore
	@Test(priority=7 ,dataProvider="Certification", dataProviderClass=ReadXlsx_Certification.class)
	public void Certification(String Course_Name , String Issuing_Organization, String Issue_Date, String Expiration_Date
, String Credential_ID , String Credential_URL ) throws AWTException, InterruptedException, IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();

		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
			
		js.executeScript("scroll(0,1200)");

		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Certification_Add"))).click();
		js.executeScript("scroll(0,800)");
		
		driver.findElement(By.xpath(prop.getProperty("Course_Name"))).click();
		Thread.sleep(1500);
		String Course_name = Screenshot("SNAPS\\Profile\\Certification\\Talent_Course_Name.png");
		driver.findElement(By.xpath(prop.getProperty("Course_Name"))).clear();
		
		driver.findElement(By.xpath(prop.getProperty("Course_Name"))).sendKeys(Course_Name);
		
		String Talent_Course_Name_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Course_Name_Entered.png");
		extent.createTest("Talent Add Course Name").log(Status.INFO, "Course Name Entered").addScreenCaptureFromBase64String(Course_name).addScreenCaptureFromBase64String(Talent_Course_Name_Entered);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		
		driver.findElement(By.xpath(prop.getProperty("Issuing_Organization"))).click();
	
		String Talent_Issuing_Organization = Screenshot("SNAPS\\Profile\\Certification\\Talent_Issuing_Organization.png");
		driver.findElement(By.xpath(prop.getProperty("Issuing_Organization"))).sendKeys(Issuing_Organization);
	
		
		String Talent_Issuing_Organization_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Issuing_Organization_Entered.png");
		extent.createTest("Talent Issuing Organization").log(Status.INFO, "Talent Issuing Organization Entered")
		.addScreenCaptureFromBase64String(Talent_Issuing_Organization).addScreenCaptureFromBase64String(Talent_Issuing_Organization_Entered);
		
		
		driver.findElement(By.xpath(prop.getProperty("Certification_Issue_Date"))).click();
		Thread.sleep(1500);
		
		String Talent_Certification_Issue_Date = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Issue_Date.png");
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		
		
			
		driver.findElement(By.xpath(prop.getProperty("Certification_Issue_Date"))).sendKeys(Issue_Date);
		
		
		String Talent_Certification_Issue_Date_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Issue_Date_Entered.png");
		extent.createTest("Talent Certification Issue Date").log(Status.INFO, "Talent Certification Issue Date Entered")
		.addScreenCaptureFromBase64String(Talent_Certification_Issue_Date).addScreenCaptureFromBase64String(Talent_Certification_Issue_Date_Entered);
		
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Certification_Expiration_Date"))).click();
		
		String Talent_Certification_Expiry_Date = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Expiry_Date_Entered.png");
		
		
		
		
		
		for(int i=0 ; i<=7 ; i++) {
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			}
		driver.findElement(By.xpath(prop.getProperty("Certification_Expiration_Date"))).sendKeys(Expiration_Date);
	
		
		String Talent_Certification_Expiry_Date_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Expiry_Date_Entered1.png");
		extent.createTest("Talent Certification Expiry Date").log(Status.INFO, "Talent Certification Expiry Date Entered")
		.addScreenCaptureFromBase64String(Talent_Certification_Expiry_Date).addScreenCaptureFromBase64String(Talent_Certification_Expiry_Date_Entered);
		
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String Talent_Certification_Credential_ID = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Credential_ID.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("Certification_Credential_ID"))).clear();
		
		
		driver.findElement(By.xpath(prop.getProperty("Certification_Credential_ID"))).sendKeys(Credential_ID);
		
		
		String Talent_Certification_Credential_ID_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Credential_ID_Entered.png");
		extent.createTest("Talent Credential ID").log(Status.INFO, "Talent Credential ID Entered")
		.addScreenCaptureFromBase64String(Talent_Certification_Credential_ID).addScreenCaptureFromBase64String(Talent_Certification_Credential_ID_Entered);
		
	
		driver.findElement(By.xpath(prop.getProperty("Certification_Credential_URL"))).clear();
		String Talent_Certification_Credential_URL = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Credential_URL.png");
		driver.findElement(By.xpath(prop.getProperty("Certification_Credential_URL"))).sendKeys(Credential_URL);
		
		
		String Talent_Certification_Credential_URL_Entered = Screenshot("SNAPS\\Profile\\Certification\\Talent_Certification_Credential_URL_Entered.png");
		extent.createTest("Talent Credential URL").log(Status.PASS, "Talent Credential URL Entered")
		.addScreenCaptureFromBase64String(Talent_Certification_Credential_URL).addScreenCaptureFromBase64String(Talent_Certification_Credential_URL_Entered);
		
		Thread.sleep(1000);
		js.executeScript("scroll(0,1200)");
			
		driver.findElement(By.xpath(prop.getProperty("Certification_Save"))).click();
		
		Thread.sleep(1500);
		js.executeScript("scroll(0,1400)");
		
		
		
		extent.flush();

		try {
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	@Test(priority=8 ,dataProvider="Testimonial", dataProviderClass=ReadXlsx_Testimonials.class)
	public void Testimonials(String Client_Name , String Company_Name , String Testimonial) throws AWTException, InterruptedException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();

		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		Thread.sleep(1000);
	//	js.executeScript("scroll(0,2400)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Testimonials_Add"))).click();
		Thread.sleep(1000);
	//	js.executeScript("scroll(0,1200)");
		Thread.sleep(1500);

		String Talent_Client_Name = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Client_Name.png");
	
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Client_Name"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Client_Name"))).sendKeys(Client_Name);
		Thread.sleep(1500);
		String Talent_Client_Name_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Client_Name_Entered.png");
		extent.createTest("Talent Client Name").log(Status.INFO, "Talent Client Name Entered")
		.addScreenCaptureFromBase64String(Talent_Client_Name).addScreenCaptureFromBase64String(Talent_Client_Name_Entered);		
		
		
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Company_Name"))).click();
		
		
		
		
		
		String Talent_Company_Name = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Company_Name.png");
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Company_Name"))).sendKeys(Company_Name);
	
		String Talent_Company_Name_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Company_Name_Entered.png");
		extent.createTest("Talent Company Name").log(Status.INFO, "Talent Company Name Entered")
		.addScreenCaptureFromBase64String(Talent_Company_Name).addScreenCaptureFromBase64String(Talent_Company_Name_Entered);
		
		js.executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Description"))).click();
		
		String Talent_Testimonial = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Testimonial.png");
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Description"))).sendKeys(Testimonial);
		
		
		js.executeScript("scroll(0,2400)");
		
		
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		driver.findElement(By.xpath(prop.getProperty("Bold"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Italic"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Underlined"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Bullet"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Number"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Undo"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Redo"))).click();
		Thread.sleep(1000);
		
		
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(1500);
		String Talent_Testimonial_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Testimonial_Entered.png");
		
		extent.createTest("Talent Testimonial")
		.log(Status.INFO, "Talent Testimonial Entered").addScreenCaptureFromBase64String(Talent_Testimonial)
		.addScreenCaptureFromBase64String(Talent_Testimonial_Entered);
		
		
		driver.findElement(By.xpath(prop.getProperty("Testimonial_Save"))).click();
		Thread.sleep(1500);
		js.executeScript("scroll(0,1400)");
		Thread.sleep(1500);
		
		String Talent_Testimonial_Completed = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Testimonial\\Talent_Testimonial_Completed.png");
		
		extent.createTest("Talent Testimonial Completed").log(Status.PASS, "Talent Testimonial Completed").addScreenCaptureFromBase64String(Talent_Testimonial_Completed);
	
		Thread.sleep(1500);
		
		
		extent.flush();
		
		try {
//				ScreenRecorderUtil.stopRecord();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	

	
	
}
