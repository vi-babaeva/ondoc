package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NoteHelper extends HelperBase {

    public NoteHelper(WebDriver wd) {
        super(wd);
    }

    private class Elements {
        private static final String REC_NOTE = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div";
        private static final String EDIT = "//div[@class='widget']/div[1]/div/div[3]/a/span";
        private static final String DELETE_BUTTON = "//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/note-create/notes-create-page/div/div[3]/div/div[1]/button";

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
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/span"));
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/input")).isSelected()) {
            click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[6]/input"));
        }
        findAndClick(Elements.REC_NOTE);
        findAndClick(Elements.EDIT);
        findAndClick(Elements.DELETE_BUTTON);
        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));
    }
}
