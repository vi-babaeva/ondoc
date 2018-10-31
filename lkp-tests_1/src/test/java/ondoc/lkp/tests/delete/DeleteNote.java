package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteNote extends TestBase {

    @Test
    public void testDeleteNote() {
        app.getNavigationHelper().gotoMedcard();
        app.getNoteHelper().deleteNote();
    }
}
