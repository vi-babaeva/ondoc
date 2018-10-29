package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class VaccinationHelper extends HelperBase {

    public VaccinationHelper(WebDriver wd) {
        super(wd);
    }

    public void nameVaccine2(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input"), name);
    }

    public void newDataVaccine2() {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input"), "18.12.2019" );
    }

    public void nameVaccine(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input"), name);
    }

    public void nameVaccination(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"), name);
    }

    public void createVaccination() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[4]/div/div"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']"));
        waiting(2, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']"));
        click(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/p"));
    }

    public void commentInVaccination() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("buttton.r-button.r-button--blue-border"));
    }

    public void deleteVaccination() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/input"));
        }

        WebElement medcardElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[3]/div/div[1]/img")));
        medcardElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div")).click();

        WebElement editElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[1]/div/div[3]/a/span")));
        editElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[1]/div/div[3]/a/span")).click();

        WebElement deleteElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")));
        deleteElement.findElement(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")).click();

        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }
}
