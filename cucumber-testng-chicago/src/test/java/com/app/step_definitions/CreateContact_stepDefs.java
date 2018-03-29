package com.app.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.app.pages.ContactPage;
import com.app.pages.SuiteCRMDashboardPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;
import com.app.utilities.ExcelUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateContact_stepDefs {
	
	
	@Given("^I go to create contact page$")
	public void i_go_to_create_contact_page() {
		Actions action = new Actions(Driver.getDriver());
	    System.out.println("user going to create contact page");
	    SuiteCRMDashboardPage suite = new SuiteCRMDashboardPage();
	    action.moveToElement(suite.createMenuBtn).perform();
	    BrowserUtils.waitFor(3);
	    suite.createContactOption.click();
	    BrowserUtils.waitFor(3);
	}

	@Then("^I create new contact using \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_create_new_contact_using(String prefix, String firstName, String lastName, String phoneNumber, String title) {
	   
		prefix = "Somethig Elese";
		System.out.println("\nprefix: " + prefix);
	    System.out.println("firstName: " + firstName);
	    System.out.println("lastName: " + lastName);
	    System.out.println("Phone: "+ phoneNumber);
	    System.out.println("Title: " + title);
	    
	    ContactPage cPage = new ContactPage();
	    cPage.createContact(prefix, firstName, lastName, phoneNumber, title);
	}
	
	@Then("^I validate new created contact info \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_validate_new_created_contact_info(String prefix, String firstName, String lastName, String phoneNumber, String title) {
		ContactPage cPage = new ContactPage();
		
		assertTrue( cPage.contactTitle.getText().contains(lastName.toUpperCase()),"Contact title validation: " + cPage.contactTitle.getText());
		assertEquals(cPage.firstName.getText(), firstName, "First Name validation"); 
		assertEquals(cPage.lastName.getText(), lastName, "Last Name validation");
		assertEquals(cPage.mobilePhoneValidation.getText(), phoneNumber, "Phone number validation");
		assertEquals(cPage.title.getText(), title, "Title validation");
		
	}
	
	@Given("^I validate contacts with data in excel sheet \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_validate_contacts_with_data_in_excel_sheet_and(String path, String sheet) {
	    ExcelUtils.openExcelFile(path, sheet);
	    SuiteCRMDashboardPage dash = new SuiteCRMDashboardPage();
	    for(int row =1; row < ExcelUtils.getUsedRowsCount(); row++) {
	    		
	    		if(ExcelUtils.getCellData(row, 1).equals("Y")) {
	    			String tempContact = ExcelUtils.getCellData(row, 0);
	    			dash.searchBtn.click();
	    			dash.searchInput.clear();
	    			dash.searchInput.sendKeys(tempContact + Keys.ENTER);
	    			String xpath = "//table[@class='list View']//a[.='" + tempContact+"']";
	    			List<WebElement> results = Driver.getDriver().findElements(By.xpath(xpath));
	    			if(results.size() > 0) {
	    				ExcelUtils.setCellData("PASS", row, 2);
	    			}
	    			else {
	    				ExcelUtils.setCellData("FAIL", row, 2);
	    			}
	    		}
	    		else {
	    			ExcelUtils.setCellData("Skipped", row, 2);
	    		}
	    }
	}
}







