package com.cognizant.steps;

import com.cognizant.actions.Common_Actions;
import com.cognizant.actions.VaxishopLogin_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.fail;


public class VaxishopLogin_Steps {
	
	VaxishopLogin_Actions vaxishoplogin_actions;
	Common_Actions common_actions;

	public VaxishopLogin_Steps(VaxishopLogin_Actions vaxishoplogin_actions, Common_Actions common_actions) {
		this.common_actions = common_actions;
		this.vaxishoplogin_actions = vaxishoplogin_actions;
	}

	@Given("I am on Vaxishop login page")
	public void i_am_on_Vaxishop_login_page() throws Exception {
		common_actions.goToUrl("https://uk.stg.vaxishop.co.uk/login");
		Thread.sleep(3000);
	}

	@When("I enter valid userID {string} and password {string}")
	public void i_enter_valid_userID_and_password(String str1, String str2) {
		vaxishoplogin_actions.userName(str1);
		vaxishoplogin_actions.password(str2);
		vaxishoplogin_actions.login();
	}

	@When("I select a valid account {string} and click on Continue button")
	public void i_select_a_valid_account_and_click_on_Continue_button(String strAcct) {
		String actUrl = common_actions.getCurrentUrl();
		System.out.println("print acturl " + actUrl);
		String expUrl = "https://uk.stg.vaxishop.co.uk/vaxishop/en/GBP/";
		if (actUrl.equals(expUrl)) {
			vaxishoplogin_actions.selectAccount(strAcct);
			vaxishoplogin_actions.accSubmit();
		}
	}

	@Then("I navigate to the Vaxishop home page")
	public void i_navigate_to_the_Vaxishop_home_page() {
		String currUrl = common_actions.getCurrentUrl();
		String actUrl = "https://uk.stg.vaxishop.co.uk/vaxishop/en/GBP/category/NonFlu/";
		if (!currUrl.equals(actUrl)) {
			fail("User not navigated to home page");
		}
	}

	@When("I enter invalid userID and password")
	public void i_enter_invalid_userID_and_password() {
		vaxishoplogin_actions.userName("Asiiifusernm");
		vaxishoplogin_actions.password("P@ss1234");
		vaxishoplogin_actions.login();
	}

	@Then("I get the login failure error message")
	public void i_get_the_logion_failure_error_message() {
		String errMsg = vaxishoplogin_actions.errorLogin();
		String actMsg = "Username or Password is incorrect.";
		if (!actMsg.equals(errMsg)) {
			fail("Failed the scenario");
		}
	}

	@When("I enter valid userID and password from dataTable")
	public void i_enter_valid_userID_and_password_from_dataTable(DataTable dataTable) {
		vaxishoplogin_actions.userName(dataTable.cell(1, 0));
		vaxishoplogin_actions.password(dataTable.cell(1, 1));
		vaxishoplogin_actions.login();
	}

	@When("I click on {string}")
	public void i_click_on(String string) throws InterruptedException {
		vaxishoplogin_actions.selectAccount(string);
		Thread.sleep(2000);
		vaxishoplogin_actions.accSubmit();
	}

	@Then("I validate page navigates to {string} and contains {string}")
	public void i_validate_page_navigates_to_and_contains(String url, String title) {
		String actUrl = common_actions.getCurrentUrl();
		String actTitle = common_actions.getCurrentTitle();
		if (!actUrl.equals(url)) {
			fail("Page does not navigated to the expected url: " + url);
		}
		if (!actTitle.contains(title)) {
			fail("Title mismatch. Actual title is : " + actTitle);
		}
	}
}