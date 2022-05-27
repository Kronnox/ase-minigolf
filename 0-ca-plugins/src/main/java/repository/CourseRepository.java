package repository;

import model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseRepository implements ICourseRepository{

    List<Course> courses = new ArrayList<>(){{
        add(new Course("7da8e2d3-7932-4821-9749-e39404214e95", "TestCourse 1", 4));
        add(new Course("7b2970cb-0fe1-4c12-885f-51d6ca305a61", "TestCourse 2", 5));
        add(new Course("16848460-b80b-4ec9-a2d5-cf831a6cd8f4", "TestCourse 3", 4));
        add(new Course("7b1cd5b6-c5da-4be4-843a-4b64892aabb1", "TestCourse 4", 6));
    }};

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Optional<Course> findById(UUID id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findAny();
    }
}
