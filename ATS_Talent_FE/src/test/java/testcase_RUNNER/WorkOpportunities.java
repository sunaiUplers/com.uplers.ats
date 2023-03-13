package testcase_RUNNER;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import support_Files.ScreenRecorderUtil;
import utilites_ATS_WorkOpportunities.ReadXlsx_ALLOpportunities;

public class WorkOpportunities extends Runner {

	@Ignore
	@Test(dataProvider = "AllOpportunities", dataProviderClass = ReadXlsx_ALLOpportunities.class)
	public void All_Opportunities(String SearchOpportunities, String AddFilter_Role_Search, String Experience,
			String Skills1, String Skills2, String Skills3, String Pay_Range_From, String Pay_Range_To)
			throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();

		driver.findElement(By.xpath(prop.getProperty("WorkOpportunities"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites"))).click();

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites")))
				.sendKeys(SearchOpportunities);
		Thread.sleep(1500);
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(1500);
		js.executeScript("window.scroll(0,600)");
		Thread.sleep(1500);
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(1500);
		js.executeScript("window.scroll(1200,0)");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites"))).click();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SortBy"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_Newest"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SortBy"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_Relevance"))).click();
		Thread.sleep(3000);

		// js.executeScript("window.scroll(0,1200)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter"))).click();

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Role"))).click();

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Role_Search"))).click();

		Thread.sleep(2000);

		List<WebElement> roleoptions = driver
				.findElements(By.xpath("//button[@id='addFiltersRole']/following-sibling::form/ul/li/label"));

		for (WebElement role : roleoptions) {
			if (role.getText().equalsIgnoreCase(AddFilter_Role_Search)) {
				Thread.sleep(1000);
				role.click();
				Thread.sleep(3000);

				String Talent_Role = Screenshot(
						"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Role.png");

				driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Role_ApplyFilter"))).click();

				extent.createTest("Talent Role").log(Status.INFO, "Role Selected")
						.addScreenCaptureFromBase64String(Talent_Role);

				break;
			}
		}

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience"))).click();
		Thread.sleep(3000);

		String Talent_Experience = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Experience.png");

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_0_2Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_2_4Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_4_6Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_6_8Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_8_10Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_10_12Years"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_12_14Years"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_Search"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_Search")))
				.sendKeys(Experience);
		Thread.sleep(1000);

