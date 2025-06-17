package com.example.project.steps;

import com.example.project.pages.LoginPages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {
    // Khai báo @steps vào và Đây là annotation của Serenity để inject đối tượng Login (PageObject).
    @Steps
    LoginPage loginPage;

    @Given("Người dùng mở trang đăng nhập")
    public void openBrowser(){
        loginPage.openLoginPage();
    }

    @When("Người dùng nhập username {string}")
    public void sendUserName(String username){
        loginPage.sendUsername(username);
    }

    @And("Người dùng nhập password {string}")
    public void sendPassword(String password){
        loginPage.sendPassword(password);
    }

    @And("Người dùng bấm nút đăng nhập")
    public void clickButtonLogin(){
        loginPage.clickButton();
    }

    @Then("Người dùng đăng nhập thành công")
    public void loginSuccess(){
    }

    @And("Điều hướng đến trang chủ")
    public void navigateHome(){

    }

}
