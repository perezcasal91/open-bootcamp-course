package com.perezcasal.junit.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class InitCucumber {
    @Given("Open the environment")
    public void open_the_environment() {
        System.out.println("Open");
    }

    @Given("I have assistants")
    public void i_have_assistants() {
        System.out.println("Assistants: 15");
    }

    @When("They look the screen")
    public void they_look_the_screen() {
        System.out.println("Showing the Screen");
    }

    @Then("I said hi")
    public void i_said_hi() {
        System.out.println("Hi everyone!!!");
    }

    // Scenario 2

    private String payMethod;

    @Given("User will pay with one of these methods")
    public void user_will_pay_with_one_of_these_methods(List<String> dataTable) {
        System.out.println(dataTable);
        for (String method :
                dataTable) {
            if (method.equalsIgnoreCase("cash")) {
                payMethod = method;
            }
        }
    }
    @When("We request that payment be made")
    public void we_request_that_payment_be_made() {
        System.out.println("The payment has made with " + payMethod);
    }
    @Then("Check the requested method")
    public void check_the_requested_method() {
        System.out.println(payMethod.equalsIgnoreCase("cash"));
    }
}
