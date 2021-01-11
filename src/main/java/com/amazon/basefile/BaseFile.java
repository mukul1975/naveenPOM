package com.amazon.basefile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.amazon.util.UtilFile;

public class BaseFile {
	
	public  static Properties prob;
	public  static WebDriver driver;
	
	public BaseFile()
	{
		prob=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\saiful\\naveenPOM\\src\\main\\java\\com\\amazon\\config\\config.properties");
			
				prob.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public void inicialBrowser()
	{
		String browserName=prob.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\saiful\\Desktop\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Saiful\\Desktop\\Selenium\\webdriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilFile.pageTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilFile.implicitTimeOut, TimeUnit.SECONDS);
		driver.get(prob.getProperty("url"));
	}
}
	

