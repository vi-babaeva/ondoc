package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteCheckup extends TestBase {

    @Test
    public void testDeleteCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getCheckupHelper().deleteCheckup();
    }
}
