package me.scorchingflame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import okhttp3.Cache;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class crudGSON<K,V> {
    private String path;
    private File file;
    private Gson gson;
    private Integer maxSize;

    public MaxSizeHashMap<K,V> setUp(String path,Integer maxSize) throws IOException {
        this.path = path;
        this.maxSize = maxSize;
        file = new File(path);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        if (!file.exists()){
            boolean created = file.createNewFile();
            System.out.println(created ? "New File created" : "Failed to create new file :sob:");
        }else {
            Reader reader = new FileReader(file);
            MaxSizeHashMap<K, V> map = gson.fromJson(reader, new TypeToken<MaxSizeHashMap<K,V>>(){}.getType());
            if (map != null){
                map.setMaxSize(maxSize);
                return map;
            }else{
                System.out.println("No data found");
            }
        }
        return new MaxSizeHashMap<>(0);
    }

    public void save(Map<K,V> map) throws IOException {
        Writer writer = new FileWriter(file, false);
        gson.toJson(map, new TypeToken<MaxSizeHashMap<K,V>>(){}.getType() ,writer);
        writer.flush();
        writer.close();
    }

    public MaxSizeHashMap<K,V> reload() throws FileNotFoundException {
        Reader reader = new FileReader(file);
        MaxSizeHashMap<K, V> map = gson.fromJson(reader, new TypeToken<MaxSizeHashMap<K,V>>(){}.getType());
        map.setMaxSize(this.maxSize);
        return map;
    }
}
