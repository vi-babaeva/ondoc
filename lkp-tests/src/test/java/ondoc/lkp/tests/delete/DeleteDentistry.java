package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteDentistry extends TestBase {

    @Test
    public void testDeleteDentistry() {
        app.getNavigationHelper().gotoMedcard();
        app.getDentistryHelper().goToInsertDentistry();
        int before = app.getDentistryHelper().getDentistryCount();
        if (! app.getDentistryHelper().isThereDentistry()) {
            app.getDentistryHelper().createFullDentisrty();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getDentistryHelper().deleteDentistry();
        app.getDentistryHelper().goToInsertDentistry();
        app.getNavigationHelper().refreshPage();
        int after = app.getDentistryHelper().getDentistryCount();
        Assert.assertEquals(after, before - 1);
    }
}
