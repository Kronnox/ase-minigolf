package action;

import app.MinigolfApplication;
import model.Course;
import repository.CourseRepository;

import java.util.UUID;

public class SelectCourseAction implements IAction {

    private final MinigolfApplication app;

    private final Course course;

    public SelectCourseAction(MinigolfApplication app, UUID courseId) {
        this.app = app;
        course = new CourseRepository().findById(courseId).orElseThrow();
    }
    @Override
    public void execute() {
        app.getSession().setCurrentCourse(course);

        new PlayerMenu(app).execute();
    }
}
