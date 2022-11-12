package com.PRACTICE.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Create private constructor to restrict access to object of class
    private Driver(){};

    //private static WebDriver so we restrict access to change it elsewhere
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create re-usable utility method which will return same driver instance when we call it.
     */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){  // if driver/browser was never opened

            String browserType = ConfigurationReader.getProperty("browser");

        /*
        Depending on the browserType our switch statement will determine
        to open specific type of browser/driver
         */
            switch(browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        // Same driver instance will be returned every time we call Driver.getDriver() method
        return driverPool.get();

    }


    public static void closeDriver(){
        if(driverPool.get() != null) {
            driverPool.get().quit(); // this line will kill the session. value will noy be null
            driverPool.remove();
        }
    }

}
