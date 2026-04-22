package utils;

import java.io.File;

public class FileUtil {

    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static String getExtension(String path) {

        int dot = path.lastIndexOf(".");

        if(dot == -1)
            return "";

        return path.substring(dot + 1);
    }

    public static boolean isAllowedFile(String path) {

        String ext =
            getExtension(path).toLowerCase();

        return ext.equals("pdf") ||
               ext.equals("doc") ||
               ext.equals("docx") ||
               ext.equals("jpg") ||
               ext.equals("png");
    }
}