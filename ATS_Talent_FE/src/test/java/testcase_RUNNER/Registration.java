package testcase_RUNNER;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import support_Files.ScreenRecorderUtil;
import utilities_ATS_Registration.ReadXlsx_Registration;

public class Registration extends Runner {

	
	@Test(dataProvider="Registration" , dataProviderClass=ReadXlsx_Registration.class)
	public void Talent_Registration(String Full_Name, String Email, String Phone_No, String Password,
			String confirm_Password , String LinkedIn_Profile ,String Postion_Applied , String Work_Experience ,String Current_Pay , String Expected_Pay,
			String Method_Of_Working_Preference1, String Method_Of_Working_Preference2 , String Method_Of_Working_Preference3
			,String US_Shift, String US_Partial_Shift, String UK_Shift, String IST_Full_Shift, String AU_Full_Shift, String AU_Partial_Shift
, String skills1 ,String Resume) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		Robot r = new Robot();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		
		String Registration_page = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Registration_page.png");
		driver.findElement(By.xpath(prop.getProperty("Get_Hired"))).click();
		
		extent.createTest("Talent Registration")
		.log(Status.INFO, "Talent in Registration page")
		.addScreenCaptureFromBase64String(Registration_page);
		
		String Talent_FullName = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_FullName.png");
		driver.findElement(By.xpath(prop.getProperty("Full_Name"))).click();
		driver.findElement(By.xpath(prop.getProperty("Full_Name"))).sendKeys(Full_Name);
		String Talent_FullName_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_FullName_Entered.png");
		
		extent.createTest("Talent Full Name")
		.log(Status.INFO, "Talent Full Name Entered")
		.addScreenCaptureFromBase64String(Talent_FullName)
		.addScreenCaptureFromBase64String(Talent_FullName_Entered);
		
		String Talent_Email = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Email.png");
		driver.findElement(By.xpath(prop.getProperty("Registration_Email"))).click();
		driver.findElement(By.xpath(prop.getProperty("Registration_Email"))).sendKeys(Email);
		String Talent_Email_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Email_Entered.png");
		extent.createTest("Talent Email")
		.log(Status.INFO, "Talent Email Entered")
		.addScreenCaptureFromBase64String(Talent_Email)
		.addScreenCaptureFromBase64String(Talent_Email_Entered);
		
		String Talent_PhoneNo = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_PhoneNo.png");
		driver.findElement(By.xpath(prop.getProperty("Registration_Phone_No"))).click();
		driver.findElement(By.xpath(prop.getProperty("Registration_Phone_No"))).sendKeys(Phone_No);
		String Talent_PhoneNo_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_PhoneNo_Entered.png");
		extent.createTest("Talent Phone_Number")
		.log(Status.INFO, "Talent Phone Number Entered")
		.addScreenCaptureFromBase64String(Talent_PhoneNo)
		.addScreenCaptureFromBase64String(Talent_PhoneNo_Entered);
		
		String Talent_Password = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Password.png");
		driver.findElement(By.xpath(prop.getProperty("Registration_password"))).click();
		driver.findElement(By.xpath(prop.getProperty("Registration_password"))).sendKeys(Password);
		String Talent_Password_Entered = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Password_Entered.png");
		
		String Talent_Confirm_Password = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Confirm_Password.png");
		driver.findElement(By.xpath(prop.getProperty("Registration_confirm_Password"))).click();
		driver.findElement(By.xpath(prop.getProperty("Registration_confirm_Password"))).sendKeys(confirm_Password);
		String Talent_Confirm_Password_Entered= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Confirm_Password_Entered.png");
		
		extent.createTest("Talent Enter Password")
		.log(Status.INFO, "Talent Password Entered")
		.addScreenCaptureFromBase64String(Talent_Password)
		.addScreenCaptureFromBase64String(Talent_Password_Entered)
		.addScreenCaptureFromBase64String(Talent_Confirm_Password)
		.addScreenCaptureFromBase64String(Talent_Confirm_Password_Entered);
		
		
		Thread.sleep(3000);
		WebElement create_Account = driver.findElement(By.xpath(prop.getProperty("Registration_create_Account")));
		js.executeScript("arguments[0].click()",create_Account);
		
		Thread.sleep(50000);
		System.out.println("Title of the Page : " + driver.getTitle());
		
