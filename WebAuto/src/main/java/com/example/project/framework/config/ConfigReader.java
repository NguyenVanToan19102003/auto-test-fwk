package com.example.project.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    // Todo Biến static chứa đối tượng Properties ( Lưu các cấu hình )
    private static Properties properties = new Properties();
    // Todo Khối static: chỉ chạy 1 lần khi class được Load
    static {
        try {
            // Todo Load file config.properties từ mục resource
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if(input == null){
                throw new RuntimeException("K tìm thấy file config.properties trong thư mục resource !");
            }
            // Todo Đọc các cặp key-value từ file properties
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi đọc file config.properties: " + e.getMessage());
        }
    }

    // Todo Phương thức public để lấy giá trị theo key
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        if(value ==  null){
            throw new RuntimeException("Không tìm thấy giá trị nào cho key: " + key);
        }
        return value;
    }

    // Todo phương thức để ép kiểu sang int nếu cần
    public static int getInt(String key){
        return Integer.parseInt(getProperty(key));
    }

    // Todo phương thức để ép kiểu sang boolean nếu cần
    public static boolean getBoolean(String key){
        return Boolean.parseBoolean(getProperty(key));
    }

    // Todo phương thức để ép kiểu sang double nếu cần
    public static double getDouble(String key){
        return Double.parseDouble(getProperty(key));
    }
}
