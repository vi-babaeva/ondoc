package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AnalysisHelper extends HelperBase {

    public AnalysisHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_ANALYSIS = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/strong";
        private static final String EDIT = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/analyze-details/div/section/div/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input";

    }

    public void createFullAnalysis() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createAnalysis();
        analysisName("Коагулограмма");
        firstIndicator("Протромбиновое время", "13.5", "9.0 - 15.0", "cек", "good");
        conclusionOfResults("Количество тромбоцитов в норме. Сосудисто-тромбоцитарный гемостаз в норме. Нормокоагуляция по внешнему и внутреннему пути активации плазменного гемостаза. Конечные этапы свертывания в норме. Активность антикоагулянтов и состояние фибринолитической системы в норме. Показатели коагулограммы в пределах физиологической нормы.");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
        commentInAnalysis();
    }

    public boolean isThereAnalysis() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]"));
    }

    public void conclusionOfResults(String conclusions) {
        type(By.xpath("//div[@class='widget']/div[2]/div[4]/textarea"), conclusions);
    }

    public void secondIndicator(String index, String result, String normValue, String units, String comment) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[3]/input"), index);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[5]/input"), result);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[7]/input"), normValue);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[9]/input"), units);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div[2]/div/div[11]/input"), comment);
    }

    public void firstIndicator(String index, String result, String normValue, String units, String comment) {
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input"), index);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[5]/input"), result);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[7]/input"), normValue);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[9]/input"), units);
        type(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[11]/input"), comment);
    }

    public void commentInAnalysis () {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/analyze-details/div/section/div/div[2]/medcard-comments-list/div/div[2]/button"));
        click(By.cssSelector("buttton.r-button.r-button--blue-border"));
    }

    public void analysisName(String name) {
        type(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"), name);
        click(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input"));
        clear(By.xpath("//div[@class='widget']/div[2]/div[3]/div[4]/div/div/div[3]/input"));
    }

    public void createAnalysis() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[1]/div[2]/div"));
        click(By.cssSelector("strong.ng-scope"));
        waiting(1, TimeUnit.MINUTES);
        click(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]"));
        click(By.cssSelector("strong.ng-scope"));
        click(By.xpath("//div[1]/div/div[2]/div[2]/div[1]/div[1]/div/div[2]"));
        click(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"));
        clear(By.xpath("//div[@class='widget']/div[2]/div[2]/div[2]/input"));
    }

    public void deleteAnalysis() {
        goToInsertAnalysis();
        findAndClick(Elements.REC_ANALYSIS);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }

    public void goToInsertAnalysis() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[3]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    public int getAnalysisCount() {
        return wd.findElements(By.cssSelector("div.text-overflow.ng-binding")).size();
    }
}
