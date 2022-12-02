package fr.polytech.covid.config;

import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class YAMLFilters {
    InputStream inputStream;

    {
        try {
            inputStream = new ClassPathResource("configFiles/UrlFilters.yaml").getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final Map<String, ArrayList<String>> data = new Yaml().load(inputStream);

    public ArrayList<String> getUrls (String filter){
        return data.getOrDefault(filter,new ArrayList<>());
    }
    public String getUrl(String filter){
        return data.getOrDefault(filter,new ArrayList<>()).get(0);
    }

}
