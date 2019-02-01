package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String MEDCARD = "//a[contains(text(),'Медицинская карта')]";
        private static final String CHOSE_TYPE = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a";
    }

    public void save() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void choseType() {
        waiting(10, TimeUnit.SECONDS);
        findAndClick(Elements.CHOSE_TYPE);
    }

    public void gotoMedcard() {
        waiting(1, TimeUnit.MINUTES);
        findAndClick(Elements.MEDCARD);
    }

    public void backToList() {
        click(By.linkText("Назад к списку"));
        refreshPage();
        waiting(20, TimeUnit.SECONDS);
    }

    public void refreshPage() {
        wd.navigate().refresh();
    }

    public void add() {
        click(By.linkText("Добавить"));
    }
}
