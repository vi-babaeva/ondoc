package ondoc.lkp.tests.creation;

import ondoc.lkp.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreationAllergies extends TestBase {
    
    @Test
    public void testCreationAllergies() {
        app.getNavigationHelper().gotoMedcard();
        app.getAllergiesHelper().goToInsertAllergies();
        int before = app.getAllergiesHelper().getAllergiesCount();
        app.getNavigationHelper().choseType();
        app.getAllergiesHelper().createAllergies();
        app.getAllergiesHelper().nameAllergies("Аллергия на лактозу");
        app.getAllergiesHelper().reactionAllergies("Сыпь на коже в виде крапивницы, дерматита, экземы. Одышка, насморк, чихание, бронхиальная астма, отек Квинке.");
        app.getNavigationHelper().save();
        app.getNavigationHelper().backToList();
        int after = app.getAllergiesHelper().getAllergiesCount();
        Assert.assertEquals(after, before + 1);
    }
}
