package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationDentistry extends TestBase {

    @Test
    public void testModificationDentistry() {
        app.getNavigationHelper().gotoMedcard();
        app.getDentistryHelper().goToInsertDentistry();
        if (! app.getDentistryHelper().isThereDentistry()) {
            app.getDentistryHelper().createFullDentisrty();
            app.getNavigationHelper().backToList();
        }
        int before = app.getDentistryHelper().getDentistryCount();
        app.getDentistryHelper().modificationDentistry();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getDentistryHelper().getDentistryCount();
        Assert.assertEquals(after, before);
    }
}