		List<WebElement> ExperienceSearchOptions = driver
				.findElements(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_Search_Options")));
		for (WebElement SearchOptions : ExperienceSearchOptions) {
			if (SearchOptions.getText().equalsIgnoreCase(Experience)) {
				Thread.sleep(1500);
				SearchOptions.click();
			}
		}

		Thread.sleep(2000);
		String Talent_Experience_Selected = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Experience_Selected.png");

		extent.createTest("Talent Experience").log(Status.INFO, "Experience Selected")
				.addScreenCaptureFromBase64String(Talent_Experience)
				.addScreenCaptureFromBase64String(Talent_Experience_Selected);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Experience_ApplyFilter"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search"))).sendKeys(Skills1);
		Thread.sleep(1000);

		List<WebElement> text = driver
				.findElements(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search_Options")));

		for (WebElement skill1 : text) {
			if (skill1.getText().equalsIgnoreCase(Skills1)) {
				Thread.sleep(2000);
				skill1.click();
				Thread.sleep(2500);
				// String Talent_Skills1 =
				// Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Skills1.png");

				driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_ApplyFilter"))).click();
				break;
			}

		}

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search"))).clear();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search"))).sendKeys(Skills2);

		Thread.sleep(3000);

		List<WebElement> text2 = driver
				.findElements(By.xpath("//button[@id='addFiltersExperience']/following::ul[3]/li/label"));

		for (WebElement skill2 : text2) {
			if (skill2.getText().equalsIgnoreCase(Skills2)) {
				Thread.sleep(2000);
				skill2.click();
				Thread.sleep(2500);

				// String Talent_Skills2 =
				// Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Skills2.png");

				driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_ApplyFilter"))).click();
				Thread.sleep(3000);
				break;
			}
		}

		Thread.sleep(2000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search"))).clear();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_Search"))).sendKeys(Skills3);

		js.executeScript("window.scroll(0,500)");
		Thread.sleep(2000);

		List<WebElement> text3 = driver
				.findElements(By.xpath("//button[@id='addFiltersExperience']/following::ul[3]/li/label"));

		for (WebElement skill3 : text3) {
			if (skill3.getText().equalsIgnoreCase(Skills3)) {
				Thread.sleep(3000);
				skill3.click();
				Thread.sleep(2500);
				// String Talent_Skills3 =
				// Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Skills3.png");

				driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_ApplyFilter"))).click();

				break;
			}
		}

		String Talent_Skills_Selected = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Skills_Selected.png");

		extent.createTest("Talent Skills").log(Status.INFO, "Skills Selected")
				.addScreenCaptureFromBase64String(Talent_Skills_Selected);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Skills_ApplyFilter"))).click();

		System.out.println(text);
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings"))).click();
		Thread.sleep(1000);

		String Talent_ShiftTimings = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_ShiftTimings.png");

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_US_FullShift"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_US_PartialShift")))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_UK_Shift"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_IST_FullShift"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_AU_FullShift"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_AU_PartialShift")))
				.click();
		Thread.sleep(1000);

		String Talent_ShiftTimings_Selected = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_ShiftTimings_Selected.png");

		extent.createTest("Talent ShiftTimings").log(Status.INFO, "Shift Timings Selected")
				.addScreenCaptureFromBase64String(Talent_ShiftTimings)
				.addScreenCaptureFromBase64String(Talent_ShiftTimings_Selected);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_ShiftTimings_ApplyFilter"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange"))).click();
		Thread.sleep(1000);

		String Talent_PayRange = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_PayRange.png");

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_1000_2000"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_2000_3000"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_3000_4000"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_4000_5000"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_From")))
				.sendKeys(Pay_Range_From);
		Thread.sleep(1000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_To"))).sendKeys(Pay_Range_To);
		Thread.sleep(1000);

		String Talent_PayRange_Entered = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_PayRange_Entered.png");

		extent.createTest("Talent PayRange").log(Status.INFO, "Pay Range Selected")
				.addScreenCaptureFromBase64String(Talent_PayRange)
				.addScreenCaptureFromBase64String(Talent_PayRange_Entered);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_PayRange_ApplyFilter"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Tenure"))).click();
		Thread.sleep(1000);

		String Talent_Tenure = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Tenure.png");

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Tenure_0_To_6Months"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Tenure_6_To_12Months"))).click();
		Thread.sleep(1000);

		String Talent_Tenure_Selected = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Tenure_Selected.png");

		extent.createTest("Talent Tenure").log(Status.INFO, "Tenure Selected")
				.addScreenCaptureFromBase64String(Talent_Tenure)
				.addScreenCaptureFromBase64String(Talent_Tenure_Selected);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Tenure_ApplyFilter"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Availability"))).click();
		Thread.sleep(1000);

		String Talent_Availability = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Availability.png");

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Availability_FullTime"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Availability_PartTime"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Availability_ProjectToProject")))
				.click();
		Thread.sleep(1000);

		String Talent_Availability_Selected = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Talent_Availability_Selected.png");

		extent.createTest("Talent Availability").log(Status.INFO, "Availability Selected")
				.addScreenCaptureFromBase64String(Talent_Availability)
				.addScreenCaptureFromBase64String(Talent_Availability_Selected);

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter_Availability_ApplyFilter"))).click();
		Thread.sleep(3000);

		js.executeScript("window.scroll(400,0)");
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_AddFilter"))).click();
		Thread.sleep(3000);

		String Filters = Screenshot(
				"C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\AddFilter\\Filters.png");

		extent.createTest("Opportunities").log(Status.PASS, "Opportunities Added")
				.addScreenCaptureFromBase64String(Filters);

	//	extent.flush();
		Thread.sleep(3000);
		
	//	ScreenRecorderUtil.stopRecord();

	}
	

	@Test
	public void All_Opportunities_Position_FrontEnd() throws InterruptedException, IOException {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		driver.findElement(By.xpath(prop.getProperty("WorkOpportunities"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites"))).click();
		
		Thread.sleep(1500);
		String Position = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Position.png");
		
		
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites")))
				.sendKeys("wordpress");
		Thread.sleep(6000);
			
		String Position_Search = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Position_Search.png");
		
		extent.createTest("Position Search")
		.log(Status.INFO, "Front End")
		.addScreenCaptureFromBase64String(Position)
		.addScreenCaptureFromBase64String(Position_Search);
		
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(1500);
		
		Thread.sleep(2000);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[.='USD 540 / month']//following::button[.='View More Details']")).click();
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(1500);
		driver.findElement(By.xpath("//li[.='USD 540 / month']//following::button[.='View Less']")).click();
		
		Thread.sleep(2000);
		String Test_Info = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Test_Info.png");
		
		
		
		driver.findElement(By.xpath("(//div[@class='opportunitiesTestBox ']/button[@class='boxInfoBtn'])[4]")).click();
		Thread.sleep(2000);
		
		String React_Test_Info = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\React_Test_Info.png");
		
		extent.createTest("Test Info")
		.log(Status.INFO, "Test Info Displayed")
		.addScreenCaptureFromBase64String(Test_Info)
		.addScreenCaptureFromBase64String(React_Test_Info);
		
		
		driver.findElement(By.xpath("//button[@class='modalCloseBtn']")).click();
		Thread.sleep(2000);
		
		String React_Test = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\React_Test.png");
		
		
		driver.findElement(By.xpath(
				"(//div[@class='opportunitiesTestWrap']//li//h4[.='Take the test'])[4]"))
				.click();
		Thread.sleep(2000);
		
		String React_Take_Test = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\React_Take_Test.png");
		
		
		driver.findElement(By.xpath("//button[.='Take the test']")).click();
		Thread.sleep(15000);
		
		
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(1500);

		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//button[@class='modalCloseBtn']")).click();
		Thread.sleep(1500);
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			System.out.println("window" + window);
			if (!window.equals(parent)) {
				Thread.sleep(3000);
				driver.switchTo().window(window);

			}

		}

		
	

		String React_Test_Page = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\React_Test_Page.png");
		
		extent.createTest("Talent Take the Test ")
		.log(Status.INFO, "Talent React Test")
		.addScreenCaptureFromBase64String(React_Test)
		.addScreenCaptureFromBase64String(React_Take_Test)
		.addScreenCaptureFromBase64String(React_Test_Page);
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Terms_Service"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Code_Honour"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Start_Test"))).click();
		Thread.sleep(1500);
		
		
		String Talent_Assessment = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Talent_Assessment.png");
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option1"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option3"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option2"))).click();
		
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Submit_Task"))).click();
		Thread.sleep(2000);
		
		
		Object submit_Test = js.executeScript("return document.querySelector(\"body > div:nth-child(7) > div > div > div.ModalWindow__Body-sc-1blkd9p-2.fDMumk > div.Box__Wrapper-sc-6lvy0r-0.eYxdWs > button.Button__ButtonWrapper-sc-hbh4t9-0.llpkaq.has-min-width\")");
		js.executeScript("arguments[0].click()", submit_Test);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Skip"))).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Continue"))).click();
		Thread.sleep(3000);
		
		
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(50000);
		driver.navigate().refresh();
		Thread.sleep(75000);
		driver.navigate().refresh();
		Thread.sleep(1500);
		
		String Talent_Assessment_Complete = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Talent_Assessment_Complete.png");
		
		driver.findElement(By.xpath(prop.getProperty("WorkOpportunities"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites"))).click();
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites")))
		.sendKeys("Front End");
		Thread.sleep(4000);
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(2000);
		String Talent_Assessment_Complete2 = Screenshot("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\SNAPS\\WorkOpportunities\\Position_Search\\Talent_Assessment_Complete2.png");
		
		extent.createTest("Talent Assessment")
		.log(Status.INFO, "Assessment Successfully finished")
		.addScreenCaptureFromBase64String(Talent_Assessment)
		.addScreenCaptureFromBase64String(Talent_Assessment_Complete)
		.addScreenCaptureFromBase64String(Talent_Assessment_Complete2);
		Thread.sleep(2000);
		extent.flush();
		
		
		try {
			ScreenRecorderUtil.stopRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Ignore
	@Test
	private void wordPressFullStackDeveloper() throws AWTException, InterruptedException {
		
		System.out.println("test");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Robot r = new Robot();
		Actions a = new Actions(driver);

		driver.findElement(By.xpath(prop.getProperty("WorkOpportunities"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites"))).click();

		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites")))
				.sendKeys("wordpress");  //Front End
		Thread.sleep(1000);
		
/*		WebElement oppor = driver.findElement(By.xpath("//div[@id='HR060223154245']/child::div[2]/div/ul/li/div/div/div/h4"));
		a.moveToElement(oppor).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='HR060223154245']/child::div[2]/div/ul/li/div/div/div/h4")).click();
		
		
		
		
		driver.findElement(By.xpath("//button[.='Take the test']")).click();
		Thread.sleep(15000);
		
		
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(1500);

		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//button[@class='modalCloseBtn']")).click();
		Thread.sleep(1500);
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			System.out.println("window" + window);
			if (!window.equals(parent)) {
				Thread.sleep(3000);
				driver.switchTo().window(window);

			}

		}

		
	
	
		
		
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Terms_Service"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Code_Honour"))).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("Assessment_Start_Test"))).click();
		Thread.sleep(1500);
		
		
		
		
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option1"))).click();
		
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option3"))).click();
		
		
		driver.findElement(By.xpath(prop.getProperty("Assesment_Test_Option2"))).click();
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Submit_Task"))).click();
		Thread.sleep(2000);
		
		
		Object submit_Test = js.executeScript("return document.querySelector(\"body > div:nth-child(7) > div > div > div.ModalWindow__Body-sc-1blkd9p-2.fDMumk > div.Box__Wrapper-sc-6lvy0r-0.eYxdWs > button.Button__ButtonWrapper-sc-hbh4t9-0.llpkaq.has-min-width\")");
		js.executeScript("arguments[0].click()", submit_Test);
		Thread.sleep(4000);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Skip"))).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath(prop.getProperty("Assessment_Codility_Continue"))).click();
		Thread.sleep(3000);
		
		
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(50000);
		driver.navigate().refresh();
		Thread.sleep(75000);
		driver.navigate().refresh();
		Thread.sleep(1500);
			
		driver.findElement(By.xpath(prop.getProperty("WorkOpportunities"))).click();
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites"))).click();
		
		driver.navigate().refresh();
		
		driver.findElement(By.xpath(prop.getProperty("AllOpportunites_SearchOpportunites")))
		.sendKeys("Front End");
		Thread.sleep(4000);
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(2000);
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(2000);
		
		
	*/	Thread.sleep(2000);
	
	
	
		driver.findElement(By.xpath("//div[@id='HR150223140227']/child::div[1]/div[2]/div/div[2]/button")).click();
		
		driver.findElement(By.xpath("//button[.='Yes Apply']")).click();
		
		driver.get("https://ats.internalstaging.uplers.in/admin/login\r\n"
				+ "");

		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("admin@uplers.com\r\n"
				+ "");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("0O*ridrOHls7");
		driver.findElement(By.xpath(prop.getProperty("login"))).click();

		String actual = driver.getTitle().trim();
		String expected = "Uplers Talent Solutions Staging | Dashboard";
		Assert.assertEquals(expected, actual);
		
		driver.findElement(By.xpath("(//span[@class='m-menu__link-wrap'])[7]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("automationtesting327@gmail.com");
		driver.findElement(By.xpath("//tbody/tr/td/div")).click();
	//	driver.findElement(By.xpath("//tbody/tr/td/div/div/a[.='Selected']")).click();
		
		
		
		
		
	
	}
	
	
}
