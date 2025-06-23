package com.example.project.action;

import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAction {

    private static WebDriver getDriver() {
        return ThucydidesWebDriverSupport.getDriver();
    }

    // Todo build method click
    public static void click(By locator){
        try {
            WaitUtils.waitForElementClickable(locator);
            WebElement element = getDriver().findElement(locator);
            element.click();
            LoggerUtils.info("✅ Click element success !" + element.toString());
        }catch (Exception e){
            LoggerUtils.error("❌ Click failed on locator: " + locator.toString(), e);
            throw new RuntimeException("Click action failed: " + e.getMessage(), e);
        }
    }

    // Todo build method doubleclick
    public static void doubleClick(By locator){
        try {
            WaitUtils.waitForElementClickable(locator);
            WebElement element = getDriver().findElement(locator);
            Actions action = new Actions(getDriver());
            action.doubleClick(element).perform();
            LoggerUtils.info("✅ Double click element success: " + locator.toString());
        }catch (Exception e){
            LoggerUtils.error("❌ Double click failed on element: " + locator.toString(), e);
            throw new RuntimeException("Double click action failed: " + e.getMessage(), e);
        }
    }
}