		driver.findElement(By.xpath(prop.getProperty("Registration_LinkedIn"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Registration_LinkedIn"))).sendKeys(LinkedIn_Profile);
		
		String Talent_LinkedIn_Entered= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_LinkedIn_Entered.png");
		Thread.sleep(1500);
		
		extent.createTest("Talent LinkedIn")
		.log(Status.INFO, "Talent LinkedIn Entered ")
		.addScreenCaptureFromBase64String(Talent_LinkedIn_Entered);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Employee_Status"))).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Un_Employed"))).click();
		Thread.sleep(1500);
		
		String Talent_Enter_UnEmployed= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Enter_UnEmployed.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Employee_Status"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_On_Contract"))).click();
		Thread.sleep(1500);
		String Talent_Enter_On_Contract= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Enter_On_Contract.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Employee_Status"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Full_Time_FreeLancing"))).click();
		Thread.sleep(1500);
		String Talent_Enter_Full_Time_FreeLancing= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Enter_Full_Time_FreeLancing.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Employee_Status"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Full_Time_Employee"))).click();
		Thread.sleep(1500);
		String Talent_Enter_Full_Time_Employee= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Enter_Full_Time_Employee.png");
		Thread.sleep(1500);
		
		extent.createTest("Talent Employee Status")
		.log(Status.INFO, "Talent Entered Employee Status ")
		.addScreenCaptureFromBase64String(Talent_Enter_UnEmployed)
		.addScreenCaptureFromBase64String(Talent_Enter_On_Contract)
		.addScreenCaptureFromBase64String(Talent_Enter_Full_Time_FreeLancing)
		.addScreenCaptureFromBase64String(Talent_Enter_Full_Time_Employee);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Position_Applied"))).click();
		Thread.sleep(1500);
		
		List<WebElement> Position_Applied_Options = driver.findElements(By.xpath(prop.getProperty("Registration_Position_Applied_Options")));
		
		for (WebElement w : Position_Applied_Options) {
			if (w.getText().equalsIgnoreCase(Postion_Applied)) {
				w.click();
				break;
			}
		}
		
		Thread.sleep(1500);
		String Talent_Position_Applied= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Position_Applied.png");
		
		extent.createTest("Position Applied")
		.log(Status.INFO, "Talent Enter Position Applied")
		.addScreenCaptureFromBase64String(Talent_Position_Applied);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Work_Experience"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Work_Experience"))).sendKeys(Work_Experience);
		Thread.sleep(1500);
		String Talent_Work_Experience= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Work_Experience.png");
		
		extent.createTest("Work Experience")
		.log(Status.INFO, "Talent Enter Work Experience")
		.addScreenCaptureFromBase64String(Talent_Work_Experience);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period_Morethan8Weeks"))).click();
		Thread.sleep(1500);
		String Talent_Morethan8Weeks= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Morethan8Weeks.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period_4to8Weeks"))).click();
		Thread.sleep(1500);
		String Talent_4to8Weeks= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_4to8Weeks.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period_2To4Weeks"))).click();
		Thread.sleep(1500);
		String Talent_2To4Weeks= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_2To4Weeks.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period_within2Weeks"))).click();
		Thread.sleep(1500);
		String Talent_Notice_Period_within2Weeks= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Notice_Period_within2Weeks.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Notice_Period_Immediately"))).click();
		Thread.sleep(1500);
		String Talent_Notice_Period_Immediately= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Notice_Period_Immediately.png");
		Thread.sleep(1500);
		
		extent.createTest("Notice Period").log(Status.INFO, "Talent Choosed Notice Period")
		.addScreenCaptureFromBase64String(Talent_Morethan8Weeks)
		.addScreenCaptureFromBase64String(Talent_4to8Weeks)
		.addScreenCaptureFromBase64String(Talent_2To4Weeks)
		.addScreenCaptureFromBase64String(Talent_Notice_Period_within2Weeks)
		.addScreenCaptureFromBase64String(Talent_Notice_Period_Immediately);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Current_Pay"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Current_Pay"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Registration_Current_Pay"))).sendKeys(Current_Pay);
		Thread.sleep(1500);
		String Talent_Current_Pay= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Current_Pay.png");
		Thread.sleep(1500);
		extent.createTest("Current Pay")
		.log(Status.INFO, "Talent Current Pay Entered")
		.addScreenCaptureFromBase64String(Talent_Current_Pay);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Expected_Pay"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Expected_Pay"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Registration_Expected_Pay"))).sendKeys(Expected_Pay);
		Thread.sleep(1500);
		String Talent_Expected_Pay= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Expected_Pay.png");
		
		extent.createTest("Expected Pay ")
		.log(Status.INFO, "Talent Expected Pay Entered")
		.addScreenCaptureFromBase64String(Talent_Expected_Pay);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Method_Of_Working1"))).click();
		Thread.sleep(5000);
		
		
		List<WebElement> preference_Options = driver.findElements(By.xpath(prop.getProperty("Registration_Method_Of_Working_Preference_Options")));
		
		for (WebElement w : preference_Options) {
		
			if(w.getText().equalsIgnoreCase(Method_Of_Working_Preference1)) {
				w.click();
				break;
			}
			
		}
		
		Thread.sleep(1500);
		String Talent_Method_Of_Working_Preference1= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Method_Of_Working_Preference1.png");
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Method_Of_Working2"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div[.='In-Office']")).click();
		Thread.sleep(1500);
		String Talent_Method_Of_Working2= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Registration_Method_Of_Working2.png");
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Method_Of_Working3"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div[.='Remote']")).click();
		Thread.sleep(1500);
		String Talent_Registration_Method_Of_Working3= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Registration_Method_Of_Working3.png");
		Thread.sleep(1000);
		
		extent.createTest("Method of Working").log(Status.INFO, "Talent Method of Working Entered")
		.addScreenCaptureFromBase64String(Talent_Method_Of_Working_Preference1)
		.addScreenCaptureFromBase64String(Talent_Method_Of_Working2)
		.addScreenCaptureFromBase64String(Talent_Registration_Method_Of_Working3);
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Registration_Working_Hours1"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div[.='UK Shift 2:00 PM to 11:00 PM']")).click();
		String Talent_Registration_Working_Hours1= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_LinkedIn_Entered.png");
		
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Working_Hours2"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div[.='US Full Shift (8:00 PM To 5:00 AM / 9:00 PM To 6:00 AM)']")).click();
		Thread.sleep(1500);
		String TalentRegistration_Working_Hours2= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\TalentRegistration_Working_Hours2.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Working_Hours3"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@class='react-select__menu-list css-11unzgr']/div[.='AU Full Shift 4:00 AM To 1:00 PM']")).click();
		Thread.sleep(1500);
		String Talent_Registration_Working_Hours3= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Registration_Working_Hours3.png");
		
		extent.createTest("Working Hours").log(Status.INFO, "Talent Choose Working Hours")
		.addScreenCaptureFromBase64String(Talent_Registration_Working_Hours1)
		.addScreenCaptureFromBase64String(TalentRegistration_Working_Hours2)
		.addScreenCaptureFromBase64String(Talent_Registration_Working_Hours3);
		
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Skills"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Registration_Skills_Input"))).sendKeys(skills1);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		
		
		
	//	driver.findElement(By.xpath(prop.getProperty("Registration_Upload_Resume"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Registration_Resume_File"))).sendKeys(Resume);
		Thread.sleep(4000);
		String Talent_Registration_Resume= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Registration_Resume.png");
		
		extent.createTest("Resume").log(Status.INFO, "Resume Upload")
		.addScreenCaptureFromBase64String(Talent_Registration_Resume);
		Thread.sleep(1500);
		
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_TAB);
//		
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("Registration_Submit"))).click();
		Thread.sleep(5000);
		
		String Talent_Registration_Successful= Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\Registration\\Talent_Registration_Successful.png");
		
		extent.createTest("Registration Completed").log(Status.PASS,"Talent Successfully completed Registration")
		.addScreenCaptureFromBase64String(Talent_Registration_Successful);
		
		extent.flush();
		Thread.sleep(4000);
		
		ScreenRecorderUtil.stopRecord();
	}
	
}




//try {
//
//driver.findElement(By.xpath(prop.getProperty("Registration_Method_Of_Working2"))).click();
//List<WebElement> preference_Options2 = driver.findElements(By.xpath(prop.getProperty("Registration_Method_Of_Working_Preference_Options")));
//
//Thread.sleep(3000);
//
//
//	for (WebElement w: preference_Options2) {
//		
//		if(w.getText().equalsIgnoreCase(Method_Of_Working_Preference2)) {
//			w.click();
//			break;
//		}
//		
//	}
//} catch (StaleElementReferenceException e) {
//
//	List<WebElement> preference_Options2 = driver.findElements(By.xpath(prop.getProperty("Registration_Method_Of_Working_Preference_Options")));
//	
//	Thread.sleep(3000);
//	
//
//		for (WebElement w: preference_Options2) {
//			
//			if(w.getText().equalsIgnoreCase(Method_Of_Working_Preference2)) {
//				w.click();
//				break;
//			}
//			
//		}
//	
//}




//for (WebElement w : Working_Hours_Options) {
//	if(w.getText().equalsIgnoreCase(IST_Full_Shift)) {
//		w.click();
//		break;
//	}
//}



