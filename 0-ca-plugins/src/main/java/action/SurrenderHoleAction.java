package action;

import app.MinigolfApplication;

public class SurrenderHoleAction implements IAction {

    private final MinigolfApplication app;

    public SurrenderHoleAction(MinigolfApplication app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.getSession().getCurrentScore().setToMax();
        app.getSession().goToNextPlayer();

        new PlayGameMenu(app).execute();
    }
}
