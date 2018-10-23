package ondoc.lkp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteAnalysis extends TestBase {
    ChromeDriver wd;

    @Test
    public void testDeleteAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/span")).click();
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/input")).isSelected()) {
            wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/input")).click();
        }
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/strong")).click();
        wd.findElement(By.cssSelector("span.icon.icon__edit")).click();
        wd.findElement(By.cssSelector("input.r-button.r-button--red-border")).click();
        wd.findElement(By.linkText("Удалить")).click();
    }
}

