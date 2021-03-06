package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AllergiesHelper extends HelperBase {

    public AllergiesHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_ALLERG = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div";
        private static final String EDIT = "/html/body/div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/allergy-details/div/section/div/div[1]/div/div[3]/patient-medcard-edit-button";
        private static final String DELETE_BUTTON = "/html/body/div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/allergy-create/div/div[3]/div/div[1]/patient-medcard-allergy-delete-button/button";
    }

    public int getAllergiesCount() {
        return wd.findElements(By.cssSelector("strong.font-medium")).size();
    }

    public void reactionAllergies(String reaction) {
        type(By.xpath("(//input[@type='text'])[2]"), reaction);
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

    public void nameAllergies(String name) {
        type(By.xpath("//input[@type='text']"), name);
    }

    public void createAllergies() {
        click(By.xpath("//*[@data-testid=\"medcard-type-allergy\"]"));
    }

    public void commentInAllergies() {
        waiting(1, TimeUnit.MINUTES);
        click(By.xpath("//div[@class='margin-bottom-large']/div[2]/button"));
        click(By.cssSelector("strong"));
    }

    public  void modificationAllergies() {
        findAndClick(Elements.REC_ALLERG);
        findAndClick(Elements.EDIT);
        type(By.xpath("//div[@class='col-xs-17']/input"), "Аллергия на шоколад");
        type(By.xpath("//div[@class='widget']/div[2]/div[1]/div[2]/div[3]/input"), "Красные пятна на коже");
    }

    public void deleteAllergies() {
        goToInsertAllergies();
        findAndClick(Elements.REC_ALLERG);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("/html/body/div[4]/div/div/div[2]/div/div[2]/button"));
    }

    public void attachDocument() {
        click(By.xpath("//div[@class='widget']/div[2]/div[2]/files-attachment/div/label/span"));

    }

    public void goToInsertAllergies() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    private File pdf;

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

}






