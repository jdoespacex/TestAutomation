package com.app.step_definitions;

import java.util.List;

import com.app.models.Contact;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class DDT_within_step_stepDefs {

	@Then("^I pass info$")
	public void i_pass_info(List<Contact> data) {
	    
		System.out.println("Size: " + data.size());
		
		for(Contact c: data) {
			System.out.println("\nPrefix: " + c.getPrefix());
			System.out.println("First Name: " + c.getFirstName());
		}
	    
	}
}
