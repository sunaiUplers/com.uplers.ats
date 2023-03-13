package testcase_RUNNER;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import support_Files.ScreenRecorderUtil;
import utilities_ATS.Assessment.ReadXlsx_Assessment;



public class Assessments extends Runner{

	
	public static URL url;
	
	
	@Test(priority=1 , dataProvider= "Assessment" , dataProviderClass=ReadXlsx_Assessment.class)
	public void Assessment(String Assessment_1) throws InterruptedException, AWTException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment"))).click();
		Thread.sleep(2000);
		String React_Assessment = Screenshot("SNAPS\\Assessments\\React_Assessment.png");
		js.executeScript("scroll(0,1200)");
		
		Thread.sleep(1500);
		
	//	driver.findElement(By.xpath(prop.getProperty("Assessment_React"))).click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
//		alert.accept();
		Thread.sleep(2000);
		js.executeScript("scroll(200,0)");
		driver.findElement(By.xpath(prop.getProperty("Assessment_Edit"))).click();
		Thread.sleep(1500);
		String Talent_Edit_Assesment = Screenshot("SNAPS\\Assessments\\Talent_Edit_Assesment.png");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Update"))).click();
		driver.findElement(By.xpath(prop.getProperty("Assessment_Update"))).sendKeys(Assessment_1);
		Thread.sleep(1500);
		String Talent_Add_React_Assessment = Screenshot("SNAPS\\Assessments\\Talent_Add_React_Assessment.png");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Save"))).click();
		Thread.sleep(3000);
		
		Object close = js.executeScript("return document.querySelector(\"body > div:nth-child(9) > div > div > div > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button\")");
		js.executeScript("arguments[0].click()", close);
		
		Thread.sleep(3000);
		
		js.executeScript("scroll(0,2400)");
		
		Thread.sleep(1500);
		js.executeScript("scroll(0,2400)");
		
		String Talent_Start_React_Assessment = Screenshot("SNAPS\\Assessments\\Talent_Start_React_Assessment.png");
		
		extent.createTest("Talent Atten React Assessment").log(Status.INFO,"Talent in Assessment page")
		.addScreenCaptureFromBase64String(React_Assessment).addScreenCaptureFromBase64String(Talent_Edit_Assesment)
		.addScreenCaptureFromBase64String(Talent_Add_React_Assessment).addScreenCaptureFromBase64String(Talent_Start_React_Assessment);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Python"))).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String string = list.get(0);
		driver.switchTo().window(string);
		
		
		Thread.sleep(4000);
		System.out.println("Title : " + driver.getTitle());	
		System.out.println(" ");
	
	
	
	Thread.sleep(3000);
	js.executeScript("scroll(0,2400)");
	driver.findElement(By.xpath(prop.getProperty("Assessment_Enable_Mode"))).click();
	
	Thread.sleep(1000);
	
	String React_Enable_mode = Screenshot("SNAPS\\Assessments\\React_Enable_mode.png");
	Thread.sleep(1000);
	js.executeScript("scroll(0,2400)");
	driver.findElement(By.xpath(prop.getProperty("Assessment_Enable_Mode_Off"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(prop.getProperty("Assessment_Terms_Service"))).click();
	Thread.sleep(1000);
	String React_Terms_Service = Screenshot("SNAPS\\Assessments\\React_Terms_Service.png");
	
	driver.findElement(By.xpath(prop.getProperty("Assessment_Code_Honour"))).click();
	Thread.sleep(1000);
	String React_Code_Honour = Screenshot("SNAPS\\Assessments\\React_Code_Honour.png");
	
	extent.createTest("Talent accepts Terms & Conditions")
	.log(Status.INFO, "Check Box is Selected").addScreenCaptureFromBase64String(React_Enable_mode)
	.addScreenCaptureFromBase64String(React_Terms_Service).addScreenCaptureFromBase64String(React_Code_Honour);
	
	Thread.sleep(2000);
	driver.findElement(By.xpath(prop.getProperty("Assessment_Start_Test"))).click();
	
	Thread.sleep(2000);
	
	
	
	//****************************************Assessment_Test_Codility************************************
	
	
	String React_Codility_Test = Screenshot("SNAPS\\Assessments\\React_Codility_Test.png");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option1"))).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option3"))).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option2"))).click();
	Thread.sleep(2000);
	
	String Assesment_React_Test_Option2 = Screenshot("SNAPS\\Assessments\\Assesment_React_Test_Option2.png");
	
	Thread.sleep(2000);
	WebElement settings = driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Settings")));
//	Object executeScript = js.executeScript("return document.querySelector(\"#open_settings_btn > div > svg\")");
	settings.click();
//	js.executeScript("arguments[0].onclick()",settings);
	Thread.sleep(1500);
	
	Object Dark_mode = js.executeScript(prop.getProperty("Assessment_Codility_Darkmode"));
	js.executeScript("arguments[0].onclick()", Dark_mode);
	Thread.sleep(1500);
	Thread.sleep(20000);
	
	driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Submit_Task"))).click();
	Thread.sleep(2000);
	
	String React_Codility_Submit_Task = Screenshot("SNAPS\\Assessments\\React_Codility_Submit_Task.png");
	
	Object submit_Test = js.executeScript("return document.querySelector(\"body > div:nth-child(7) > div > div > div.ModalWindow__Body-sc-1blkd9p-2.fDMumk > div.Box__Wrapper-sc-6lvy0r-0.eYxdWs > button.Button__ButtonWrapper-sc-hbh4t9-0.llpkaq.has-min-width\")");
	js.executeScript("arguments[0].click()", submit_Test);
	Thread.sleep(4000);
	
	String Assessment_Codility_Skip = Screenshot("SNAPS\\Assessments\\Assessment_Codility_Skip.png");
	driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Skip"))).click();
	Thread.sleep(1500);
	
	String Assessment_Codility_Continue = Screenshot("SNAPS\\Assessments\\Assessment_Codility_Continue.png");
	driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Continue"))).click();
	Thread.sleep(3000);
	
	String Assessment_Codility_Result = Screenshot("SNAPS\\Assessments\\Assessment_Codility_Result.png");
	
	extent.createTest("Talent Completed React Assessment")
	.log(Status.PASS, "Assessment Result").addScreenCaptureFromBase64String(React_Codility_Test)
	.addScreenCaptureFromBase64String(Assesment_React_Test_Option2).addScreenCaptureFromBase64String(React_Codility_Submit_Task)
	.addScreenCaptureFromBase64String(Assessment_Codility_Skip).addScreenCaptureFromBase64String(Assessment_Codility_Continue)
	.addScreenCaptureFromBase64String(Assessment_Codility_Result);
	
	Thread.sleep(1500);
	extent.flush();
	Thread.sleep(5000);
	
	try {
		ScreenRecorderUtil.stopRecord();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	Thread.sleep(3000);
	
	
	}
	
		
}
