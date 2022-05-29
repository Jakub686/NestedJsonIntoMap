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
            HashMap<String, Object> sampleMap = new HashMap<>();
            sampleMap.put("1", new Person("a",new Address("b","c")));
            sampleMap.put("2", new Person("dddddddddddd",new Address("e","g")));
            sampleMap.put("3","aaa");

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
            Map<String, Object> map1 = mapper.readValue(new File(PATH), new TypeReference<Map<String, Object>>() {});
            //show map
            System.out.println("Map from Jason file: " + map1.get("1"));
            System.out.println("Map from Jason file: " + map1.get("2"));
            System.out.println("Map from Jason file: " + map1.get("3"));
        }catch (IOException e){
        }
    }
}
