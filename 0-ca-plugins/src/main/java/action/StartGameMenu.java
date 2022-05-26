package action;

import app.MinigolfApplication;
import repository.CourseRepository;

import java.util.LinkedHashMap;

public class StartGameMenu extends AbstractMenu {

    private final CourseRepository courseRepository;

    public StartGameMenu(MinigolfApplication app) {
        super(app);
        this.courseRepository = new CourseRepository();
    }

    @Override
    public void show() {
        System.out.println("Please select a course!");
    }

    @Override
    public LinkedHashMap<String, IAction> getMenuItems() {
        LinkedHashMap<String, IAction> courseMenus = new LinkedHashMap<>();

        courseRepository.findAll().forEach(
                course -> courseMenus.put(course.getName(), new ShowCourseMenu(app, course.getId()))
        );

        return courseMenus;
    }
}
