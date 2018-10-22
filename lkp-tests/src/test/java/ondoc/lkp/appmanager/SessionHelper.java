package ondoc.lkp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase  {

    public SessionHelper(ChromeDriver wd) {
        super(wd);
    }

    public void login(String usermane, String password) {
        click(By.linkText("Войти"));
        type(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[1]/input"), usermane);
        type(By.xpath("//div[1]/main/div[1]/div/div[2]/form/div[3]/div[2]/input"), password);
        click(By.xpath("//div[1]/main/div[1]/div/div[2]/form/button"));
    }
}
