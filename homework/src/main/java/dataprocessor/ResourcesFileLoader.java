package dataprocessor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Measurement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private String strJson= "";
    public ResourcesFileLoader(String fileName)  {
        Gson gson = new Gson();
        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("inputData.json").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        try {
            strJson = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        };


    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        List<Measurement> measurementList;
        Gson gson = new Gson();
        measurementList = gson.fromJson(strJson, new TypeToken<List<Measurement>>(){}.getType());
        return measurementList;
    }
}
