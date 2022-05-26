package repository;

import model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICourseRepository {

    List<Course> findAll();

    Optional<Course> findById(UUID id);
}
