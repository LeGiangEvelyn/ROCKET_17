package utils;

import java.io.File;
import java.nio.file.Files;

public class FileManager {
    //check file if exist
    public static boolean isFileExists(String pathFile) {
        return new File(pathFile).exists() ? true : false;
    }
    // Create file
    public static void createNewFile(String pathFile) throws Exception {

        if (isFileExists(pathFile)) {
            throw new Exception("Error! File exist!");
        }
        boolean result = new File(pathFile).createNewFile();
        System.out.println(result ? "Create file success!" : "Create file fail!");
    }
    public static void createNewFile(String path, String fileName) throws Exception {
        String pathFile = path + "//" + fileName;
        createNewFile(pathFile);
    }

    // Delete file
    public static void deleteFile(String pathFile) throws Exception {
        if (!isFileExists(pathFile)) {
            throw new Exception("File not exist!");
        }
        boolean result = new File(pathFile).delete();
        System.out.println(result ? "Delete file success!" : "Delete file fail!");
    }}
