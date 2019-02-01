package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class VaccinationHelper extends HelperBase {

    public VaccinationHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_VACCINATION = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div";
        private static final String EDIT = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/vaccination-details/div/section/div/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input";
    }

    public boolean isThereVaccination() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div"));
    }

    public void createFullVaccination() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createVaccination();
        nameVaccination("Прививка от гриппа");
        nameVaccine("Инфлювак");
        click(By.linkText("Добавить"));
        nameVaccine2("Флюарикс");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
    }

    public void modificationVaccination() {
        findAndClick(Elements.REC_VACCINATION);
        findAndClick(Elements.EDIT);
        nameVaccination("Прививка от бешенства");
        nameVaccine("Рабипур");
        nameVaccine2("Индираб");
    }

    public void nameVaccine2(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/input"), name);
    }

    public void newDataVaccine2() {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/luxon-date-picker-input-scoped/luxon-date-picker-input/span/div/input"), "18.12.2019");
        //type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[3]/div/calendar/div[2]/input"), "18.12.2019" );
        //type(By.className("sc-chPdSV esENOO"), "18.12.2019");
    }

    public void nameVaccine(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[2]/input"), name);
    }

    public void nameVaccination(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"), name);
    }

    public void createVaccination() {
        click(By.xpath("//*[@data-testid=\"medcard-type-vaccination\"]"));
        //click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[4]/div/div"));
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
        goToInsertVaccination();
        findAndClick(Elements.REC_VACCINATION);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }

    public void goToInsertVaccination() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[8]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    public int getVaccinationCount() {
        return wd.findElements(By.cssSelector("div.text-overflow.ng-binding")).size();
    }
}
