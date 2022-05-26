package action;

import java.util.*;

public abstract class AbstractMenu implements IAction {

    @Override
    public void execute() {
        System.out.println("-----------------------------------------------"); // divider
        show();
        System.out.println("-----------------------------------------------"); // divider
        showActions();

        readNextAction().execute();
    }

    private IAction readNextAction() {
        try {
            int input = new Scanner(System.in).nextInt();
            List<IAction> actions = new ArrayList<>(getMenuItems().values());
            return actions.get(input);
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            return readNextAction();
        }
    }

    private void showActions() {
        List<String> keyList = new ArrayList<>(getMenuItems().keySet());
        for (int i = 0; i < keyList.size(); i++) {
            System.out.printf("[%s] %s\t", i, keyList.get(i));
        }
        System.out.println();
    }

    public abstract void show();

    public abstract LinkedHashMap<String, IAction> getMenuItems();
}
