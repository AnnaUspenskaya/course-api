
package anna.course.api.course;

import anna.course.api.topic.*;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
//CrudRepository is a Spring Data JPA interface
//provides generic CRUD operations 
//Entity type - Course 
//Primary key - String 
public interface  CourseRepository extends CrudRepository<Course, String>{
    
    public List<Course> findByTopicId(String topicId);
}
