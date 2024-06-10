package fpt.com.assignment.controller;

import fpt.com.assignment.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        // Xử lý upload file
        if (!file.isEmpty()) {
            try {
                fileService.uploadFile(file);
                return "redirect:/success.html";
            } catch (Exception e) {
                return "redirect:/error.html";
            }
        } else {
            return "redirect:/empty.html";
        }
    }
}