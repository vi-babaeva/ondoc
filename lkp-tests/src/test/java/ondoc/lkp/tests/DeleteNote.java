package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteNote extends TestBase {

    @Test
    public void testDeleteNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().deleteNote();
    }
}
