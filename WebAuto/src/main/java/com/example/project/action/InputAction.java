package com.example.project.action;

import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputAction {

    private static WebDriver getDriver() {
        return ThucydidesWebDriverSupport.getDriver();
    }

    // Todo build method sendKeys text
    public static void sendKeys(By locator, String text){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            element.sendKeys(text);
            LoggerUtils.info("✅ SendKeys to: " + locator + " -> " + text);
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to sendKeys to: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method setText
    public static void setText(By locator, String text){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            clearText(locator);
            element.sendKeys(text);
            LoggerUtils.info("✅ SetText to: " + locator + " -> " + text);
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to setText to: " + locator, e);
            throw new RuntimeException("setText failed: " + e.getMessage(), e);
        }
    }

    // Todo build method getText
    public static String getText(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            String text = element.getText();
            LoggerUtils.info("✅ GetText from: " + locator + " -> " + text);
            return text;
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to getText from: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method clearText
    public static void clearText(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            element.clear();
            LoggerUtils.info("✅ Cleared text of: " + locator);
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to clear text of: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method getDomAttributeValue (Lấy giá trị của 1 attribute trong dom)
    public static String getDomAttribute(By locator, String attributeName){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            String value = element.getDomAttribute(attributeName);
            LoggerUtils.info("🔎 Attribute '" + attributeName + "' of element " + locator + " = " + value);
            return value;
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to get attribute '" + attributeName + "' from element: " + locator, e);
            throw new RuntimeException(e);
        }
    }
}
