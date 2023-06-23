package anna.course.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //telling springboot that it's a staring point of application
public class CourseApiApp {

    public static void main(String[] args) {
        //calling a static method, a Springboot sublet container
        //set up default cofiguration 
        //performs class path scan
        //starts Tomcan server 
        SpringApplication.run(CourseApiApp.class, args);

    }
}
