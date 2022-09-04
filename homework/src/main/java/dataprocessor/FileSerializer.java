package dataprocessor;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileSerializer implements Serializer {
    String fileName;
    private String strJson = "";

    public FileSerializer(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void serialize(Map<String, Double> data) {
        //формирует результирующий json и сохраняет его в файл
        Path path = null;



      //      path = Paths.get(ClassLoader.getSystemResource("inputData.json").toURI());
      //     String newFile = path.getParent().toString() + "\\" + fileName;
           path = Paths.get(fileName);


            




        Gson gson = new Gson();

        strJson = gson.toJson(data);
        try {
            if (!Files.exists(path)) {
                path = Files.createFile(path);
            }
            Files.writeString(path, strJson, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
