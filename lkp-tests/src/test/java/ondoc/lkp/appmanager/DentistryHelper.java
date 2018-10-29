package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DentistryHelper extends HelperBase {

    public DentistryHelper(WebDriver wd) {
        super(wd);
    }

    public void createDentisrty() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[2]/div[1]/div"));
        click(By.cssSelector("strong.ng-scope"));
        waiting(2, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.cssSelector("strong.ng-scope"));
        click(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]"));
    }

    public void conclusionTooth(String zakl) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[5]/div[2]/textarea"), zakl);
    }

    public void objectivelyTooth(String obj) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[4]/div[2]/textarea"), obj);
    }

    public void anamnesisTooth(String anam) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[3]/div[2]/textarea"), anam);
    }

    public void complaintsTooth(String zhalob) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[2]/div[2]/textarea"), zhalob);
    }

    public void diagnisisTooth(String diag) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/div[1]/div[1]/div[3]/input"), diag);
    }

    public void MKBtooth() {
        type(By.id("icd-form-select_value"), "Кариес");
        click(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]"));
    }

    public void toothСondition() {
        waiting(2, TimeUnit.MINUTES);
        click(By.linkText("Без изменений"));
        click(By.xpath("//div[@class='widget']//p[.='Вылечен']"));
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[1]/input"), "Кариес");
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/div/div[3]/div[2]/input"), "Здоров");
    }

    public void toothSelection27() {
        click(By.xpath("//table[@class='stoma-scheme']//span[.='27']"));
    }

    public void commentInDentistry() {
        click(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.xpath("//div[1]/div/div[2]/div[7]/buttton[1]/strong"));
    }

    public void deleteDentistry() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[4]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[4]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[4]/input"));
        }

        WebElement medcardElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]")));
        medcardElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]")).click();

        WebElement editElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")));
        editElement.findElement(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")).click();

        WebElement deleteElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")));
        deleteElement.findElement(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")).click();

        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));

    }

}
