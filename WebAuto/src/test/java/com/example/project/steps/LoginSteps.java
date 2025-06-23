package com.example.project.steps;

import com.example.project.pages.LoginPages.LoginPage;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Step;

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

    @Step("Hiển thị text {string}")
    public void verifyTextLoginSuccessSteps(String text){
        loginPage.verifyTextLoginSuccess(text);
    }

    @Step("Người dùng đăng xuất khỏi hệ thống")
    public void logOutSteps(){
        loginPage.logOutSuccess();
    }
}
