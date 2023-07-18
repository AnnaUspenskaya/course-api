package anna.course.api.course;

import anna.course.api.course.*;
import anna.course.api.topic.Topic;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired //declare dependency 
    //GET  request , shows list of all courses
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses") //automaticaly converte to JSON
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    //GET request, shows only 1 course 
    @RequestMapping("/topics/{topicsId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) { //pass variable from the path
        return courseService.getCourse(id);
    }

    //POST request creates new course 
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String  topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    //PUT request updates course
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
    }

    //DELETE request deletes course 
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) { //pass variable from the path
        courseService.deleteCourse(id);
    }

}
