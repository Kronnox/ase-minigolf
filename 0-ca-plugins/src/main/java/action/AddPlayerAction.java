package action;

import app.MinigolfApplication;
import exception.InvalidPlayernameException;

import java.util.Scanner;

public class AddPlayerAction implements IAction {

    private final MinigolfApplication app;

    public AddPlayerAction(MinigolfApplication app) {
        this.app = app;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.print("Enter playername: ");

        waitForInputAndCreatePlayer();

        new PlayerMenu(app).execute();
    }

    private void waitForInputAndCreatePlayer() {
        String input = new Scanner(System.in).nextLine();
        try {
            app.getPlayerService().createPlayer(input);
        } catch (InvalidPlayernameException e) {
            System.out.println(e.getLocalizedMessage());
            waitForInputAndCreatePlayer();
        }
    }
}
