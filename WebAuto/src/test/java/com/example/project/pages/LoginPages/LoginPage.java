package com.example.project.pages.LoginPages;
import com.example.project.action.ClickAction;
import com.example.project.action.InputAction;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("page:serenity.base.url")
public class LoginPage extends PageObject {

    private By username = By.id("username");
    private By password = By.id("password");
    private By button = By.id("submit");

    public void openLoginPage() {
        open();
    }

    public void sendUsername(String sendUsername){
        InputAction.sendKeys(username, sendUsername);
    }
    public void sendPassword(String sendPassword){
        InputAction.sendKeys(password, sendPassword);
    }
    public void clickButton(){
        ClickAction.click(button);
    }

    public void login(String username, String password) {
        sendUsername(username);
        sendPassword(password);
        clickButton();
    }
}
