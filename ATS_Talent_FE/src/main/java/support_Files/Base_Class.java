package support_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;

public class Base_Class {
	
	public static  WebDriver driver;
	//static JavascriptExecutor js;
	
	public static WebDriver get_Browser(String name) {
		if(name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}
	
	public static String get_Title() {
		String title = driver.getTitle();
		return title;

	}
	
	public static String Extent_Report_Base64(String path ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		
		InputStream is = new FileInputStream(path);
		byte[] bytes = IOUtils.toByteArray(is);
		String base = Base64.getEncoder().encodeToString(bytes);
		return base;
		
		
		
		
	}

	public static void click_On_Element(WebElement ele) {
		ele.click();
	}
	
	public static void send_Keys(WebElement ele,String data) {
	ele.sendKeys(data);
		
	}
	
	public static void clear(WebElement ele) {
		ele.clear();
	}
	
	public static String get_Text(WebElement ele) {
		
		String text = ele.getText();
		return text;
		
	}
	
	public static void javaScript_Scroll_Down(WebElement ele) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	public static void javaScript_Click(WebElement ele) {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", ele);
	}
	
	public static void javaScript_Scroll_800(){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,800)");
	}
	
	public  void javaScript_Scroll_400(WebDriver driver ){
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("window.scroll(0,400)");
	}
	
	public static void javaScript_Scroll_Into_View(WebElement ele) {
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public static String takesScreenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		return path;
	}
	
	
	public static String getParticularCellValue(int sheetNo,int rowNo,int cellNo) throws IOException {

		File src = new File("C:\\Users\\Admin\\eclipse-workspace\\ATS_Talent_FE\\ATS_Data.xlsx");
		FileInputStream input = new FileInputStream(src);
		Workbook wr = new XSSFWorkbook(input);
		Sheet sheet1=wr.getSheetAt(sheetNo);
		Row row=sheet1.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType=cell.getCellType();
		if(cellType.equals(cellType.STRING)) {
			
			String str = cell.getStringCellValue();
			return str;
		}
		return null;
	}
	
}

