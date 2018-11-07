package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNote extends TestBase {

    @Test
    public void testDeleteNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().goToInsertNote();
        int before = app.getNoteHelper().getNoteCount();
        if (! app.getNoteHelper().isThereNote()) {
            app.getNoteHelper().createFullNote();
            app.getNavigationHelper().gotoMedcard();
        }
        app.getNoteHelper().deleteNote();
        app.getNoteHelper().goToInsertNote();
        app.getNavigationHelper().refreshPage();
        int after = app.getNoteHelper().getNoteCount();
        Assert.assertEquals(after, before - 1);
    }
}
