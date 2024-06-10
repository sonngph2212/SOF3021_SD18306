package fpt.com.assignment.config;

import fpt.com.assignment.utils.FileService;
import fpt.com.assignment.utils.LocalFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileServiceConfig {

    @Bean
    public FileService fileService() {
        String typeFile = System.getenv("FILE_SERVICE");

        if (typeFile.equals("local")) {
            return new LocalFileService("uploads/");
        } else {
            return null;
        }
    }
}
