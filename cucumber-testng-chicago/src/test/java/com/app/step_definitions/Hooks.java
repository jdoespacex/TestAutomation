package com.app.step_definitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.app.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void setUp(Scenario scenario) {
		System.out.println("This is Before scenario");
	}
	
	@After
	public void tearDown(Scenario scenario) {

		System.out.println("This is after scenario");
		if(scenario.isFailed()) {
			final byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
		Driver.closeDriver();
	}
	
}	



