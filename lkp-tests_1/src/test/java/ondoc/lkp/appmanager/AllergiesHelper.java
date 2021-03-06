package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AllergiesHelper extends HelperBase {

    public AllergiesHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_ALLERG = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div";
        private static final String EDIT = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/allergy-details/div/section/div/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input";
    }

    public void reactionAllergies(String reaction) {
        type(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input"), reaction);
    }

    public void nameAllergies(String name) {
        type(By.xpath("//div[@class='col-xs-17']/input"), name);
    }

    public void createAllergies() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[2]/div"));
    }

    public void commentInAllergies() {
        waiting(2, TimeUnit.MINUTES);
        click(By.xpath("//div[@class='margin-bottom-large']/div[2]/button"));
        click(By.cssSelector("strong"));
    }

    public void createFullAllergies() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createAllergies();
        nameAllergies("Аллергия на лактозу");
        reactionAllergies("Сыпь на коже в виде крапивницы, дерматита, экземы. Одышка, насморк, чихание, бронхиальная астма, отек Квинке.");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
        commentInAllergies();
    }

    public boolean isThereAllergies() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div"));
    }

    public void deleteAllergies() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input"));
        }
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]"));
        findAndClick(Elements.REC_ALLERG);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//a[.='Удалить']"));

        WebElement urlElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/span")));

        //доделать вывод результата не на консоль, а в idea
        String url = wd.getCurrentUrl();
        if (url.equals("https://dev.ondoc.me/medcard?type=allergy")) {
            System.out.println("Delete - Passed");
        } else {
            System.out.println("Delete - Failed");
        }
    }
}