package com.example.project.pages;

import com.example.project.action.ClickAction;
import com.example.project.action.InputAction;
import com.example.project.framework.browser.BrowserManager;
import com.example.project.framework.constants.GlobalConstants;
import com.example.project.framework.utils.LoggerUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
    @BeforeMethod
    public void setUp() {
        BrowserManager.initDriver(GlobalConstants.BROWSER);
        LoggerUtils.info("🚀 Driver is initialized");
    }

    @Test
    public void testLoginSuccess() {
        BrowserManager.getDriver().get(GlobalConstants.BASE_URL);

        // Nhập username và password
        InputAction.setText(By.id("username"), GlobalConstants.USERNAME);
        InputAction.setText(By.id("password"), GlobalConstants.PASSWORD);

        // Click nút login
        ClickAction.click(By.id("submit"));

    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.clossBrowser();
        LoggerUtils.info("🧹 Driver is closed");
    }
}
