package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCheckup extends TestBase {

    @Test
    public void testDeleteCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getCheckupHelper().goToInsertCheckup();
        int before = app.getCheckupHelper().getCheckupCount();
        if (! app.getCheckupHelper().isThereCheckup()) {
            app.getCheckupHelper().createFullCheckup();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getCheckupHelper().deleteCheckup();
        app.getCheckupHelper().goToInsertCheckup();
        app.getNavigationHelper().refreshPage();
        int after = app.getCheckupHelper().getCheckupCount();
        Assert.assertEquals(after, before - 1);
    }
}
