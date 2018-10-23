package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteAllergies extends TestBase {

    @Test
    public void testDeleteAllergies() {
        app.getNavigationHelper().gotoMedcard();
        app.getAllergiesHelper().deleteAllergies();
    }
}
