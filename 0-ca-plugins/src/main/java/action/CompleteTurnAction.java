package action;

import app.MinigolfApplication;

public class CompleteTurnAction implements IAction {

    private final MinigolfApplication app;

    public CompleteTurnAction(MinigolfApplication app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.getSession().goToNextPlayer();

        new PlayGameMenu(app).execute();
    }
}
