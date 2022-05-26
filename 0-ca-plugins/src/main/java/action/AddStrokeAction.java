package action;

import app.MinigolfApplication;

public class AddStrokeAction implements IAction {

    private final MinigolfApplication app;

    public AddStrokeAction(MinigolfApplication app) {
        this.app = app;
    }

    @Override
    public void execute() {
        boolean reachedLimit = app.getSession().getCurrentScore().increment();
        if (reachedLimit) {
            app.getSession().goToNextPlayer();
        }

        new PlayGameMenu(app).execute();
    }
}
