package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class DeleteAnalysis extends TestBase {

    @Test
    public void testDeleteAnalysis() {
        app.getNavigationHelper().gotoMedcard();
        app.getAnalysisHelper().deleteAnalysis();
    }
}

