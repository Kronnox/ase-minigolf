package repository;

import model.Course;

import java.util.List;
import java.util.UUID;

public interface ICourseRepository {

    List<Course> findAllCourses();

    Course findCourseById(UUID id);
}
