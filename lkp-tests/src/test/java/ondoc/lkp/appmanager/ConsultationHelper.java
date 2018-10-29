package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsultationHelper extends HelperBase {

    public ConsultationHelper(WebDriver wd) {
        super(wd);
    }

    public void recommendations(String recomendadions) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea"), recomendadions);
    }

    public void objectively(String objectivno) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea"), objectivno);
    }

    public void anamnesis(String anam) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea"), anam);
    }

    public void complaints(String zhalob) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/div[2]/textarea"), zhalob);
    }

    public void diagnosis(String diag) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[3]/input"), diag);
    }

    public void MKB() {
        type(By.id("icd-form-select_value"), "it");
        WebElement mkbElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")));
        mkbElement.findElement(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]")).click();
        //click(By.xpath("//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]"));
    }

    public void createConsultation() throws InterruptedException {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']"));

        WebElement clinikElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/strong")));
        clinikElement.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/strong")).click();

        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']"));

        WebElement docElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/a")));
        docElement.findElement(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/a")).click();

        //click(By.cssSelector("a.medcard-doctor__doc-name.ng-binding"));
    }

    public void commentInConsultation() {
        WebElement comElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button")));
        comElement.findElement(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button")).click();
        //click(By.xpath("//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("strong"));
    }

    public void deleteConsultation() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/input"));
        }

        WebElement medcardElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div")));
        medcardElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div")).click();

        WebElement editElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")));
        editElement.findElement(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")).click();

        WebElement deleteElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")));
        deleteElement.findElement(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")).click();

        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));

    }

}
