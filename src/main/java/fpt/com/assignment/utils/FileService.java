package fpt.com.assignment.utils;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public String uploadFile(MultipartFile file);

    String uploadFile(MultipartFile file, String prefixPath);

    byte[] downloadFile(String fileName);

    boolean deleteFile(String fileName);
}
