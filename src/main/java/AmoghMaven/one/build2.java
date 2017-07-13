package AmoghMaven.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class build2 {

	String s,driver;
	String expectedtitle="NTT DATA Americas";
	String wb1;
	String username,password;
@BeforeTest
	public void Exceldata() throws IOException
	{
	File p1=new File("E:/Amogh NTT/time.xlsx");	
	
    FileInputStream fl1=new FileInputStream(p1);
    
    XSSFWorkbook wb1 =new XSSFWorkbook(fl1);
   
    XSSFSheet sheet1= wb1.getSheetAt(0);
   username= sheet1.getRow(1).getCell(0).getStringCellValue();
   password= sheet1.getRow(1).getCell(1).getStringCellValue();
    Assert.assertEquals(username,"109100@nttdata.com");
    Assert.assertEquals(password,"QAZWSXplmokn1");
    System.out.println("Logging In "   + username);
    System.out.println("Logging In With  "   + password);

    
	}
	
	
	
	
	
	@Test(priority=1)
	public void login() throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:/Amog java/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		System.out.println("Logging In "   );
		driver.get("http://portal.nttdatainc.com");
    	driver.findElement(By.xpath(".//*[@id='cred_userid_inputtext']")).sendKeys(username);

    	Thread.sleep(5000);
    	driver.findElement(By.xpath(".//*[@id='cred_sign_in_button']")).click();;
    	Thread.sleep(8000);
    	
    	
    	driver.findElement(By.id("passwordInput")).sendKeys(password);
    	driver.findElement(By.id("submitButton")).click();
    	Thread.sleep(8000);
    	s=driver.getTitle();
    	System.out.println(s);
    	driver.quit();

	}

	
	
	
	@Test(priority=2)
	public void execution() 
	{
		System.out.println("TESTING1");
		System.out.println(s);
		System.out.println(expectedtitle);
		
    	Assert.assertEquals(s, expectedtitle,"This checks for the login");
    	
	}

	@AfterTest
	public void Logout() {
		System.out.println("Logging out");
	
	}
}
