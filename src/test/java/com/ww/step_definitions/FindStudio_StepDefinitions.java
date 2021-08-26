package com.ww.step_definitions;

import com.ww.pages.FindWorkshopPage;
import com.ww.pages.StudioDetailPage;
import com.ww.utils.ConfigurationReader;
import com.ww.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindStudio_StepDefinitions {

    FindWorkshopPage findWorkshopPage = new FindWorkshopPage();
    StudioDetailPage studioDetailPage = new StudioDetailPage();


    @Given("user has navigated to the home page")
    public void user_has_navigated_to_the_home_page() {
        findWorkshopPage.navigateToHomePage();
    }

    @Given("verified the page title")
    public void verified_the_page_title() {
        findWorkshopPage.verifyPageTitle();
    }

    @When("user clicks on Studio button")
    public void user_clicks_on_studio_button() {
        findWorkshopPage.clicksOnStudioButton();
    }

    @When("user enters {string} in the search field box")
    public void user_enters_in_the_search_field_box(String zipcode) {
        findWorkshopPage.enterZipcodeInSearchField(zipcode);
    }

    @When("user prints the title and distance of the first search result")
    public void user_prints_the_title_and_distance_of_the_first_search_result() {
        findWorkshopPage.getFirstTitleAndDistance();
    }

    @When("user clicks on the first search result")
    public void user_clicks_on_the_first_search_result() {
        findWorkshopPage.clickOnFirstSearchResult();
    }

    @When("user verifies the displayed location title in the workshop detail page")
    public void user_verifies_the_displayed_location_title_in_the_workshop_detail_page() {
        studioDetailPage.verifyDisplayedTitle();
    }

    @When("user clicks on Business Hours button")
    public void user_clicks_on_business_hours_button() {
        studioDetailPage.clickOnBusinessHoursButton();
    }

    @Then("user should be able to print the business days and hours.")
    public void user_should_be_able_to_print_the_business_days_and_hours() {
        studioDetailPage.printAllBusinessHours();
    }





}
