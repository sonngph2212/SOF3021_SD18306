package fpt.com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "fpt.com.assignment")
public class AssignmentApplication extends SpringBootServletInitializer {
//public class AssignmentApplication {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AssignmentApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

}
