package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationCheckup extends TestBase {

    @Test
    public void testModificationCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getCheckupHelper().goToInsertCheckup();
        int before = app.getCheckupHelper().getCheckupCount();
        if (! app.getCheckupHelper().isThereCheckup()) {
            app.getCheckupHelper().createFullCheckup();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getCheckupHelper().modificationCheckup();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getCheckupHelper().getCheckupCount();
        Assert.assertEquals(after, before);
    }
}
