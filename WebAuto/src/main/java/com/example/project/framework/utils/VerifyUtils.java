package com.example.project.framework.utils;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class VerifyUtils {

    private static WebDriver getDriver() {
        return ThucydidesWebDriverSupport.getDriver();
    }
    // Todo build method verify element tồn tại trên dom
    public static void verifyElementPresent(By locator){
        try {
            WaitUtils.waitForElementPresent(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertNotNull(element);
            LoggerUtils.info("✅ verifyElementPresent PASSED: Element = " + element);
        }catch (AssertionError a){
            LoggerUtils.error("❌ verifyElementPresent FAILED: Element not found " + locator, a);
            throw a;
        }catch (Exception e){
            LoggerUtils.error("❌ Exception in verifyElementPresent: " + locator, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element k tồn tại trên dom
    public static void verifyElementNotPresent(By locator) {
        try {
            WaitUtils.waitForElementPresent(locator);
            getDriver().findElement(locator);
            // Nếu tìm được phần tử thì là lỗi -> fail test
            Assert.fail("Element is present but should not be: " + locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.info("✅ verifyElementNotPresent PASSED: Element not found as expected " + locator);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementNotPresent FAILED: Element is still present " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementNotPresent", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element tồn tại trên UI
    public static void verifyElementVisible(By locator){
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed());
            LoggerUtils.info("✅ verifyElementVisible PASSED: Element = " + element);
        }catch (AssertionError a){
            LoggerUtils.error("❌ verifyElementVisible FAILED: Element not found " + locator, a);
            throw a;
        }catch (Exception e){
            LoggerUtils.error("❌ Exception in verifyElementVisible: " + locator, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element k tồn tại trên UI
    public static void verifyElementNotVisible(By locator) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertFalse(element.isDisplayed(), "Element is visible but should not be: " + locator);
            LoggerUtils.info("✅ verifyElementNotVisible PASSED: " + locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.info("✅ verifyElementNotVisible PASSED: Element not found (treated as not visible) - " + locator);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementNotVisible FAILED: Element is visible - " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementNotVisible", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify 2 chuỗi bằng nhau
    public static void verifyEqual(String actual, String expected){
        try {
            Assert.assertEquals(actual, expected);
            LoggerUtils.info("✅ verifyEqual PASSED: Actual = " + actual + "Expected = " + expected);
        }catch (AssertionError a){
            LoggerUtils.error("❌ verifyEqual FAILED: Actual = " + actual + "Expected = " + expected, a);
            throw a;
        }catch (Exception e){
            LoggerUtils.error("❌ Exception in verifyEqual", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify 2 chuỗi không bằng nhau
    public static void verifyNotEqual(String actual, String expected){
        try {
            Assert.assertNotEquals(actual, expected);
            LoggerUtils.info("✅ verifyNotEqual PASSED: Actual = " + actual + "Expected = " + expected);
        }catch (AssertionError a){
            LoggerUtils.error("❌ verifyNotEqual FAILED: Actual = " + actual + "Expected = " + expected, a);
            throw a;
        }catch (Exception e){
            LoggerUtils.error("❌ Exception in verifyNotEqual", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify chuỗi actual chứa expectedSubstring
    public static void verifyContains(String actual, String expectedSubstring){
        try {
            Assert.assertTrue(actual.contains(expectedSubstring));
            LoggerUtils.info("✅ verifyContains PASSED: Actual contains " + expectedSubstring);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyContains FAILED: Actual " + actual + "does not contain " + expectedSubstring, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyContains", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify Một chuỗi or số có đúng định dạng không
    public static void verifyMatch(String actual, String regexPattern) {
        try {
            Assert.assertTrue(actual.matches(regexPattern));
            LoggerUtils.info("✅ verifyMatch PASSED: Text matches regex " + regexPattern);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyMatch FAILED: Text " + actual + "does not match regex" + regexPattern, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyMatch", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element có đúng với gia trị mong đợi
    public static void verifyElementText(By locator, String expectedText) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            String actualText = element.getText();
            Assert.assertEquals(actualText, expectedText);
            LoggerUtils.info("✅ verifyElementText PASSED: Actual text = " + actualText + ", Expected = " + expectedText);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementText FAILED: Text does not match", a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementText", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify url hiện tại có giống expectedUrl mong đợi
    public static void verifyCurrentUrl(String expectedUrl) {
        try {
            String actualUrl = getDriver().getCurrentUrl();
            Assert.assertEquals(expectedUrl, 2);
            LoggerUtils.info("✅ verifyCurrentUrl PASSED: URL matches " + expectedUrl);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyCurrentUrl FAILED: Expected " + expectedUrl + ", Actual" + getDriver().getCurrentUrl(), a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyCurrentUrl", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify attribute có đúng với giá trị mong đợi
    public static void verifyElementAttribute(By locator, String attributeName, String expectedValue) {
        try {
            WaitUtils.waitForElementPresent(locator);
            WebElement element = getDriver().findElement(locator);
            String actualValue = element.getDomAttribute(attributeName);
            Assert.assertEquals(actualValue, expectedValue);
            LoggerUtils.info("✅ verifyElementAttribute PASSED: AttributeName = " + attributeName + "ExpectedValue =" + expectedValue);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementAttribute FAILED: Attribute mismatch", a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementAttribute", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element có được enabled không
    public static void verifyElementEnabled(By locator) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertTrue(element.isEnabled());
            LoggerUtils.info("✅ verifyElementEnabled PASSED: Element is enabled " + locator);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementEnabled FAILED: Element is not enabled " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementEnabled: " + locator, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element có hiển thị và click được không
    public static void verifyElementClickable(By locator) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
            LoggerUtils.info("✅ verifyElementClickable PASSED: " + locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.error("❌ verifyElementClickable FAILED: Element not found " + locator, e);
            throw e;
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementClickable FAILED: Not clickable " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementClickable", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify element không được enabled
    public static void verifyElementDisabled(By locator) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertFalse(element.isEnabled(), "Element is enabled but should be disabled: " + locator);
            LoggerUtils.info("✅ verifyElementDisabled PASSED: " + locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.error("❌ verifyElementDisabled FAILED: Element not found " + locator, e);
            throw e;
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementDisabled FAILED: Element is enabled " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementDisabled", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify checkbox or radio đã được chọn chưa
    public static void verifyElementSelected(By locator) {
        try {
            WaitUtils.waitForElementVisible(locator);
            WebElement element = getDriver().findElement(locator);
            Assert.assertTrue(element.isSelected());
            LoggerUtils.info("✅ verifyElementSelected PASSED: Element is selected " + locator);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementSelected FAILED: Element not selected " + locator, a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementSelected: " + locator, e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify title hiện tại có giống với title mong đợi
    public static void verifyTitle(String expectedTitle) {
        try {
            String actualTitle = getDriver().getTitle();
            Assert.assertEquals(expectedTitle, actualTitle);
            LoggerUtils.info("✅ verifyTitle PASSED: Title matches " + expectedTitle);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyTitle FAILED: Expected " + expectedTitle + ", Actual" + getDriver().getTitle(), a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyTitle", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify số lượng element có bằng giá trị mong đợi
    public static void verifyElementCountEquals(By locator, int expectedCount) {
        try {
            WaitUtils.waitForElementPresent(locator);
            List<WebElement> elements = getDriver().findElements(locator);
            int actualCount = elements.size();
            Assert.assertEquals(actualCount, expectedCount);
            LoggerUtils.info("✅ verifyElementCountEquals PASSED: Found = " + actualCount + ", expectedCount" + expectedCount);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyElementCountEquals FAILED", a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyElementCountEquals", e);
            throw new RuntimeException(e);
        }
    }
    // Todo build method verify kích thức list có bằng giá trị mong đợi
    public static void verifyListSize(List<?> list, int expectedSize) {
        try {
            int actualSize = list.size();
            Assert.assertEquals(actualSize, expectedSize);
            LoggerUtils.info("✅ verifyListSize PASSED: List size = " + actualSize);
        } catch (AssertionError a) {
            LoggerUtils.error("❌ verifyListSize FAILED: Expected size = " + expectedSize + ", Actual size = " + list.size(), a);
            throw a;
        } catch (Exception e) {
            LoggerUtils.error("❌ Exception in verifyListSize", e);
            throw new RuntimeException(e);
        }
    }

    // Todo build method verify

}
