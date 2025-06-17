package com.example.project.framework.browser;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BrowserManager {

    // Todo Khai báo Thread <Luồng> để lưu riêng biệt driver
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();

    // Todo Truyền driver mới vào threadlocal
    public static void setDriver(WebDriver driver){
        driverLocal.set(driver);
    }

    // Todo Lấy ra driver trong threadlocal hiện tại
    public static WebDriver getDriver(){
        return driverLocal.get();
    }

    // Todo Khởi tạo 1 driver mới
    public static void initDriver(String browserName){
        WebDriver driver = DriverFactory.createDriver(browserName);
        driverLocal.set(driver);
        getDriver().manage().window().maximize();
    }

    // Todo đóng driver hiện tại và xóa driver khỏi threadlocal
    public static void clossBrowser(){
        if (getDriver() != null){
            getDriver().quit();
            driverLocal.remove();
        }
    }
}
