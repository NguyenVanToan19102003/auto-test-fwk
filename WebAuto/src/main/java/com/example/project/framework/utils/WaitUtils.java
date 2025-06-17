package com.example.project.framework.utils;

import com.example.project.framework.browser.BrowserManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    // Todo 1: wait 1 element hiển thị trên UI
    public static WebElement waitForElementVisible(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Todo 2: wait 1 element k còn hiển thị trên UI
    public static Boolean waitForElementNotVisible(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    // Todo 3: wait 1 element hiển thị trong dom
    public static WebElement waitForElementPresent(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    // Todo 4: wait 1 element k còn hiển thị trong dom
    public static Boolean waitForElementNotPresent(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    // Todo 5: wait 1 element hiển thị và được bật để click
    public static WebElement waitForElementClickable(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    // Todo 6: wait 1 element hiển thị text cụ thể và đúng
    public static Boolean waitForTextToBePresentInElement(By locator, String text){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    // Todo 7: wait 1 element chứa text cụ thể theo locator
    public static Boolean waitForTextToBePresentInElementLocated(By locator, String text){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    // Todo 8: wait 1 alert xuất hiện
    public static Alert waitForAlertPresent(){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    // Todo 9: wait đến 1 khi trang tải xong
    public static Boolean waitForPageLoad(){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")).equals("complete");
    }
    // Todo 10: wait đến khi 1 attribute của 1 element có giá trị mong muốn
    public static Boolean waitForElementAttribute(By locator, String attribute, String value){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }
    // Todo 11: wait đến khi checkbox hoặc radio button được chọn (checked)
    public static Boolean waitForElementSelected(By locator){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //Todo 12: wait 1 danh sách kết quả tìm kiếm trả về đúng số lượng phần tử
    public static List<WebElement> waitForNumberOfElementsToBe(By locator, int number) {
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
    }
    // Todo 13: wait khi chuyển trang kiểm tra xem url có chứa 1 phần cụ thể
    public static Boolean waitForUrlContains(String partialUrl){
        WebDriver driver = BrowserManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

}

