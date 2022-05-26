package action;

import java.util.LinkedHashMap;

public class StartGameMenu extends AbstractMenu {

    @Override
    public void show() {
        System.out.println("Please select a course!");
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        return new LinkedHashMap<>();
    }
}
