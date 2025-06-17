package com.example.project.action;

import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioAction {

    // Todo build method Chọn 1 radio button nếu chưa được chọn
    public static void selectRadioButton(By locator) {
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            WebElement element = driver.findElement(locator);
            if (!element.isSelected()) {
                element.click();
                LoggerUtils.info("✅ Radio button selected: " + locator);
            } else {
                LoggerUtils.info("ℹ️Radio button already selected: " + locator);
            }
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to select radio button: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method Kiểm tra radio button đã được chọn
    public static boolean isRadioButtonSelected(By locator) {
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            boolean result = driver.findElement(locator).isSelected();
            LoggerUtils.info("✅ Radio button is selected: " + locator);
            return result;
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to verify radio button selection: " + locator, e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method Kiểm tra radio button chưa được chọn
    public static boolean isRadioButtonNotSelected(By locator) {
        try {
            WebDriver driver = BrowserManager.getDriver();
            WaitUtils.waitForElementVisible(locator);
            boolean result = !driver.findElement(locator).isSelected();
            LoggerUtils.info("✅ Radio button is not selected: " + locator);
            return result;
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to verify radio button not selected: " + locator, e);
            throw new RuntimeException(e);
        }
    }
}
