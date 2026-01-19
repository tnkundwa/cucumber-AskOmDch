package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "Msedge" -> {
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Browser not recognized" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
