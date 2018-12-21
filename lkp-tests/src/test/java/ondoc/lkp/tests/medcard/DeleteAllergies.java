package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAllergies extends TestBase {

    @Test
    public void testDeleteAllergies() {
        app.getNavigationHelper().gotoMedcard();
        app.getAllergiesHelper().goToInsertAllergies();
        if (! app.getAllergiesHelper().isThereAllergies()) {
            app.getAllergiesHelper().createFullAllergies();
            app.getNavigationHelper().backToList();
        }
        int before = app.getAllergiesHelper().getAllergiesCount();
        app.getAllergiesHelper().deleteAllergies();
        app.getAllergiesHelper().goToInsertAllergies();
        app.getNavigationHelper().refreshPage();
        int after = app.getAllergiesHelper().getAllergiesCount();
        Assert.assertEquals(after, before - 1);
    }
}
