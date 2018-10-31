package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waiting(int time, TimeUnit unit) {
        wd.manage().timeouts().implicitlyWait(time, unit);
    }

    public void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public void findAndClick(String elementPath) {
        By locator = By.xpath(elementPath);
        WebElement medcElement = (new WebDriverWait(wd, 60))
                .until(ExpectedConditions.elementToBeClickable(locator));
        medcElement.findElement(locator).click();
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
