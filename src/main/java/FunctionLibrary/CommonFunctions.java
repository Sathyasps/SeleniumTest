package FunctionLibrary;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class CommonFunctions {
    public static WebDriver driver;



    public void assertNosuchElement(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            Assert.fail();

        } catch (NoSuchElementException e)
        {
         Assert.assertTrue(true);
        }
    }
    public void openBrowser()
    {
     driver = new ChromeDriver();
     driver.manage().window().maximize();
    }
    public void closeBrowser()
    {
      driver.quit();
    }


    public WebElement findwebElement(WebDriver driver, By locator)
    {
       return driver.findElement(locator);
    }

    public List<WebElement> findwebElements(WebDriver driver, By locator)
    {
        return driver.findElements(locator);
    }

    public void clickElement(WebDriver driver,By locator)
    {
        findwebElement(driver,locator).click();
    }

    public void sendKey(WebDriver driver,By locator,String text)
    {
        findwebElement(driver,locator).sendKeys(text);
    }

    public void UrlGet(WebDriver driver,String url)
    {
        driver.get(url);
    }

    public void asserTrue(WebDriver driver,By locator)
    {
        Assert.assertTrue(findwebElement(driver,locator).isDisplayed());
    }

    public void assertequals(String Val,WebDriver driver,By locator)
    {
        Assert.assertEquals(Val,findwebElement(driver,locator).getText());
    }
}
