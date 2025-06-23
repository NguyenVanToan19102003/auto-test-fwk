package com.example.project.stepdefinittions;

import com.example.project.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginStepdefinittions {

    // Khai báo @steps vào và Đây là annotation của Serenity để inject đối tượng Login (PageObject).
    @Steps
    LoginSteps loginSteps;

    @Given("Người dùng mở trang đăng nhập")
    public void openBrowserStepdefinittions(){
        loginSteps.openBrowserSteps();
    }

    @When("Người dùng nhập username {string}")
    public void sendUserNameStepdefinittions(String username){
        loginSteps.sendUserNameSteps(username);
    }

    @And("Người dùng nhập password {string}")
    public void sendPasswordStepdefinittions(String password){
        loginSteps.sendPasswordSteps(password);
    }

    @And("Người dùng bấm nút đăng nhập")
    public void clickButtonLoginStepdefinittions(){
        loginSteps.clickButtonLoginSteps();
    }

    @Then("Người dùng đăng nhập thành công")
    public void loginSuccessStepdefinittions(){
    }

    @And("Hiển thị text {string}")
    public void verifyTextLoginSuccessStepdefinittions(String text){
        loginSteps.verifyTextLoginSuccessSteps(text);
    }

    @And("Người dùng đăng xuất khỏi hệ thống")
    public void logOutStepdefinittions(){
        loginSteps.logOutSteps();
    }

}
