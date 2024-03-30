package me.scorchingflame;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DotEnv {
    private static Map<String, String> envVars;
    public DotEnv setUp(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            boolean created = file.createNewFile();
        }else {
            try (Reader reader = new FileReader(file);){
                BufferedReader bufferedReader = new BufferedReader(reader);
                bufferedReader.lines().forEach(s -> {
                    String[] env = s.split("=");
                    envVars.put(env[0], env[1]);
                });
                bufferedReader.close();
            } catch ( FileNotFoundException e){
                e.printStackTrace();
            }

        }
        return this;
    }
    public String getEnv(String key){
        return envVars.get(key);
    }
}
