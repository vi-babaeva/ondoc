package ondoc.lkp;

import org.testng.annotations.Test;

public class CreationAllergies extends TestBase {
    
    @Test
    public void testCreationAllergies() {
        gotoMedcard();
        choseType();
        createAllergies();
        nameAllergies("Аллергия на лактозу");
        reactionAllergies("Сыпь на коже в виде крапивницы, дерматита, экземы. Одышка, насморк, чихание, бронхиальная астма, отек Квинке.");
        save();
        commentInAllergies();
    }
}
