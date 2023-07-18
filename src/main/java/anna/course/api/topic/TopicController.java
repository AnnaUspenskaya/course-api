package anna.course.api.topic;

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
public class TopicController {

    @Autowired //declare dependency 
    //GET  request , shows list of all topics
    private TopicService topicService;

    @RequestMapping("/topics") //automaticaly converte to JSON
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    //GET request, shows only 1 topic 
    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) { //pass variable from the path
        return topicService.getTopic(id);
    }

    //POST request creates new topic 
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    //PUT request updates topic
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    //DELETE request deletes topic 
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) { //pass variable from the path
        topicService.deleteTopic(id);
    }

}
