package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationNote extends TestBase {

    @Test
    public void testModificationNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().goToInsertNote();
        if (! app.getNoteHelper().isThereNote()) {
            app.getNoteHelper().createFullNote();
            app.getNavigationHelper().backToList();
        }
        int before = app.getNoteHelper().getNoteCount();
        app.getNoteHelper().modificationNote();
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getNoteHelper().getNoteCount();
        Assert.assertEquals(after, before);
    }
}
