package com.example.project.framework.constants;

import com.example.project.framework.config.ConfigReader;

public class GlobalConstants {
    public static final String BASE_URL = ConfigReader.getProperty("base.url");
    public static final String BROWSER = ConfigReader.getProperty("browser");
    public static final int TIMEOUT = ConfigReader.getInt("timeout");
    public static final String USERNAME = ConfigReader.getProperty("username");
    public static final String PASSWORD = ConfigReader.getProperty("password");
}
