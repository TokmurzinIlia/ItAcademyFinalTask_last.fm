package by.itAcademy.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.Files.probeContentType;

public class FileHandler {

    private FileHandler() {
    }

    public static void writeToFile(String content, String path, String fileNameWithExtension) throws IOException {
        FileWriter writer = new FileWriter(path + fileNameWithExtension);
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public static String readFile(String path, String fileNameWithExtension) {
        String readString = null;
        try {

            FileReader fr = new FileReader(path + fileNameWithExtension);
            BufferedReader reader = new BufferedReader(fr);
            readString = reader.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return readString;
    }
}
