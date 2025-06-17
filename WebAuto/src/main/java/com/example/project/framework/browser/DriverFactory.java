package com.example.project.framework.browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    // Todo setup trình duyệt cho driver
    public static WebDriver createDriver(String browserName){
        WebDriver driver;
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-win64/chromedriver.exe");
            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("K tìm thấy trình duyệt này !" + browserName);
        }
        return driver;
    }
}
