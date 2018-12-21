package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCheckup extends TestBase {

    @Test
    public void testDeleteCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getCheckupHelper().goToInsertCheckup();
        if (! app.getCheckupHelper().isThereCheckup()) {
            app.getCheckupHelper().createFullCheckup();
            app.getNavigationHelper().backToList();
        }
        int before = app.getCheckupHelper().getCheckupCount();
        app.getCheckupHelper().deleteCheckup();
        app.getCheckupHelper().goToInsertCheckup();
        app.getNavigationHelper().refreshPage();
        int after = app.getCheckupHelper().getCheckupCount();
        Assert.assertEquals(after, before - 1);
    }
}
