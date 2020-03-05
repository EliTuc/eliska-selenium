package firstattempt;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ClickMeBabyTest {
    private WebDriver driver;

    @Test
    public void clickmebaby() {
        driver.get("https://the-internet.herokuapp.com/");
        sleep(2);
        driver.manage().window().fullscreen();
        sleep(2);
        driver.findElement(By.linkText("Checkboxes")).click();
        sleep(2);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Checkboxes");
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //driver = new RemoteWebDriver(new URL("http://10.245.197.20:4444/wd/hub"), getDefaultChromeOptions());
        System.setProperty("webdriver.chrome.driver", "C:/Users/Eliška/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    private static ChromeOptions getDefaultChromeOptions() {
        String downloadFilepath = "mnt/data/";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--force-device-scale-factor=1");
        chromeOptions.addArguments("--disable-features=NetworkService");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-browser-side-navigation");

        return chromeOptions;
    }

}

