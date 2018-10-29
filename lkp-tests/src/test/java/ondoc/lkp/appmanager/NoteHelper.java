package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoteHelper extends HelperBase {

    public NoteHelper(WebDriver wd) {
        super(wd);
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

        WebElement medcardElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div")));
        medcardElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div/div/div[1]/div[2]/div")).click();

        WebElement editElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")));
        editElement.findElement(By.xpath("//div[@class='widget']/div[1]/div/div[3]/a/span")).click();

        WebElement deleteElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/note-create/notes-create-page/div/div[3]/div/div[1]/button")));
        deleteElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/note-create/notes-create-page/div/div[3]/div/div[1]/button")).click();

        click(By.xpath("//div[@class='custom-modal__modal']//strong[.='Удалить']"));

    }

}
