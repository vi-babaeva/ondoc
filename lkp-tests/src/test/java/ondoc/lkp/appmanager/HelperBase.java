package ondoc.lkp.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        waiting(1, TimeUnit.MINUTES);
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
        waiting(1, TimeUnit.MINUTES);
        WebElement medcElement = (new WebDriverWait(wd, 20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        medcElement.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
