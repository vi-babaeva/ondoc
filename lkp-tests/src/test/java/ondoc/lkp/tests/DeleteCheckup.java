package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteCheckup extends TestBase {

    @Test
    public void testDeleteCheckup() {
        app.getNavigationHelper().gotoMedcard();
        app.getCheckupHelper().deleteCheckup();
    }
}
