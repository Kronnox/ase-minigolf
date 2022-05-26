package action;

import model.Course;
import repository.CourseRepository;

import java.util.LinkedHashMap;
import java.util.UUID;

public class ShowCourseMenu extends AbstractMenu {

    private final Course course;

    public ShowCourseMenu(UUID courseId) {
        this.course = new CourseRepository().findCourseById(courseId);
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
            put("Play Course", new ExitApplicationAction());
            put("Back", new StartGameMenu());
        }};
    }
}
