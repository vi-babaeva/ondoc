package ondoc.lkp.tests;

import org.testng.annotations.Test;

public class CreationAllergies extends TestBase {
    
    @Test
    public void testCreationAllergies() {
        app.getNavigationHelper().gotoMedcard();
        app.getNavigationHelper().choseType();
        app.createAllergies();
        app.nameAllergies("Аллергия на лактозу");
        app.reactionAllergies("Сыпь на коже в виде крапивницы, дерматита, экземы. Одышка, насморк, чихание, бронхиальная астма, отек Квинке.");
        app.getNavigationHelper().save();
        app.commentInAllergies();
    }
}
