package com.example.project.action;

import com.example.project.framework.utils.LoggerUtils;
import com.example.project.framework.utils.WaitUtils;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectAction {

    private static WebDriver getDriver() {
        return ThucydidesWebDriverSupport.getDriver();
    }

    // Todo build method chọn option theo nội dung hiển thị
    public static void selectByVisibleText(By locator, String text){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            LoggerUtils.info("✅ Selected by visible text: " + text);
        } catch (Exception e){
            LoggerUtils.error("❌ Failed to select by visible text: " + text, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method chọn option theo value
    public static void selectByValue(By locator, String value){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement  element = getDriver().findElement(locator);
            Select select = new Select(element);
            select.selectByValue(value);
            LoggerUtils.info("✅ Selected by value: " + value);
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to select by value: " + value, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method chọn option theo chỉ số index
    public static void selectByIndex(By locator, int index){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Select select = new Select(element);
            select.selectByIndex(index);
            LoggerUtils.info("✅ Selected by index: " + index);
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to select by index: " + index, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method lấy ra text của option đang được chọn
    public static String getSelectedOptionText(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Select select = new Select(element);
            String selectedText = select.getFirstSelectedOption().getText();
            LoggerUtils.info("✅ Current selected option: " + selectedText);
            return selectedText;
        } catch (Exception e) {
            LoggerUtils.error("❌ Failed to get selected option text", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method kiểm tra dropdown có được chọn nhiều giá trị hay không
    public static boolean isMultiple(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Select select = new Select(element);
            boolean result = select.isMultiple();
            LoggerUtils.info("✅ Is multiple: " + result);
            return result;
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to check isMultiple", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method clear tất cả option đang được chọn
    public static void clearAllSelectOption(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Select select = new Select(element);
            select.deselectAll();
            LoggerUtils.info("✅ Deselected all options.");
        }catch (Exception e) {
            LoggerUtils.error("❌ Failed to deselect all options", e);
            throw new RuntimeException(e);
        }
    }

}
