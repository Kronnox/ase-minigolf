package repository;

import file.CsvReader;
import model.Course;
import model.StrokeCount;
import model.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseRepository implements ICourseRepository{

    private final String COURSE_FILE_PATH = "courses.csv";
    private final List<Course> courses = new ArrayList<>();

    private final ITrackRepository trackRepository = new TrackRepository();

    public CourseRepository() {
        List<String[]> fileContent;
        try {
            fileContent = CsvReader.read(COURSE_FILE_PATH, "; ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        fileContent.forEach(line -> {
            Course course = new Course(line[0], line[1], Integer.parseInt(line[2]));

            // Add tracks
            for (int i = 3; i < line.length; i++) {
                Optional<Track> track = trackRepository.findById(UUID.fromString(line[i]));
                if (track.isEmpty()) {
                    System.out.printf("Track '%s' could not be found.\n", line[i]);
                    continue;
                }
                course.addTrack(track.get());
            }

            courses.add(course);
        });
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Optional<Course> findById(UUID id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findAny();
    }
}
