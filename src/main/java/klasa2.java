import java.io.File;    // for reading file data
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class klasa2 {
    public static void main(String args[]) {
        // create instance of the ObjectMapper class to map JSON data
        ObjectMapper mapper = new ObjectMapper();
        // create instance of the File class
        File fileObj = new File("D:\\java examples\\mapper\\ObjectMapping\\src\\main\\java\\output2.json");
        // use try-catch block to convert JSON data into Map
        try {
            // read JSON data from file using fileObj and map it using ObjectMapper and TypeReference classes
            Map<String, Object> userData = mapper.readValue(
                    fileObj, new TypeReference<Map<String, Object>>() {
                    });
            // print all key-value pairs
            System.out.println("1 : " + userData.get("1"));
            System.out.println("2 : " + userData.get("2"));
            System.out.println("2 : " + userData.get("3"));

        } catch (Exception e) {
            // show error message
            e.printStackTrace();
        }
    }
}
