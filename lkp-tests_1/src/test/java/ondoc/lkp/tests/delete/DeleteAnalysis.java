package ondoc.lkp.tests.delete;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class DeleteAnalysis extends TestBase {

    @Test
    public void testDeleteAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        app.getAnalysisHelper().deleteAnalysis();
    }
}

