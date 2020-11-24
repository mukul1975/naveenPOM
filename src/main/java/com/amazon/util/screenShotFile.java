package com.amazon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amazon.basefile.BaseFile;

public class screenShotFile extends BaseFile{
	
	public screenShotFile()
	{
		super();
	}
	
	public void takescreenshotMethod(String testCaseName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Report\\"+testCaseName+".png";
		try {
			FileUtils.copyFile(src, new File (path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
