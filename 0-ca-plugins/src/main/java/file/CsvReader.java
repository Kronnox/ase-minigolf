package file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvReader {

    public static List<String[]> read(String path, String delimiter) throws IOException {
        // only very basic implementation...
        List<String[]> result = new ArrayList<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: "+path);
        }
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            result.add(currentLine.split(delimiter));
        }

        return result;
    }
}
