package com.example.project.action;

import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollAction {
    // Todo build method cuộn (scroll) đến element mình muốn trên trang
    public static void scrollToElement(By locator){
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            LoggerUtils.info("✅ Scrolled to element by JS: " + locator);
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to scroll to element by JS: " + locator, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method scroll về đầu trang
    public static void scrollToTop(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            LoggerUtils.info("✅ Scrolled to top of the page");
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to scroll to top", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method scroll về cuối trang
    public static void scrollToBottom(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            LoggerUtils.info("✅ Scrolled to bottom of the page");
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to scroll to bottom", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method scroll trang theo số pixel (x, y) bằng JavaScript.
    public static void scrollByPixel(int x, int y){
        try {
            WebDriver driver = BrowserManager.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            // Thực thi lệnh cuộn trang theo pixel
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
            LoggerUtils.info("✅ Scrolled by pixel x=" + x + ", y=" + y);
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to scroll by pixel x=" + x + ", y=" + y, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method scroll để element nằm giữa màn hình
    public static void scrollIntoViewCenter(By locator){
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript(
                    "const viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                            + "const elementTop = arguments[0].getBoundingClientRect().top;"
                            + "window.scrollBy(0, elementTop - (viewPortHeight / 2));", element
            );
            LoggerUtils.info("✅ Scrolled element to center view: " + locator);
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to scroll to center element: " + locator, e);
            throw new RuntimeException(e);
        }
    }

}
