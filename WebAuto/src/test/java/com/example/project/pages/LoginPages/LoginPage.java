package com.example.project.pages.LoginPages;
import com.example.project.action.ClickAction;
import com.example.project.action.InputAction;
import com.example.project.framework.utils.VerifyUtils;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("page:serenity.base.url")
public class LoginPage extends PageObject {

    private By username = By.id("username");
    private By password = By.id("password");
    private By button = By.id("submit");
    private By textLogin = By.className("post-title");
    private By btnLogout = By.xpath("//a[text()='Log out']");

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

    public void verifyTextLoginSuccess(String text){
        WebElement element = getDriver().findElement(textLogin);
        VerifyUtils.verifyEqual(element.getText(), text);
    }

    public void logOutSuccess(){
        ClickAction.click(btnLogout);
    }

    public void login(String username, String password) {
        sendUsername(username);
        sendPassword(password);
        clickButton();
    }
}
