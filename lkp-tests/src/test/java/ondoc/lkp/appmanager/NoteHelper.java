package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoteHelper {
    private ChromeDriver wd;

    public NoteHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void descriptionNote(String descr) {
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).click();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).clear();
        wd.findElement(By.xpath("//div[@class='widget__textarea-wrapper']/textarea")).sendKeys(descr);
    }

    public void nameNote(String name) {
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).click();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).clear();
        wd.findElement(By.cssSelector("input.sc-dxgOiQ.jYQKwt")).sendKeys(name);
    }

    public void createNote() {
        wd.findElement(By.xpath("//div[1]/div/div[2]/medcard-type-modal/div[2]/div[3]/div[1]/div")).click();
    }
}
