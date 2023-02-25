package com.perezcasal.junit.cucumber;

import com.perezcasal.junit.db_simulator.User;
import com.perezcasal.junit.db_simulator.UserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class UserManagementTest {
    UserService userService;
    User user;
    @Given("Initialize the User Service")
    public void initialize_the_user_service() {
        userService = new UserService(2);
    }
    @Given("An user")
    public void an_user(List<Map<String, String>> dataTable) {
        user = new User.Builder()
                .setUsername(dataTable.get(0).get("username"))
                .setName(dataTable.get(0).get("name"))
                .setLastname("lastname")
                .build();
    }
    @And("If user doesn't exists {string}")
    public void ifUserDoesnTExists(String username) {
       User found = userService.get(username);
       System.out.println(found == null);
    }
    @Then("Save user")
    public void save_user() {
        boolean saved = userService.add(user);
        System.out.println(saved);
    }
    @Then("Verify if {string} was saved")
    public void verify_if_the_user_was_saved(String username) {
        User found = userService.get(username);
        System.out.println(found != null);
    }
}
