package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckupHelper extends HelperBase {

    public CheckupHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_CHECKUP = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]";
        private static final String EDIT = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/exam-details/div/section/div/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input";
    }

    public boolean isThereCheckup() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div"));
    }

    public void createFullCheckup() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createCheckup();
        choseDirection();
        directionName("Иммунограмма");
        MKBcheckup();
        diagnosisChekup("Пониженный иммунитет");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
        commentInChekup();
    }

        public void createCheckup() {
        click(By.xpath("//*[@data-testid=\"medcard-type-exam\"]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Клиника и врач'])[1]/following::strong[1]"));
        waiting(1, TimeUnit.MINUTES);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ул. Гарибальди, д. 36'])[1]/preceding::div[2]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите врача'])[1]/following::p[1]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите врача'])[1]/following::p[1]"));
    }

    public void modificationCheckup() {
        findAndClick(Elements.REC_CHECKUP);
        findAndClick(Elements.EDIT);
        choseDirectionModification();
        directionName("Диетология");
        MKBcheckupModification();
        diagnosisChekup("Ожирение I степени");
        complaintsChekup("Проблема с лишним весом");
        anamnesisChekup("ИТМ = 32,4. Рост 170 см, вес 96 кг");
        objectivelyChekup("Абдоминальное распределение жировой массы");
        recommendationsChekup("Рацион питания должен состоять из свежих фруктов, ягод, овощей, зелени.\n" +
                "Записаться в тренажёрный зал.\n" +
                "Исключить продукты с консервантами, красителями, стабилизаторами, повышенным количеством сахара и жиров.");
    }

    public void directionName(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/input"), name);
    }

    public void choseDirection() {
        click(By.id("direction-form-select_value"));
        click(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[2]/direction-autocomplete/div/a"));
        click(By.xpath("//div[@class='clinic-directions__inner-wrapper']//span[.='Иммунология']"));
    }

    public void choseDirectionModification() {
        click(By.id("direction-form-select_value"));
        click(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[2]/div[2]/direction-autocomplete/div/a"));
        click(By.xpath("//div[@class='clinic-directions__inner-wrapper']//span[.='Диетология']"));
    }

    public void recommendationsChekup(String rek) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[7]/div[2]/textarea"), rek);
    }

    public void objectivelyChekup(String obj) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[6]/div[2]/textarea"), obj);
    }

    public void anamnesisChekup(String anam) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[5]/div[2]/textarea"), anam);
    }

    public void complaintsChekup(String zhalob) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[4]/div[2]/textarea"), zhalob);
    }

    public void diagnosisChekup(String diag) {
        type(By.xpath("//div[@class='widget']/div[2]/div/div[1]/div[3]/input"), diag);
    }

    public void MKBcheckup() {
        type(By.id("icd-form-select_value"), "Имму");
        click(By.xpath("//div[@id='icd-form-select_dropdown']/div[10]/div/div[2]"));
    }

    public void MKBcheckupModification() {
        type(By.id("icd-form-select_value"), "Ожирен");
        click(By.xpath("//div[@id='icd-form-select_dropdown']/div[5]/div/div[2]"));
    }

    public void commentInChekup() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/exam-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("strong"));
    }

    public void deleteCheckup() {
        goToInsertCheckup();
        findAndClick(Elements.REC_CHECKUP);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }

    public void goToInsertCheckup() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[5]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[5]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[5]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    public int getCheckupCount() {
        //return wd.findElements(By.xpath("/html/body/div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div[1]/medcard-list-item/div/div/div[2]/span")).size();
        return wd.findElements(By.cssSelector("body > div.inner-page-content > user-layout > div > div > div > section > medcard-layout > ui-view > medcard-list > div > div.widget.widget--min-height > div > div:nth-child(1) > medcard-list-item > div > div > div.col-xs-18.col-md-6.small-right.sm-right.flex.flex-vertical-center > span")).size();
    }
}
