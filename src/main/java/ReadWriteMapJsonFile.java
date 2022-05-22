import java.io.*;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ReadWriteMapJsonFile {
    static String PATH ="D:\\java examples\\mapper\\ObjectMapping\\src\\main\\java\\db.json"; // save and read path
    public static void main(String[] args) {
        try {
            //hashmap
            HashMap<String, String> sampleMap = new HashMap<>();
            sampleMap.put("1", "aaa");
            sampleMap.put("3", "bbb");
            sampleMap.put("2", "ccc");

            //serialization map into json
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonStr = mapper.writeValueAsString(sampleMap);
            //Print Json before save in a file
            System.out.println("Json before save in a file" + jsonStr);

            //write json into file

            BufferedWriter write = new BufferedWriter(new FileWriter(PATH));
            write.write(jsonStr);
            write.close();

            //-----------------------------------------------------

            //read map from json file
            Map<String, String> map1 = mapper.readValue(new File(PATH), new TypeReference<Map<String, String>>() {});
            //show map
            System.out.println("Map from Jason: " + map1.get("1"));
            System.out.println("Map from Jason: " + map1.get("2"));
            System.out.println("Map from Jason: " + map1.get("3"));
        }catch (IOException e){
        }
    }
}
