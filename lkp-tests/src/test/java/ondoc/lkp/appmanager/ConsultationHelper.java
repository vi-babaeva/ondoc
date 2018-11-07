package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class ConsultationHelper extends HelperBase {

    public ConsultationHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_CONSULTATION = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div";
        private static final String EDIT = "//div[@class='widget']/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input";
        private static final String COMMENT = "//div[@class='widget']/div[2]/medcard-comments-list/div/div[2]/button";
        private static final String MKB = "//div[@id='icd-form-select_dropdown']/div[3]/div/div[2]";
        private static final String CLINIC = "//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/strong";
        private static final String DOCTOR = "//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/a";
    }

    public boolean isThereConsultation() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div"));
    }

    public void createFullConsultation() throws InterruptedException {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createConsultation();
        MKB();
        diagnosis("Атопический дерматит");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
        commentInConsultation();
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
        findAndClick(Elements.MKB);
    }

    public void createConsultation() throws InterruptedException {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[1]/div"));
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите клинику']"));
        findAndClick(Elements.CLINIC);
        click(By.xpath("//div[@class='widget']//strong[normalize-space(.)='Выберите врача']"));
        findAndClick(Elements.DOCTOR);
    }

    public void commentInConsultation() {
        findAndClick(Elements.COMMENT);
        click(By.cssSelector("strong"));
    }

    public void deleteConsultation() {
        goToInsertConsultation();
        findAndClick(Elements.REC_CONSULTATION);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }

    public void goToInsertConsultation() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[2]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    public int getConsultationCount() {
        return wd.findElements(By.cssSelector("div.text-overflow.ng-binding")).size();
    }
}
