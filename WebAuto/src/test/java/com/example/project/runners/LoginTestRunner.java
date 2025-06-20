package com.example.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Chỉ định dùng runner của Serenity kết hợp Cucumber để chạy test
@RunWith(CucumberWithSerenity.class)
// features: đường dẫn tới thư mục chứa file, feature dùng /
// glue: đường dẫn java package chứa các class định nghĩa step dùng .
// plugin: cấu hình output hiển thị test, ở đây là "pretty" dễ đọc
// tags: lọc các scenario hoặc feature để chạy dựa trên tag
@CucumberOptions(
        features = "src/test/resources/features/login",
        glue = "com.example.project.stepdefinittions",
        plugin = {
                "pretty",                           // Log đẹp dễ đọc
                "html:target/serenity-reports",     // Báo cáo HTML
                "json:target/serenity.json",        // Báo cáo JSON
                "rerun:target/failed_scenarios.txt" // Ghi lại các test fail
        },
        tags = "@login",
        monochrome = true                           // Hiển thị console rõ hơn
)
public class LoginTestRunner {
}
