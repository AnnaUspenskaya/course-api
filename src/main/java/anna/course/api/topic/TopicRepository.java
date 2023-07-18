
package anna.course.api.topic;

import org.springframework.data.repository.CrudRepository;
//CrudRepository is a Spring Data JPA interface
//provides generic CRUD operations 
//Entity type - Topic 
//Primary key - String 
public interface  TopicRepository extends CrudRepository<Topic, String>{
    
}
