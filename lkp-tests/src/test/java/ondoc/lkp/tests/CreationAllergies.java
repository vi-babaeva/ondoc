package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class CreationAllergies extends TestBase {
    
    @Test
    public void testCreationAllergies() {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.getAllergiesHelper().createAllergies();
        app.getAllergiesHelper().nameAllergies("Аллергия на лактозу");
        app.getAllergiesHelper().reactionAllergies("Сыпь на коже в виде крапивницы, дерматита, экземы. Одышка, насморк, чихание, бронхиальная астма, отек Квинке.");
        app.getNavigationHelper().save();
        app.getAllergiesHelper().commentInAllergies();
    }
}
