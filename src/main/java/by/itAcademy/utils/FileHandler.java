package by.itAcademy.utils;

import java.io.*;

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
