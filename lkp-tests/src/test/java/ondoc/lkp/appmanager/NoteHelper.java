package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoteHelper extends HelperBase {

    public NoteHelper(ChromeDriver wd) {
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

}
