package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AllergiesHelper extends HelperBase {

    public AllergiesHelper(WebDriver wd) {
        super(wd);
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

    public void deleteAllergies() {
        wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/span")).click();
        if (!wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input")).isSelected()) {
            wd.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[1]/div[3]/label[7]/input")).click();
        }
        click(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]"));
        WebElement medcardElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div")));
        medcardElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/medcard-list/div/div[2]/div/div/medcard-list-item/div")).click();

        WebElement editElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/allergy-details/div/section/div/div[1]/div/div[3]/a/span")));
        editElement.findElement(By.xpath("//div[2]/user-layout/div/div/div/section/medcard-layout/ui-view/allergy-details/div/section/div/div[1]/div/div[3]/a/span")).click();

        WebElement deleteElement = (new WebDriverWait(wd, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")));
        deleteElement.findElement(By.xpath("//div[@class='widget']/div[3]/div/div[1]/medcard-delete-button/input")).click();

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
