package anna.course.api.course;

import anna.course.api.topic.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//No connection to the database required
//the framework sees the embedded Drby database in the classpath
//and assumes that to be the databese to connect to

//business service 
@Service
public class CourseService {

    @Autowired //provide automatic dependency injection 
    private CourseRepository courseRepository;
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring", "Spritng Boot", "Spring Boot Description"),
//            new Course("java", "Core Java", "Core Java Description"),
//            new Course("javaScript", "JavaScript", "JavaScript Description")
//    ));

    public List<Course> getAllCourses(String topicId) {
        //return topics;
        List<Course> topics = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(topics::add);//methos reference 
        return topics;

    }

    public Optional<Course> getCourse(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        //topics.add(topic);
        courseRepository.save(course);
    }

    void updateCourse(Course topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Course t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        courseRepository.save(topic);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
