package fpt.com.assignment.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

public class LocalFileService implements FileService {

    private final String storageDir;

    public LocalFileService(String storageDir) {
        this.storageDir = storageDir;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        return uploadFile(file, null);
    }

    @Override
    public String uploadFile(MultipartFile file, String prefixPath) {
        if (file.isEmpty()) {
            return null; // Xử lý trường hợp file rỗng
        }

        String fileName = file.getOriginalFilename();
        String storageDir = prefixPath != null ? this.storageDir + "/" + prefixPath + "/" : this.storageDir;

        try {
            Path destinationPath = Paths.get(storageDir, fileName);
            Files.createDirectories(destinationPath.getParent());
            Files.write(destinationPath,  file.getBytes());
            return destinationPath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Xử lý lỗi
        }
    }

    @Override
    public byte[] downloadFile(String fileName) {
        Path filePath = Paths.get(storageDir, fileName);
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteFile(String fileName) {
        Path filePath = Paths.get(storageDir, fileName);
        try {
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}