package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

public class ContactPage {
	private WebDriver driver;
	
	public ContactPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "salutation")
	public WebElement prefixDropdown;
	
	@FindBy(id = "first_name")
	public WebElement firstName;
	
	@FindBy(id = "last_name")
	public WebElement lastName;
	
	@FindBy(id = "phone_mobile")
	public WebElement phonNumber;
	
	@FindBy(id = "title")
	public WebElement title;
	
	@FindBy(id = "SAVE")
	public WebElement saveBtn;
	
	@FindBy(xpath  = "(//input[@title='Save'])[1]")
	public WebElement saveBtn2;
	
	@FindBy(xpath = "//h2[@class='module-title-text']")
	public WebElement contactTitle;
	
	@FindBy(xpath = "//div[@field = 'phone_mobile']")
	public WebElement mobilePhoneValidation;
	
	public void createContact(String prefix, String firstNameInput, String lastNameInput, String phoneNum, String titleInput) {
		Select prefixSelect = new Select(prefixDropdown);
		prefixSelect.selectByVisibleText(prefix);
	    firstName.sendKeys(firstNameInput);
	    lastName.sendKeys(lastNameInput);
	    phonNumber.sendKeys(phoneNum);
	    title.sendKeys(titleInput);
	    BrowserUtils.waitFor(2);
	    saveBtn.click();
	    try {
	    	 saveBtn2.click();
	    }
	    catch(Exception e) {
	    		System.out.println("Contact is not duplicate");
	    }
	   
	    BrowserUtils.waitFor(3);
	}
	
}






