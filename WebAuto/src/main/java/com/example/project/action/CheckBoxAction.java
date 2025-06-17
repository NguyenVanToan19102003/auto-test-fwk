package com.example.project.action;

import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxAction {

    // Todo build method click checkbox nếu chưa được chọn
    public static void checkCheckBox(By locator){
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            if (!element.isSelected()){
                element.click();
                LoggerUtils.info("✅ Checkbox is now checked: " + locator);
            }else {
                LoggerUtils.info("⚠ Checkbox was already checked: " + locator);
            }
        }catch (Exception e){
            LoggerUtils.error("❌ Failed to check checkbox: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method unclick checkbox nếu đang được chọn
    public static void uncheckCheckbox(By locator) {
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            if (element.isSelected()) {
                element.click();
                LoggerUtils.info("✅ Checkbox is now unchecked: " + locator);
            } else {
                LoggerUtils.info("⚠ Checkbox was already unchecked: " + locator);
            }
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to uncheck checkbox: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method kiểm tra checkbok đang được chọn
    public static boolean isCheckboxChecked(By locator){
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            boolean result = element.isSelected();
            LoggerUtils.info("✅ Checkbox checked status: " + result);
            return result;
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to check checkbox status: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method kiểm tra checkbok đang k được chọn
    public static boolean isCheckboxUnChecked(By locator){
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            boolean result = !element.isSelected();
            LoggerUtils.info("✅ Checkbox is unchecked: " + result);
            return result;
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to verify if checkbox is unchecked: " + locator, e);
            throw new RuntimeException(e);
        }
    }
}
