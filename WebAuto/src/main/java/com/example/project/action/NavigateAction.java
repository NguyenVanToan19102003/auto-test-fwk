package com.example.project.action;

import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;

public class NavigateAction {

    // Todo build method điều hướng url cụ thể
    public static void goToUrl(String url){
        try {
            WebDriver driver = BrowserManager.getDriver();
            driver.get(url);
            LoggerUtils.info("✅ Navigated to URL: " + url);
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to navigate to URL: " + url, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method quay lại trang trước đó
    public static void goBack(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            driver.navigate().back();
            LoggerUtils.info("✅ Navigated back to previous page");
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to navigate back", e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method đi tới trang tiếp theo
    public static void goForward(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            driver.navigate().forward();
            LoggerUtils.info("✅ Navigated forward to next page");
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to navigate forward", e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method refresh lại trang hiện tại
    public static void refreshPage(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            driver.navigate().refresh();
            LoggerUtils.info("✅ Page refreshed successfully");
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to refresh page", e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method lấy url hiện tại
    public static String getCurrentUrl(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            String url = driver.getCurrentUrl();
            LoggerUtils.info("✅ Current URL: " + url);
            return url;
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to get current URL", e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method lấy page title hiện tại
    public static String getPageTitle(){
        try {
            WebDriver driver = BrowserManager.getDriver();
            String title = driver.getTitle();
            LoggerUtils.info("✅ Page title: " + title);
            return title;
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to get page title", e);
            throw new RuntimeException(e);
        }
    }


}
