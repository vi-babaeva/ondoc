package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void save() {
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
    }

    public void choseType() {
        WebElement dynamicElement = (new WebDriverWait(wd,10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")));
        dynamicElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a")).click();
    }

    public void gotoMedcard() {
        WebElement dynamicElement = (new WebDriverWait(wd,10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")));
        dynamicElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/aside/div[1]/div[4]/ul/li[2]/a")).click();
    }

    public void add() {
        click(By.linkText("Добавить"));
    }
}
