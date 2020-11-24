package com.amazon.homepageTest;

import org.testng.annotations.Test;

import com.amazon.basefile.BaseFile;

public class HomePageTest extends BaseFile{
	
	public HomePageTest()
	{
		super();
	}
	
	@Test
	public void homePageTest()
	{
		inicialBrowser();
	}

}
