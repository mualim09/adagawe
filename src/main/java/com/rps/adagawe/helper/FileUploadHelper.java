package com.rps.adagawe.helper;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on June, 2021
 * @author RPS
 */

public class FileUploadHelper {

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";
    private static final String TARGET_DIR = "target/classes/static/uploads/";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy-hhmmss-SSS");

    public static String upload(MultipartFile file, String folder) {
        // normalize the file path
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(dateFormat.format(new Date())) + "." + extension;

        // save the file on the local file systems
        try {
            Path path = Paths.get(UPLOAD_DIR + folder + "/" + fileName);
            Files.copy(file.getInputStream(), path.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);

            Path path2 = Paths.get(TARGET_DIR + folder + "/" + fileName);
            Files.copy(file.getInputStream(), path2.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
