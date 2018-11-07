package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NoteHelper extends HelperBase {

    public NoteHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_NOTE = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div";
        private static final String EDIT = "//div[@class='widget']/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/note-create/notes-create-page/div/div[3]/div/div[1]/button";
    }

    public boolean isThereNote() {
        return isElementPresent(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div"));
    }

    public void createFullNote() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[1]/div/div/div[2]/a"));
        createNote();
        nameNote("Для удаления");
        descriptionNote("Тест по удалению");
        click(By.xpath("//div[@class='widget']//button[.='Сохранить']"));
    }

    public void descriptionNote(String descr) {
        type(By.xpath("//div[@class='widget__textarea-wrapper']/textarea"), descr);
    }

    public void nameNote(String name) {
        type(By.cssSelector("input.sc-dxgOiQ.jYQKwt"), name);
    }

    public void createNote() {
        click(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[1]/div"));
    }

    public void deleteNote() {
        goToInsertNote();
        findAndClick(Elements.REC_NOTE);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }

    public void goToInsertNote() {
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/input"));
        }
        waiting(8, TimeUnit.SECONDS);
    }

    public int getNoteCount() {
        return wd.findElements(By.cssSelector("div.text-overflow.ng-binding")).size();
    }
}
