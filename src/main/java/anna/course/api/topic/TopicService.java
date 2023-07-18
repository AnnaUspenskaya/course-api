package anna.course.api.topic;

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
public class TopicService {

    @Autowired //provide automatic dependency injection 
    private TopicRepository topicRepository;
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spritng Boot", "Spring Boot Description"),
//            new Topic("java", "Core Java", "Core Java Description"),
//            new Topic("javaScript", "JavaScript", "JavaScript Description")
//    ));

    public List<Topic> getAllTopics() {
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);//methos reference 
        return topics;

    }

    public Optional<Topic> getTopic(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
