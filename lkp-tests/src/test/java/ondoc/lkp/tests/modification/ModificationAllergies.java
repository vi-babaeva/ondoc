package ondoc.lkp.tests.modification;

import ondoc.lkp.tests.TestBase;
import org.testng.annotations.Test;

public class ModificationAllergies extends TestBase {

   @Test
    public void testModificationAllergies() {
       app.getNavigationHelper().gotoMedcard();
       app.getAllergiesHelper().goToInsertAllergies();
       if (! app.getAllergiesHelper().isThereAllergies()) {
           app.getAllergiesHelper().createFullAllergies();
           app.getNavigationHelper().gotoMedcard();
       }
       app.getAllergiesHelper().modificationAllergies();
       app.getNavigationHelper().save();
   }
}
