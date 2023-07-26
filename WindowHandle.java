package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class WindowHandle {
    ChromeDriver driver;

    public WindowHandle() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void windowshandle() throws InterruptedException {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.manage().window().maximize();
        String currentWindow = driver.getWindowHandle();
        WebElement frame = driver.findElement(By.xpath("//*[@id='iframeResult']"));
        driver.switchTo().frame(frame);
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        clickButton.click();
        Set<String> allWindow = driver.getWindowHandles();
        for(String windowHal:allWindow){
            if(!windowHal.equals(currentWindow)){
                driver.switchTo().window(windowHal);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow);
    }
       public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }       
}

