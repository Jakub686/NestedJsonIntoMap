import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class klasa {
    public static void main(String[] args) throws IOException {

        //hashmap
        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("1","aaa");
        sampleMap.put("3", "bbb");
        sampleMap.put("2", "ccc");


        //serialization map into json
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonStr = mapper.writeValueAsString(sampleMap);
        //Print Json before save in a file
        System.out.println("Json before save in a file" + jsonStr);


        //wirte json into file
        BufferedWriter write = new BufferedWriter(new FileWriter("D:\\java examples\\mapper\\ObjectMapping\\src\\main\\java\\output.txt"));
        write.write(jsonStr);
        write.close();

        //middle poion

        //read from file
        BufferedReader reader = new BufferedReader(new FileReader("D:\\java examples\\mapper\\ObjectMapping\\src\\main\\java\\output.txt"));
        System.out.println(reader.readLine());
        reader.close();

        //deserialization json into map

        Map<String, String> map1 = mapper.readValue(jsonStr.getBytes(), Map.class);

        //show mpa
        System.out.println("Map from Jason" + map1);

    }
}
