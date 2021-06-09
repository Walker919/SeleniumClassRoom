package core;

import controls.WebTypifiedElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Set;

public class Helpers {

    private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
    protected static WebDriver driver;

    public static void click(WebDriver driver, WebElement a, WebElement b) {
        try {
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) driver).executeScript(mouseOverScript, a);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript(mouseOverScript, b);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", b);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void check2StringIfEquals(WebElement el, String str) {
        check2StringIfEquals(el.getText(), str);
    }

    public static void check2StringIfEquals(String str1, String str2) {
        log.info("Check 2 strings if equals\n1st:" + str1 + "\n2nd:" + str2);
        Assert.assertEquals(str1, str2, "Check 2 string if equals");
    }

    public static String getProperty(String key) throws IOException {
        FileReader reader = new FileReader("credentials.properties");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public static String randomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static void clickJS(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public static String generateFutureDate(int days) {
        LocalDateTime date = LocalDateTime.now().plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return date.format(formatter);
    }

    public static String switchToWindowByPartialUrl(WebDriver driver, String partialUrl, int timeout) {
        Set<String> allWindows;
        long end;
        long start = System.currentTimeMillis();
        do {
            allWindows = driver.getWindowHandles();
            end = System.currentTimeMillis();
            for (String curWindow : allWindows) {
                driver.switchTo().window(curWindow);
                log.info("Current window: " + driver.getCurrentUrl());
                if (driver.getCurrentUrl().contains(partialUrl)) {
                    return driver.getWindowHandle();
                }
            }
        } while (end - timeout * 1000 < start);
        log.error("The window with partial URL '" + partialUrl + "' was not found");
        return driver.getWindowHandle();
    }

    public static String switchToWindowByPartialWindowName(WebDriver driver, String partialWindowName, int timeout) {
        Set<String> allWindows;
        long end;
        long start = System.currentTimeMillis();
        do {
            allWindows = driver.getWindowHandles();
            end = System.currentTimeMillis();
            for (String curWindow : allWindows) {
                driver.switchTo().window(curWindow);
                if (driver.getTitle().contains(partialWindowName)) {
                    log.info("Switching to " + driver.getTitle() + ": " + driver.getCurrentUrl());
                    return driver.getWindowHandle();
                }
            }
        } while (end - timeout * 1000 < start);
        log.error("The window with title '" + partialWindowName + "' was not found");
        return driver.getWindowHandle();
    }
}