package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteAllergies extends TestBase {

    @Test
    public void testDeleteAllergies() {
        app.getNavigationHelper().gotoMedcard();
        if (!app.getAllergiesHelper().isThereAllergies()) {
            app.getAllergiesHelper().createFullAllergies();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getAllergiesHelper().deleteAllergies();
    }
}
