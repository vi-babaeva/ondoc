package ondoc.lkp.tests.medcard;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModificationAllergies extends TestBase {

   @Test
    public void testModificationAllergies() {
       app.getNavigationHelper().gotoMedcard();
       app.getAllergiesHelper().goToInsertAllergies();
       if (! app.getAllergiesHelper().isThereAllergies()) {
           app.getAllergiesHelper().createFullAllergies();
           app.getNavigationHelper().backToList();
       }
       int before = app.getAllergiesHelper().getAllergiesCount();
       app.getAllergiesHelper().modificationAllergies();
       app.getNavigationHelper().save();
       app.getNavigationHelper().backToList();
       int after = app.getAllergiesHelper().getAllergiesCount();
       Assert.assertEquals(after, before);
   }
}
