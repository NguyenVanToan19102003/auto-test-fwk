package com.example.project.steps;

import com.example.project.pages.LoginPages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {
    LoginPage loginPage;

    @Step("Người dùng mở trang đăng nhập")
    public void openBrowserSteps(){
        loginPage.openLoginPage();
    }

    @Step("Người dùng nhập username {string}")
    public void sendUserNameSteps(String username){
        loginPage.sendUsername(username);
    }

    @Step("Người dùng nhập password {string}")
    public void sendPasswordSteps(String password){
        loginPage.sendPassword(password);
    }

    @Step("Người dùng bấm nút đăng nhập")
    public void clickButtonLoginSteps(){
        loginPage.clickButton();
    }

    @Step("Người dùng đăng nhập thành công")
    public void loginSuccessSteps(){
    }

    @Step("Điều hướng đến trang chủ")
    public void navigateHomeSteps(){
    }
}
