package action;

import app.MinigolfApplication;
import model.Course;
import repository.CourseRepository;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ShowCourseMenu extends AbstractMenu {

    private final Course course;

    public ShowCourseMenu(MinigolfApplication app, UUID courseId) {
        super(app);
        this.course = new CourseRepository().findById(courseId).orElseThrow();
    }

    @Override
    public void show() {
        System.out.println("Name: "+course.getName());
        System.out.println("Holes: "+course.getTracks().size());
        System.out.println("Max. strokes: "+course.getMaxStrokes());
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        return new LinkedHashMap<>(){{
            put("Play Course", new SelectCourseAction(app, course.getId()));
            put("Back", new StartGameMenu(app));
        }};
    }
}
