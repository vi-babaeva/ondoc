package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNote extends TestBase {

    @Test
    public void testDeleteNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().goToInsertNote();
        if (! app.getNoteHelper().isThereNote()) {
            app.getNoteHelper().createFullNote();
            app.getNavigationHelper().backToList();
        }
        int before = app.getNoteHelper().getNoteCount();
        app.getNoteHelper().deleteNote();
        app.getNoteHelper().goToInsertNote();
        app.getNavigationHelper().refreshPage();
        int after = app.getNoteHelper().getNoteCount();
        Assert.assertEquals(after, before - 1);
    }
}
