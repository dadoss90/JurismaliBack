package com.jurismali.jurismaliback.Models;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFile {
    public static String localhost = "http://127.0.0.1/";
    public static String serveruser = localhost + "jurismali/files/utilisateur/";
    public static String servervehicule = localhost + "jurismali/files/droit/";
    public static String Vehiculelocation = "C:/xampp/htdocs/jurismali/files/droit/";
    public static String Userlocation = "C:/xampp/htdocs/jurismali/files/utilisateur/";
    public static String save(String typeImage, MultipartFile file, String fileName) {
        String src = "";
        String server = "";
        String location = "";
        if (typeImage == "user") {
            location = Userlocation;
            server = serveruser;
        } else {
            location = Vehiculelocation;
            server = servervehicule;
        }

        try {
            Path filePath = Paths.get(location + fileName);

            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.copy(file.getInputStream(), filePath);
                src = server + fileName ;
            } else {
                Files.delete(filePath);
                Files.copy(file.getInputStream(), filePath);
                src = server + fileName ;
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
            src = null;
        }

        return src;
    }
}
